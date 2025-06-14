package CodewithHarry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import CodewithHarry.entites.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
