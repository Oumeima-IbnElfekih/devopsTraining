package tn.esprit.spring.persistence.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.persistence.entities.Logistique;


@Repository
public interface LogistiqueRepository extends CrudRepository <Logistique, Integer> {
	
	@Query("Select SUM (log.prix * log.quantite) from Logistique log where log.reserve=:state ")
	public float calculPrixLogistiquesReserves (boolean state);
	
	

}
