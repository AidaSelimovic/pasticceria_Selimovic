/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

import java.time.LocalDate;
import java.time.Month;

/**
 *Claase che rappresenta un pasticcino
 * @author selimovic aida
 */
public class Pasticcino 
{
    private String tipo;
    private int quantita;
    double costo;
    private static int nextCodice;
    private int codice;
    private LocalDate dataPreparazione;
    
    /**
     * Metodo costruttore
     * @param tipo tipo del pasticcino
     * @param quantita quantità che si desidera di un certo tipo di pasticcino
     * @param codice codice di ogni ordine che viene ricevuto
     */
    public Pasticcino(String tipo, int quantita,int codice) 
    {
        this.codice=nextCodice; 
        nextCodice++; 
        setTipo(tipo);
        setQuantita(quantita);
        //dataPreparazione=LocalDate.of(codice, Month.MARCH, codice);
    } 
    
    /**
     * Costruttore di copia
     * @param pasticcino il pasticcino da copiare
     */
    public Pasticcino(Pasticcino pasticcino)
    {
        codice=pasticcino.getCodice();
        tipo=pasticcino.getTipo();
        quantita=pasticcino.getQuantita();
    }
   
    /**
     * 
     * @return il tipo di pasticcino
     */
    public String getTipo() 
    {
        return tipo;
    }

    /**
     * Assegna un tipo al pasticcino
     * @param tipo 
     */
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    /**
     * Calcola il costo della quantità di pasticcini desiderata (0.50€ a pasticcino)
     * @return costo
     */
    public double getCosto() 
    {
        double costo;
        costo=0.50*quantita;
        return costo;
    }
    
    /**
     * 
     * @return la quantità per ogni tipo di pasticcino
     */
    public int getQuantita() 
    {
        return quantita;
    }

    /**
     * Assegna la quantià ad ogni pasticcino
     * @param quantita
     */
    public void setQuantita(int quantita) 
    {
        this.quantita = quantita;
    }

    /**
     * 
     * @return il codice (univoco per ogi pasticcino)
     */
    public int getCodice() 
    {
        return  codice;
    }
    @Override
    public boolean equals(Object o)
    {
        Pasticcino p;
        p=(Pasticcino)o;
        if(p.getTipo()==getTipo() && p.getCodice()==getCodice() && p.getQuantita()==getQuantita())
            return true;
        else
            return false;
    }
    /**
     * 
     * @return il libro sotto forma di testo
     */
    @Override
    public String toString() {
        return "Pasticcini: " + " codice=" + codice+ ", tipo=" + tipo +", quantita="+ quantita +", costo= €"  + costo  + '}';
    }

}
