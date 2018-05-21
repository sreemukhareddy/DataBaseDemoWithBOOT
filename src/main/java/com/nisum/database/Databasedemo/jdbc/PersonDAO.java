package com.nisum.database.Databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nisum.database.Databasedemo.entity.Person;

@Repository   /*though we are not using the url's to the database, datasource and the database name , all these things are configured with auto configuration with spring boot */
public class PersonDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> getAllPersons(){
		return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person getPerson(int id) {
		return jdbcTemplate.queryForObject
				("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
		//return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID=?",new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM PERSON WHERE ID = ?",new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into Person (id,name,location,birth_date) "
				+ "values(?,?,?,?)",
				new Object[] {person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
	}
}
