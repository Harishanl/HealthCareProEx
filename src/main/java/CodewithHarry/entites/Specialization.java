package CodewithHarry.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Specialization_tab")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spec_id_col")
	private Long id;
	

	@Column(name = "spec_code_col", nullable = false, unique = true)
	private String specCode ;
	
	@Column(name = "spec_name_col", nullable = false, unique = true)
	private String specName ;
	
	@Column(name = "spec_note_col",nullable = false ,unique = true)
	private String specNote ;
	
	
	
	
}
