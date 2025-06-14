package CodewithHarry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CodewithHarry.entites.Doctor;
import CodewithHarry.exception.DoctorNotFoundException;
import CodewithHarry.repo.DoctorRepo;
import CodewithHarry.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo repo;
	
	@Override
	public Integer saveDoctor(Doctor doc) {
		
		return repo.save(doc).getId();
	}

	@Override
	public List<Doctor> getAllDoctor() {
		
		return  repo.findAll();
	}

	@Override
	public void removeDoctor(Integer id) {
		//repo.deleteById(id);
		repo.delete(getOneDoctor(id));
	}

	@Override
	public Doctor getOneDoctor(Integer id) {
		return repo.findById(id).orElseThrow(
				()-> new DoctorNotFoundException(id+" not exist"));
		 
	}

	@Override
	public void updateDoctor(Doctor doc) {
		if(repo.existsById(doc.getId()))
		{
			repo.save(doc);
		}else {
			throw new DoctorNotFoundException(doc.getId()+"id not exist");
		}
		
	}

}
