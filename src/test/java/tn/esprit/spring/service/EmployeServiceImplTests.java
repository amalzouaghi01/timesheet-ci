package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployeServiceImplTests {
	
	
	
	
	
	@Autowired 
	IEmployeService employeService;
	

	@Autowired
	EmployeRepository employeRepository;
	
	
	
	@Test
	public void testAddOrUpdateEmploye()  {
		
		Employe e = new Employe("maher", "gharbi", "maher.gharbi1@esprit.tn","info",true, Role.INGENIEUR);
		
		employeService.addOrUpdateEmploye(e); 
		
	    assertEquals(e.getNom(), "maher");
	      		       
	}
	
	@Test
	public void testGetEmployePrenomById() {
	
		
		
		Employe e = new Employe("mohamed", "gharbi", "mohamed@gmail.com","telecom",true, Role.INGENIEUR);
		
		employeService.addOrUpdateEmploye(e); 
		
		String employePrenom = employeService.getEmployePrenomById(14); 
		
	
			 
		assertEquals(e.getPrenom(), employePrenom);
		
	
	}
	
	
	

	@Test
	public void testGetAllEmployes() {
		
		List<Employe> listEmployes = employeService.getAllEmployes(); 
		// if there are 5 users in DB : 
		assertEquals(33, listEmployes.size());
	}
	
	
	@Test
	public void testDeleteEmployeById() {
		
		
		Employe e = new Employe("maher", "gharbi", "maher.gharbi1","info",false, Role.INGENIEUR);
		
		employeService.addOrUpdateEmploye(e); 
		
	    employeRepository.deleteById(15);

	    boolean exists = employeRepository.existsById(15);
		assertEquals(false, exists);
	}
	
	
	
	

}
