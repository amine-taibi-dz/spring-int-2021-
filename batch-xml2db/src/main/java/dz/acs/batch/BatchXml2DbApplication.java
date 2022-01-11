package dz.acs.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thoughtworks.xstream.XStream;

import dz.acs.batch.model.Student;

@SpringBootApplication
public class BatchXml2DbApplication {

	public static void main(String[] args) {
		Class<?>[] classes = new Class[] { Student.class};
		XStream xstream = new XStream();		
		xstream.allowTypes(classes);
		xstream.allowTypesByWildcard(new String[] { 
		        "dz.acs.batch.model.**"});
		SpringApplication.run(BatchXml2DbApplication.class, args);
	}

}
