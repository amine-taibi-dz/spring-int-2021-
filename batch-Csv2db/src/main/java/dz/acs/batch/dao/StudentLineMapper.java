package dz.acs.batch.dao;

import org.springframework.batch.item.file.LineMapper;

import dz.acs.batch.model.Student;

public class StudentLineMapper implements LineMapper<Student> {

	@Override
	public Student mapLine(String line, int lineNumber) throws Exception {
		
		return null;
	}

}
