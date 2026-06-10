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
    void testStats(){
        StatistiqueImpl stats = new StatistiqueImpl();
        Voiture v1 = new Voiture("Lambo",15000);
        Voiture v2 = new Voiture("Fefe",15000);
        stats.ajouter(v1);
        stats.ajouter(v2);
        Echantillon ech = stats.prixMoyen();

        assertEquals(15000, ech.getPrixMoyen);
        assertEquals(2, ech.getNombreDeVoitures());
    }

}
