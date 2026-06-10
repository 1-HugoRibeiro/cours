package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.service.StatistiqueImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @Test
    void testStatistique(){
        StatistiqueImpl stat = new StatistiqueImpl();
        Voiture v1 = new Voiture("lambo",15000);
        Voiture v2 = new Voiture("Fefe",15000);

        stat.ajouter(v1);
        stat.ajouter(v2);

        Echantillon ech = stat.prixMoyen();

        assertEquals(15000,ech.getPrixMoyen());
        assertEquals(2,ech.getNombreDeVoitures());

    }

}
