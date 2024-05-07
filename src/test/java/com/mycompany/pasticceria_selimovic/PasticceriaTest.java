/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Studente
 */
public class PasticceriaTest {
    
    public PasticceriaTest() {
    }

    /**
     * Test of costructor method, of class Pasticceria.
     */
    @Test
    public void testCostruttore() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata, EccezionePosizioneVuota 
    {
        Pasticceria pasticceria1=new Pasticceria();
        Pasticcino p1=new Pasticcino("bigne", 2, 0);
        pasticceria1.setPasticcino(p1, 0);
        int nPasticciniPresenti=0;
        assertEquals(p1,pasticceria1.getPasticcino(0));
    }
    
    /**
     * Test of getN_MAX_PASTICCINI method, of class Pasticceria.
     */
    @Test
    public void testGetN_MAX_PASTICCINI() 
    {
        
    }

    /**
     * Test of nPasticciniPresenti method, of class Pasticceria.
     */
    @Test
    public void testNPasticciniPresenti() 
    {
        
    }

    /**
     * Test of setPasticcino method, of class Pasticceria.
     */
    @Test
    public void testSetGetPasticcino() throws Exception 
    {
        Pasticceria pasticceria1=new Pasticceria();
        Pasticcino p1=new Pasticcino("bigne", 2, 0);
        pasticceria1.setPasticcino(p1, 0);
        assertEquals(p1,pasticceria1.getPasticcino(0));
    }
    /**
     * Test of setPasticcino method, of class Pasticceria.
     */
    @Test
    public void testSetPasticcinoPosizioneNegativa() throws Exception 
    {
        Pasticceria pasticceria1=new Pasticceria();
        Pasticcino p1=new Pasticcino("bigne", 2, 0);
        //pasticceria1.setPasticcino(p1, -1);
        //assertEquals(p1,pasticceria1.setPasticcino(p1, -1));
    }
    /**
     * Test of setPasticcino method, of class Pasticceria.
     */
    @Test
    public void testSetPasticcinoPosizioneMaggiore() throws Exception 
    {
        Pasticceria pasticceria1=new Pasticceria();
        Pasticcino p1=new Pasticcino("bigne", 2, 0);
        //pasticceria1.setPasticcino(p1, -1);
       // assertEquals(p1,pasticceria1.setPasticcino(p1, 20));
    }

    /**
     * Test of eliminaPasticcinoPosizione method, of class Pasticceria.
     */
    @Test
    public void testEliminaPasticcinoPosizione() throws Exception 
    {
        
    }

    /**
     * Test of cercaPasticcino method, of class Pasticceria.
     */
    @Test
    public void testCercaPasticcino() 
    {
        
    }

    /**
     * Test of presenzaTipo method, of class Pasticceria.
     */
    @Test
    public void testPresenzaTipo() 
    {
        
    }

    /**
     * Test of elencoTipoPasticcini method, of class Pasticceria.
     */
    @Test
    public void testElencoTipoPasticcini() 
    {
        
    }

    /**
     * Test of elencoPasticciniPresenti method, of class Pasticceria.
     */
    @Test
    public void testElencoPasticciniPresenti() 
    {
        
    }

    /**
     * Test of esportaCSV method, of class Pasticceria.
     */
    @Test
    public void testEsportaCSV() throws Exception 
    {
        
    }

    /**
     * Test of importaCSV method, of class Pasticceria.
     */
    @Test
    public void testImportaCSV() throws Exception 
    {
        
    }

    /**
     * Test of salvaPasticceria method, of class Pasticceria.
     */
    @Test
    public void testSalvaPasticceria() throws Exception 
    {
        
    }

    /**
     * Test of caricaPasticceria method, of class Pasticceria.
     */
    @Test
    public void testCaricaPasticceria() throws Exception 
    {
        
    }

    /**
     * Test of toString method, of class Pasticceria.
     */
    @Test
    public void testToString() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        Pasticceria pasticceria1=new Pasticceria();
        Pasticcino p1=new Pasticcino("cannoncino", 2, 0);
        pasticceria1.setPasticcino(p1, 0);
        Pasticcino p2=new Pasticcino("cannoncino", 4, 1);
        pasticceria1.setPasticcino(p2, 5);
        String s=pasticceria1.toString();
        assertEquals(pasticceria1.toString(), s);
    }
    
}
