package CodewithHarry.service;

import java.util.List;

import CodewithHarry.entites.Doctor;

public interface DoctorService {

	public Integer saveDoctor(Doctor doc);

	public List<Doctor> getAllDoctor();

	public void removeDoctor(Integer id);

	public Doctor getOneDoctor(Integer id);

	public void updateDoctor(Doctor doc);
}
