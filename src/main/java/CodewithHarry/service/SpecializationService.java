package CodewithHarry.service;

import java.util.List;

import CodewithHarry.entites.Specialization;

public interface SpecializationService {

	public Long saveSpecialization(Specialization spec);
	
	public List<Specialization> getAllSpecialization();
	
	public void removeSpecialization(Long id);
	public Specialization getOneSpecialization(Long id); 
	public void updateSpecialization(Specialization spec);
}
