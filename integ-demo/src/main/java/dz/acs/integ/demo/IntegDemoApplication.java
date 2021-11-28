package dz.acs.integ.demo;

import java.io.File;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.EnableIntegrationManagement;
import org.springframework.integration.core.GenericSelector;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import dz.acs.integ.demo.properties.FilesProperties;
import dz.acs.integ.demo.service.FileService;
import dz.acs.integ.demo.service.LinesSplitterService;
import dz.acs.integ.demo.service.PaiementGateway;
import dz.acs.integ.demo.service.PaiementService;

@SpringBootApplication
@EnableIntegration
@EnableIntegrationManagement
@IntegrationComponentScan("dz.acs.integ.demo")
@EnableJms
@EnableJpaRepositories
public class IntegDemoApplication  implements CommandLineRunner{
	
	@Autowired
	public FilesProperties filesProperties;

	public static void main(String[] args) {
		SpringApplication.run(IntegDemoApplication.class, args);
	}

	@Autowired
	public PaiementService paiementService;


	@Bean
	public IntegrationFlow readingInputFiles(AmqpTemplate amqpTemplate) {
		return IntegrationFlows
				.from(sourceDirectory(), configurer -> configurer.poller(Pollers.fixedDelay(1_000) ))
				.filter(onlyTinyDotIn()).channel("filtredIn")
				.handle(fileService, "process").channel("file-lines")
				.split(linesSplitterService).channel("lines")
				.handle(paiementService).channel("paiements")
				.to(amqpChannelFlow());
	}
	@Bean
	public IntegrationFlow amqpChannelFlow() {
		return IntegrationFlows.from(paiements())
				.handle(Amqp.outboundAdapter(amqpTemplate)
						.routingKey("queue-paiement")) // default exchange - route to queue 'queue-paiement'
				.get();
	}
	@Bean
	public MessageChannel amqpOutboundChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel errorChannel() {
		return new DirectChannel();
	}

	@Autowired
	public AmqpTemplate amqpTemplate;

	

	@Autowired
	public PaiementGateway gateway;

	@Autowired
	public FileService fileService;

	@Autowired
	public LinesSplitterService linesSplitterService;

	@Bean("filesIn")
	public DirectChannel filesIn() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow amqpOutbound(AmqpTemplate amqpTemplate,
			MessageChannel amqpOutboundChannel) {
		return IntegrationFlows.from(amqpOutboundChannel)
				.handle(Amqp.outboundAdapter(amqpTemplate)
						.routingKey("queue1")) // default exchange - route to queue 'queue1'
				.get();
	}

	@Bean("paiements")	
	public DirectChannel paiements() {
		return new DirectChannel();
	}

	@Bean("filtredIn")
	public DirectChannel filtredIn() {
		return new DirectChannel();
	}

	@Bean("file-lines")
	public DirectChannel filesLines() {
		return new DirectChannel();
	}

	@Bean("lines")
	public DirectChannel lines() {
		return new DirectChannel();
	}

	@Bean
	public MessageHandler targetDirectory() {
		FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(filesProperties.getOut()));
		handler.setFileExistsMode(FileExistsMode.REPLACE);
		handler.setDeleteSourceFiles(true);
		handler.setExpectReply(false);
		return handler;
	}

	@Bean
	public GenericSelector<File> onlyTinyDotIn() {
		return new GenericSelector<File>() {
			@Override
			public boolean accept(File source) {
				return (source.getName().endsWith(filesProperties.getExt()) && source.length()<filesProperties.getMaxLen());
			}
		};
	}
	@Bean
	public MessageSource<File> sourceDirectory() {
		FileReadingMessageSource messageSource = new FileReadingMessageSource();
		messageSource.setDirectory(new File(filesProperties.getIn()));

		return messageSource;
	}
	@Override
	public void run(String... args) throws Exception {
		//gateway.operatePaiement("test");
	}

}
