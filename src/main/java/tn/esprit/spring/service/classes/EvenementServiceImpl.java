package tn.esprit.spring.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.persistence.entities.Evenement;
import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.repositories.EvenementRepository;
import tn.esprit.spring.persistence.repositories.ParticipantRepository;
import tn.esprit.spring.service.interfaces.IEvenemntService;
@Service
@Slf4j
public class EvenementServiceImpl implements IEvenemntService{
@Autowired
ParticipantRepository partRep;
@Autowired
EvenementRepository evenRep ;
//1ère méthode d'affectation avec la signature Evenement ajoutAffectEvenParticip(Evenement e, int idParticip)
	@Override
	public Evenement ajoutAffectEvenParticip(Evenement e, int idParticip) {
		Participant p= partRep.findById(idParticip).get();
		Evenement savedEvent=evenRep.findById(e.getId()).get();
		List<Participant> pts;
		
		if(savedEvent.getParticipants() == null){
			pts=new ArrayList<>();
		}
		else 
			{pts= savedEvent.getParticipants();}

			pts.add(p);
			e.setParticipants(pts);
		evenRep.save(e);
		return e;
	}
	

//2ème méthode d'affectation avec la signature: Evenement ajoutAffectEvenParticip(Evenement e)

	@Override
	public Evenement ajoutAffectEvenParticip(Evenement e) {
			evenRep.save(e);
			return e;
		}
	}
	
	

	

