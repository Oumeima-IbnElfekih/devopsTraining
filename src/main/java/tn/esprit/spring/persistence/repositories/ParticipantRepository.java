package tn.esprit.spring.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.entities.Tache;
@Repository
public interface ParticipantRepository extends CrudRepository <Participant, Integer>{

	Participant findByNomAndPrenomAndTache(String nom, String prenom, Tache tache);
	
	@Query("SELECT p from Participant p join p.evenements evnts where evnts.dated>=?1")
	List <Participant> participByDateEvent (Date datedeb);
	

	@Query("SELECT DISTINCT p from Participant p join p.evenements evnts join evnts.logistiques logis where logis.reserve=?1 AND p.tache=?2")
	List <Participant> participReservLogis (Boolean state,Tache tache);

}
