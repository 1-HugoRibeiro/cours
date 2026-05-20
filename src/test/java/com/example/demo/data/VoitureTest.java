package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {
    Voiture v1;
    Voiture v2

    @BeforeAll{
        v1 = new Voiture("Lamborghini", 250000);
        v1.setId(1);
        v2 = new Voiture("Renault",25000);
        v2.setId(2);
    }

    @Test
    void creerVoiture(){
        assertEquals(1,1);
        assert.isTrue(v1.getMarque().equals("Lamborghini"), v1.getPrix() == 250000);
        assert.isFalse(v2.getMarque().notEquals("BMW"), v2.getPrix() == 110);
        /*assert java v2*/
    }

}
