package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture v1 = nex Voiture("Lamborghini", prix: 250000);
        v1.setPrix(300000);
        assertEquals(300000,v1.getPrix());
        /*assert java v2*/

        Voiture v2 = new Voiture("Renaul", 25000);
        v2.setPrix(22500);
        assertEquals(22500,v2.getPrix());

        System.out.println(v1);
        System.out.println(v2);
    }

}
