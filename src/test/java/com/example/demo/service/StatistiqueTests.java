package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @Test
    void TestStat(){
        StatistiqueImpl stat = new StatistiqueImpl();
        Voiture v1 = new Voiture("Lamborghini",250000);
        Voiture v2 = new Voiture("Ferrari",150000);
        stat.ajouter(v1);
        stat.ajouter(v2);
        Echantillon ech = stat.getPrixMoyen();

        assertEquals(200000, ech.getPrixMoyen());
        assertEquals(2, ech.getNombreDeVoitures());
    }

}
