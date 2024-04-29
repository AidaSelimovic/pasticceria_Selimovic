/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import java.util.ArrayList;

/**
 *
 * @author selim
 */
public class Pasticceria 
{
    private Pasticcino[] pasticcino;
    private final int N_MAX_PASTICCINI=20;
    int nPasticciniPresenti;
    
    public Pasticceria()
    {
        pasticcino=new Pasticcino[N_MAX_PASTICCINI];
        nPasticciniPresenti=0;
    }
    public Pasticceria(Pasticceria pasticceria)
    {
        pasticcino=new Pasticcino[N_MAX_PASTICCINI];
        Pasticcino p;
        for(int i=0;i<pasticceria.getN_MAX_PASTICCINI();i++)
        {
            p=pasticceria.cercaPasticcino(i);
            if(pasticcino!=null)
                pasticcino[i]=p;
        }
        
    }
    public int getN_MAX_PASTICCINI()
    {
        return N_MAX_PASTICCINI;
    }
    public int nPasticciniPresenti()
    {
        int contatore=0;
        for(int i=0;i<N_MAX_PASTICCINI;i++)
        {
            if(pasticcino[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
   public int setPasticcino(Pasticcino p, int posizione)
   {
         if (posizione<0 || posizione>=N_MAX_PASTICCINI)
            return -1;  //Posizione non esiste
        if (pasticcino[posizione]!=null)
            return -2;  //Posizione occupata
        pasticcino[posizione]=new Pasticcino(p);
        return posizione;
   }
    
    public int getPasticcino(Pasticcino p)
    {
        if(nPasticciniPresenti>=N_MAX_PASTICCINI)
            return -1;
        else
        {
            pasticcino[nPasticciniPresenti]=new Pasticcino (p);
            nPasticciniPresenti++;
            return 0;
        }
    }
    
    public void eliminaPasticcinoPosizione(int posizione)
    {
        for(int i=posizione;i<nPasticciniPresenti-1;i++)
        {
            pasticcino[i]=pasticcino[i+1];
        }
        pasticcino[nPasticciniPresenti]=null;
        nPasticciniPresenti--;
    }
    public int eliminaPasticcino(long codiceDaEliminare)
    {
        for(int i=0;i<nPasticciniPresenti;i++)
        {
            if(pasticcino[i].getCodice()==codiceDaEliminare)
            {
                eliminaPasticcinoPosizione(i);
                return 0;
            }
        }
        return -1;
    }
    
    public Pasticcino cercaPasticcino(int codiceDaCercare)
    {
        for(int i=0;i<N_MAX_PASTICCINI;i++)
        {
            if(pasticcino[i].getCodice()==codiceDaCercare)
                return new Pasticcino(pasticcino[i]);
        }
        return null;
    }
    
    public boolean presenzaTipo(String tipo)
    {
        for (int i=0;i<getN_MAX_PASTICCINI();i++)
        {
            if (pasticcino[i]!=null) 
            {
                if (pasticcino[i].getTipo().equalsIgnoreCase(tipo))
                return true;
            }
        }
        return false;
    }
    public String toString()
    {
        String s;
        s="";
        for(int i=0;i<nPasticciniPresenti;i++)
        {
            s=s+pasticcino[i].toString()+"\n\n";
        }
        return s;
    }
    
        
   

    
  
}
