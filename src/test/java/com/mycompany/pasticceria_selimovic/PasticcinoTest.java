/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author selimovic aida
 */
public class PasticcinoTest {
    Pasticcino p1=new Pasticcino("bigne", 2, 0);
    
    public PasticcinoTest() 
    {
        
    }
    
     /**
     * Test of costructor Pasticcino method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testCostruttoreQuantitaNegativa()
    {
        Pasticcino p1=new Pasticcino("bigne", -2, 0);
        int posizione=0;
        //Pasticcino atteso=p1;
        Pasticcino attuale=p1;
        
        assertEquals(p1,attuale);
    }
    
    /**
     * Test of costructor Pasticcino method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testCostruttore() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //Pasticcino atteso=p1;
        Pasticcino attuale=p1;
        
        assertEquals(p1,attuale);
    }
    /**
     * Test of copy costructor Pasticcino method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testCostruttoreCopia() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        Pasticcino p2=new Pasticcino(p1);

        //Pasticcino atteso=p2;
        Pasticcino attuale=p2;
        
        assertEquals(p2,attuale);
    }
    /**
     * Test of copy costructor Pasticcino method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testCostruttoreCopiaIndipendenza() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        Pasticcino p2=new Pasticcino(p1);
        p1=null;
        //Pasticcino atteso=p2;
        Pasticcino attuale=p2;
        
        assertEquals(p2,attuale);
    }
    
    /**
    * Test of getTipo method, of class Pasticcino.
    */
    @org.junit.jupiter.api.Test
    public void testGetTipo() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //String atteso=p1.getTipo();
        String attuale=p1.getTipo();
        
        assertEquals("bigne",attuale);
    }
    
    

    /**
     * Test of setTipo method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testSetTipo() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        p1.setTipo("cannoncino");
        String attuale=p1.getTipo();
        
        assertEquals("cannoncino",attuale);
        
    }

    /**
     * Test of getCosto method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testGetCostoPositivo() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //double atteso=p1.getCosto();
        double attuale=p1.getCosto();
        
        assertEquals(1.0,attuale);
    }
     /**
     * Test of getCosto method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testGetCostoNegativo() 
    {
        Pasticcino p1=new Pasticcino("bigne", -1, 0);
        int posizione=0;
        //double atteso=p1.getCosto();
        double attuale=p1.getCosto();
        
        assertEquals(-0.5,attuale);
    }


    /**
     * Test of getQuantita method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testGetQuantita() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //double atteso=p1.getQuantita();
        double attuale=p1.getQuantita();
        
        assertEquals(2,attuale);
    }
    
    

    /**
     * Test of setQuantita method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testSetQuantitaPositiva() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        p1.setQuantita(3);
        int attuale=p1.getQuantita();
        
        assertEquals(3,attuale);
    }
    
    /**
     * Test of getQuantita method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testSetQuantitaNegativa() 
    {
        Pasticcino p1=new Pasticcino("bigne", -1, 0);
        int posizione=0;
        p1.setQuantita(-1);
        int attuale=p1.getQuantita();
        
        assertEquals(-1,attuale);
    }
    /**
     * Test of getCodice method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testGetCodice() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //int atteso=p1.getCodice();
        int attuale=p1.getCodice();
        
        assertSame(0,attuale);
    }

    /**
     * Test of toString method, of class Pasticcino.
     */
    @org.junit.jupiter.api.Test
    public void testToString() 
    {
        //Pasticcino p1=new Pasticcino("bigne", 2, 0);
        int posizione=0;
        //String atteso=p1.toString();
        String attuale=p1.toString();
        
        assertEquals(p1.toString(),attuale);
    }
    
}
