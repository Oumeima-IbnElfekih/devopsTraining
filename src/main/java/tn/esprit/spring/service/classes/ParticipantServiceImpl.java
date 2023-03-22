package tn.esprit.spring.service.classes;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.persistence.entities.Evenement;
import tn.esprit.spring.persistence.entities.Logistique;
import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.entities.Tache;
import tn.esprit.spring.persistence.repositories.EvenementRepository;
import tn.esprit.spring.persistence.repositories.LogistiqueRepository;
import tn.esprit.spring.persistence.repositories.ParticipantRepository;
import tn.esprit.spring.service.interfaces.IParticipantService;
@Service
@Slf4j
public class ParticipantServiceImpl implements IParticipantService{
@Autowired
ParticipantRepository partRep;
@Autowired
EvenementRepository eventRep;
@Autowired
LogistiqueRepository logisRep;

	@Override
	public Participant ajouterParticipant(Participant p) {
		partRep.save(p);
		return p;
	}
//Question 6
	@Override
	@Scheduled(fixedRate = 60000)
	public void calculCout() {
		float cout = 0;
		List<Evenement> evenements= (List<Evenement>) eventRep.findAll();
		for (Evenement ev : evenements)
		{
				cout = cout + logisRep.calculPrixLogistiquesReserves(true);
				ev.setCout(cout);
				eventRep.save(ev);
				log.info("le cout de l'evenement : " + ev +" est:" +cout +
						"il est mis à jour dans la base");	
				}
}
					

	@Override
	public List<Participant> getParReservLogis() {
		
		return partRep.participReservLogis(true, Tache.ORGANISATEUR);
		
	}
	


}
