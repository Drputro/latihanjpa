package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {

	@Autowired
	EmployeeDAO employeeDAO;
	
	//@Bean
	//public List<Employee> getAll(){
		//List<Employee> employees=employeeDAO.getAll();
//		for (Employee employee: employees) {
//			System.out.println("ID: "+employee.getId());
//			System.out.println("Name: "+employee.getName());
//			System.out.println("Address: "+employee.getAddress());
//			System.out.println("DOB: "+employee.getDob());
//			System.out.println("====================================");
			
//		}
//		return employees;
//	}
	@Bean
	public Employee getById() {
		Employee employee= employeeDAO.getById(2);
//		
//		System.out.println("getById=2");
//		System.out.println("ID: "+employee.getId());
//		System.out.println("Name: "+employee.getName());
//		System.out.println("Address: "+employee.getAddress());
//		System.out.println("DOB: "+employee.getDob());
//		System.out.println("====================================");
		
		return employee;
	}
	//@Bean
	public boolean save() {
		try {
			Employee employee= new Employee();
			
			employee.setName("abcd");
			employee.setAddress("defg");
			
			String dateString="2019-07-01";
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);
			
			employeeDAO.save(employee);
			System.out.println("Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}
	}
	
	//@Bean
		public boolean update() {
		try {
			Employee employee= new Employee();
			
			employee.setId(4);
			employee.setName("abcd");
			employee.setAddress("defg");
			
			String dateString="2019-07-01";
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);
			
			employeeDAO.update(employee);
			System.out.println("Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(5);
			System.out.println("Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Dihapus");
			e.printStackTrace();
			return false;
		}
	}
	
	@Bean
	public List<Employee> getByName() {
		List<Employee> employees = employeeDAO.getByName("abc");
		
		for (Employee employee: employees) {
			System.out.println("ID: "+employee.getId());
			System.out.println("Name: "+employee.getName());
			System.out.println("Address: "+employee.getAddress());
			System.out.println("DOB: "+employee.getDob());
			System.out.println("====================================");
			
		}
		return employees;
	}
	
}
