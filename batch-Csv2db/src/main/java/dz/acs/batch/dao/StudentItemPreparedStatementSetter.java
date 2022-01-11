package dz.acs.batch.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import dz.acs.batch.model.Student;

public class StudentItemPreparedStatementSetter implements ItemPreparedStatementSetter<Student> {

	@Override
	public void setValues(Student item, PreparedStatement ps) throws SQLException {
		ps.setInt(1, item.getId());
		ps.setString(2, item.getFirstName());
		ps.setString(3, item.getLastName());
		ps.setString(4, item.getEmail());
	}

}
