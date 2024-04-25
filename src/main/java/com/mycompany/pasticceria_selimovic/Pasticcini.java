/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

/**
 *
 * @author selim
 */
public class Pasticcini 
{
    private String tipo;
    private int quantita;
    double costo;
    private static long nextCodice;
    private long codice;
    
    public Pasticcini(String tipo, double costo, int quantita,int codice) 
    {
        this.codice=nextCodice; 
        nextCodice++; 
        setTipo(tipo);
        setCosto(costo);
        setQuantita(quantita);
    } 
    
    public Pasticcini(Pasticcini pasticcini)
    {
        codice=pasticcini.getCodice();
        tipo=pasticcini.getTipo();
        costo=pasticcini.getCosto();
        quantita=pasticcini.getQuantita();
    }
   
    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public double getCosto() 
    {
        double costo;
        costo=0.50*quantita;
        return costo;
    }

    public void setCosto(double costo) 
    {
        
        this.costo = costo;
    }

    public int getQuantita() 
    {
        return quantita;
    }

    public void setQuantita(int quantita) 
    {
        this.quantita = quantita;
    }

    public long getCodice() 
    {
        return  codice;
    }
    
    @Override
    public String toString() {
        return "Pasticcini{" + ", codice=" + codice+ "tipo=" + tipo +", quantita="+ quantita +", costo="  + costo  + '}';
    }

}
