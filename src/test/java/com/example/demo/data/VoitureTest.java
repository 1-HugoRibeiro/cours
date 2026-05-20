package com.example.demo.data;

import java.utils.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {
    Voiture v1;
    Voiture v2;

    @BeforeAll
    void créa(){
        v1 = new Voiture("Lamborghini", 250000);
        v1.setId(1);
        v2 = new Voiture("Renault",25000);
        v2.setId(2);
    }
    

    @Test
    void creerVoiture(){
        assertEquals(1,1);
        assertEquals("Lamborghini","Lamborghini");
        assertNotEquals("BMW", "BMW");
        /*assert java v2*/
    }

}
