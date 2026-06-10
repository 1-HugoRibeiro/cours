package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @Test
    public void testStatistique(){
        StatistiqueImpl statistique = new StistiqueImpl();
        Voiture v1 = new Voiture("Lamborghini",250000);
        Voiture v2 = new Voiture("Ferrari",150000);
        statistique.ajouter(v1);
        statistique.ajouter(v2);
        Echantillon echantillon = statistique.getPrixMoyen();

        assertEquals(200000, stistique.prixMoyen().getPrix());
        assertEquals(2, statistique.prixMoyen().getNombreDeVoitures());
    }

}
