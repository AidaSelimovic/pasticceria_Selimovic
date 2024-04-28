/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

/**
 *
 * @author selim
 */
public class Pasticcino 
{
    private String tipo;
    private int quantita;
    double costo;
    private static long nextCodice;
    private long codice;
    
    public Pasticcino(String tipo, double costo, int quantita,int codice) 
    {
        this.codice=nextCodice; 
        nextCodice++; 
        setTipo(tipo);
        setCosto(costo);
        setQuantita(quantita);
    } 
    
    public Pasticcino(Pasticcino pasticcino)
    {
        codice=pasticcino.getCodice();
        tipo=pasticcino.getTipo();
        costo=pasticcino.getCosto();
        quantita=pasticcino.getQuantita();
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
