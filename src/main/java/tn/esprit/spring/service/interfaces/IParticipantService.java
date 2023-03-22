package tn.esprit.spring.service.interfaces;

import java.util.List;

import tn.esprit.spring.persistence.entities.Participant;

public interface IParticipantService {
	public Participant ajouterParticipant (Participant p) ;
	public void calculCout ( );
	public List<Participant> getParReservLogis();

}
