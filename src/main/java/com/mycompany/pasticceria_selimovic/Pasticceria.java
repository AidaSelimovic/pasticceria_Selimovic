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
    
    public Pasticcino getPasticcino(int posizione)
    {
      
        if (posizione<0 || posizione>=getN_MAX_PASTICCINI())
            return null; 
        if (pasticcino[posizione]==null)
            return null;
        return new Pasticcino(pasticcino[posizione]); 

    }

    public int eliminaPasticcinoPosizione(int posizione)
    {   
       
        if (posizione<0 || posizione>=getN_MAX_PASTICCINI())
            return -1; //posizione non valida
        if (pasticcino[posizione]==null)
            return -2; //posizione vuota
        pasticcino[posizione]=null;
        return posizione;
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
    
    public String[] elencoTipoPasticcini(String tipo)
    {
        int numeroTipoPasticcini=0;
        Pasticcino p;

        //conto il numero di pasticcini presenti
     
        for (int i=0;i<N_MAX_PASTICCINI;i++)
        {
            if (pasticcino[i]!=null)
            {
                p=pasticcino[i];
                if (p.getTipo().equalsIgnoreCase(tipo))
                    numeroTipoPasticcini++;
            }
        }
        // se nn ci sono libri di quell'autore, return null
        if (numeroTipoPasticcini==0)
            return null;
        String[] elencoTipoPasticcini=new String[numeroTipoPasticcini];

        int posizioneTipo=0;

        //Assegno ad ogni elemento dell'array il tipo di pasticcino
        for (int i=0;i<N_MAX_PASTICCINI;i++)
        {
            if (pasticcino[i]!=null)
            {
                p=pasticcino[i];
                if (p.getTipo().equalsIgnoreCase(tipo))
                {
                    elencoTipoPasticcini[posizioneTipo]=p.getTipo();
                    posizioneTipo++;
                }
            }
        }

        return elencoTipoPasticcini;
    }

   
    
    public String toString()
    {
        String s="";
        for(int i=0;i<N_MAX_PASTICCINI;i++)
        {
            s=s+i+"\t--> ";
            if (pasticcino[i]!=null)
                s=s+pasticcino[i].toString()+"\n";
            else
                s=s+"\n";
        }
        return s;
    }
    
        
   

    
  
}
