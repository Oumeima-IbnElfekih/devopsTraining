package tn.esprit.spring.service.interfaces;

import java.util.List;

import tn.esprit.spring.persistence.entities.Evenement;
import tn.esprit.spring.persistence.entities.Participant;

public interface IEvenemntService {

	Evenement ajoutAffectEvenParticip(Evenement e, int idParticip);
	Evenement ajoutAffectEvenParticip(Evenement e);

}
