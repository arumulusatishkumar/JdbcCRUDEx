package com.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.config.AppConfig;
import com.app.mapper.EmployeeMapper;
import com.app.model.Employee;

public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jt=ac.getBean("jtObj",JdbcTemplate.class);
		/*
		 * String sql="insert into emptab values(?,?,?)"; int
		 * count=jt.update(sql,6,"F",1000); System.out.println("Data Inserted" +count);
		 */

		//Update emptab 
		/*
		 * String sql="update emptab set ename=? where eid=?"; int
		 * count=jt.update(sql,"G",1); System.out.println("Updated Successfully"+count);
		 */
		//delete from empid
		/*
		 * String sql="delete from emptab where eid=?"; int count=jt.update(sql,1);
		 * System.out.println("Deleted Successfully");
		 */
		
		//select one row using queryForObject and RowMapper interface.
		String sql="select * from emptab where eid=?";
		EmployeeMapper em=new EmployeeMapper();
		Employee e=jt.queryForObject(sql, em, 2);
		System.out.println(e);
		
		
		//select multiple rows from emptab
		String sql1="select * from emptab where ename=?";
		EmployeeMapper em1=new EmployeeMapper();
		List<Employee> e1=jt.query(sql1, em1, "A");
		System.out.println(e1);
	}
}
