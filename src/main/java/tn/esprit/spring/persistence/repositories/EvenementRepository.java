package tn.esprit.spring.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.persistence.entities.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository <Evenement, Integer>{

	Evenement findByDescription(String description);

	List <Evenement> findByDatedBetween(Date dateDebut, Date dateFin);
	

}
