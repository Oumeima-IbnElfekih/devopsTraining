package tn.esprit.spring.service.interfaces;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.persistence.entities.Logistique;

public interface ILogistiqueService {
	Logistique ajoutAffectLogEven(Logistique l, String description_evnm);
	public List<Logistique> getLogistiquesDates (Date date_debut, Date date_fin);

}
