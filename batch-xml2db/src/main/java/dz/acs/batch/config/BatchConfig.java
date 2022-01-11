package dz.acs.batch.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.thoughtworks.xstream.XStream;

import dz.acs.batch.dao.StudentItemPreparedStatementSetter;
import dz.acs.batch.model.Student;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private StepBuilderFactory  stepBuilderFactory;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public StaxEventItemReader<Student> readDataFromXml()
	{
		
		StaxEventItemReader<Student> reader = new StaxEventItemReader<>();
		
		reader.setResource(new FileSystemResource("C:\\work-elit-2021\\spring-int\\batch-xml2db\\input\\students-2022-01.xml"));
		reader.setFragmentRootElementName("Student");
		Map<String,String> aliasMap = new HashMap<>();
		aliasMap.put("Student", "dz.acs.batch.model.Student");
		
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliasMap);
		XStream xstream = marshaller.getXStream();
		
		Class<?>[] classes = new Class[] { Student.class};		
		xstream.allowTypes(classes);
		xstream.allowTypesByWildcard(new String[] { 
		        "dz.acs.batch.model.**"});
		reader.setUnmarshaller(marshaller);
		
		return reader;
	}
	@Bean
	public JdbcBatchItemWriter<Student> writeDataInDB(){
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource);
		
		writer.setSql("""
				INSERT INTO STUDENT (ID,FIRSTNAME,LASTNAME,EMAIL)
				VALUES (?,?,?,?)
				""");
		writer.setItemPreparedStatementSetter(new StudentItemPreparedStatementSetter());
		return writer;
	}
	
	@Bean
	public Step executeStudentImportStep(){
		return stepBuilderFactory.get("executeStudentImportStep")
				.<Student,Student>chunk(3)
				.reader(readDataFromXml())
				.writer(writeDataInDB())
				.build();
	}
	
	@Bean
	public Job processStudentJob(){
		return jobBuilderFactory.get("processStudentJob")
				.incrementer(new RunIdIncrementer())
				.flow(executeStudentImportStep())
				.end()
				.build();
	}
	
	

}
