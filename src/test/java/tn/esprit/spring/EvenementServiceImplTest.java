package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tn.esprit.spring.persistence.repositories.EvenementRepository;
import tn.esprit.spring.service.classes.EvenementServiceImpl;
import tn.esprit.spring.persistence.entities.Evenement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EvenementServiceImplTest {
    @InjectMocks
    EvenementServiceImpl eventService;

    @Mock
    private EvenementRepository eventRepository;
    private Evenement event ;


    @BeforeEach
    void setUp(){
        event = new Evenement(1, "Produit1",null,null, (float) 132.0, null, null);
    }

    @Test
    public void testAddEvent() {
        when(eventRepository.save(event)).thenReturn(event);
        Evenement persistedEvent = eventService.ajoutAffectEvenParticip(event);
        assertNotNull(persistedEvent);
    }


}
