package dz.acs.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

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
	public FlatFileItemReader<Student> readerFromCsv(){
		FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource("C:\\work-elit-2021\\spring-int\\batch-Csv2db\\input\\students-2022-01.csv"));
		
		DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<Student>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames(Student.names());
		
		BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<Student>();
		fieldSetMapper.setTargetType(Student.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper );
		reader.setLineMapper(defaultLineMapper);
		return reader;
	}
	
	
	@Bean
	public JdbcBatchItemWriter<Student> writeDataInDB(){
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource);
		
		writer.setSql("""
				INSERT INTO STUDENT_CSV (ID,FIRSTNAME,LASTNAME,EMAIL)
				VALUES (?,?,?,?)
				""");
		writer.setItemPreparedStatementSetter(new StudentItemPreparedStatementSetter());
		return writer;
	}
	
	@Bean
	public Step executeStudentImportStep(){
		return stepBuilderFactory.get("executeStudentImportStep")
				.<Student,Student>chunk(3)
				.reader(readerFromCsv())
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
