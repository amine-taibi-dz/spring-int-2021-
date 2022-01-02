package dz.acs.si.demo1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
@EnableJms
@SpringBootApplication
@ImportResource({ "classpath:integration/ftp2db.xml"})
@PropertySource(value = {"classpath:params.properties","classpath:ftp.properties",
		                 "classpath:paths.properties","classpath:db.properties"})
public class DemoFTPFileDbApplication {
	 
	@Bean("datasource1")
	public DataSource getDataSource1(
			@Value("${db1.driver}")String driver,
			@Value("${db1.url}")String url,
			@Value("${db1.username}")String username,
			@Value("${db1.password}")String password) { 
		DataSourceBuilder<?> dataSourceBuilder =  DataSourceBuilder.create(); 
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return (DataSource)dataSourceBuilder.build(); 
	}

	@Bean("datasource2")
	public DataSource getDataSource2(
			@Value("${db2.driver}")String driver,
			@Value("${db2.url}")String url,
			@Value("${db2.username}")String username,
			@Value("${db2.password}")String password) { 
		DataSourceBuilder<?> dataSourceBuilder =  DataSourceBuilder.create(); 
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return (DataSource)dataSourceBuilder.build(); 
	}
	
	@Bean("jdbcTemplate1")
	public JdbcTemplate jdbcTemplate1( @Qualifier("datasource1") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
	
	@Bean("jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2( @Qualifier("datasource2") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
	
	public static void main(String[] args) throws Exception {
		final ConfigurableApplicationContext ctx = SpringApplication.run(DemoFTPFileDbApplication.class, args);
		// Tests ..
//		DefaultFtpSessionFactory dfsf = ctx.getBean("ftpClientFactory",DefaultFtpSessionFactory.class);
//		FtpSession session = dfsf.getSession();
//		FTPClient clientInstance = session.getClientInstance();
//		int pwd = clientInstance.pwd();
//		System.out.println(pwd);
//		session.close();
		
		
	}
}