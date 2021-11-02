package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;

import tn.esprit.spring.repository.EmployeRepository;


@Service
public abstract class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;


	
	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId(); 
	}


	public String getEmployePrenomById(int employeId) {
		Employe employeManagedEntity = employeRepository.findById(employeId).get();
		return employeManagedEntity.getPrenom();
	}
	 
	public void deleteEmployeById(int employeId)
	{
		Optional<Employe> emp = employeRepository.findById(employeId);
		if(emp.isPresent()) {
			Employe employe = emp.get();	


		
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}

		employeRepository.delete(employe);
	}
	}



	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}




	
	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

}