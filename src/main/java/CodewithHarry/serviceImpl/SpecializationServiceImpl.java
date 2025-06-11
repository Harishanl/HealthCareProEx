package CodewithHarry.serviceImpl;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CodewithHarry.entites.Specialization;
import CodewithHarry.exception.SpecializationNotFoundException;
import CodewithHarry.repo.SpecializationRepository;
import CodewithHarry.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Autowired
	private SpecializationRepository repo;

	@Override
	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Long id) {
		//repo.deleteById(id);
		repo.delete(getOneSpecialization(id));
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization>  optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new SpecializationNotFoundException(id+ " Not Found");
		}
		/*return repo.findById(id).orElseThrow(
				()-> new SpecializationNotFoundException(id+ " Not Found")
				);*/
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
	}

	@Override
	public boolean isSpecCodeExist(String specCode) {
		/*Integer count = repo.getSpecCodeCount(specCode);
		boolean exist = count>0 ? true : false;
		return exist;*/
		return repo.getSpecCodeCount(specCode)>0;
	}
	
	@Override
	public boolean isSpecCodeExistForEdit(String specCode, Long id) {
		return repo.getSpecCodeCountForEdit(specCode,id)>0;
	}

	@Override
	public Map<Long, String> getSpecIdAndName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * @Override public Map<Long, String> getSpecIdAndName() { List<Object[]> list =
	 * repo.getSpecIdAndName(); Map<Long,String> map =
	 * MyCollectionsUtil.convertToMap(list); return map; }
	 */
}
