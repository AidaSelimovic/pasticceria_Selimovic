/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;



import eccezioni.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author selimovic aida
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
    
    /**
     * Costruttore di copia
     * @param pasticceria 
     */
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
    
    /**
     * Aggiunge un pasticcino alla pasticceria nella posizione indicata
     * @param p copia del pasticcino da aggiungere
     * @param posizione è la posizione in cui si vuole aggiungere il pasticcino
     * @throws EccezionePosizioneNonValida viene sollevata quando la posizione inserita non è valida
     * @throws EccezionePosizioneOccupata viene sollevata quando la posizione inserita è già occupata
     */
    public void setPasticcino(Pasticcino p, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        try
        {
            if (pasticcino[posizione]!=null)
                throw new EccezionePosizioneOccupata();
            pasticcino[posizione]=new Pasticcino(p);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new eccezioni.EccezionePosizioneNonValida();
        }
        
        /*if (pasticcino[posizione]!=null)
            return -2;  //Posizione occupata
        pasticcino[posizione]=new Pasticcino(p);
        return posizione;*/
    }
    
    /**
     * Restituisce il pasticcino che si trova in una determinata posizione
     * @param posizione
     * @return il pasticcino che si trova nella posizione indicata
     * @throws EccezionePosizioneNonValida viene sollevata quando la posizione inserita non è valida
     * @throws EccezionePosizioneVuota viene sollevata quando la posizione inserita è vuota
     */
    public Pasticcino getPasticcino(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
      
        /*if (posizione<0 || posizione>=getN_MAX_PASTICCINI())
            return null; 
        if (pasticcino[posizione]==null)
            return null;*/
        try
        {
            return new Pasticcino(pasticcino[posizione]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        }
        catch(NullPointerException e)
        {
            throw new EccezionePosizioneVuota();         
        }
         

    }

    /**
     * Elimina dall'elenco, il pasticcino data una determinata posizione scelta
     * @param posizione
     * @throws EccezionePosizioneVuota viene sollevata quando la posizione inserita è vuota
     * @throws EccezionePosizioneNonValida viene sollevata quando la posizione inserita non è valida
     */
    public void eliminaPasticcinoPosizione(int posizione) throws EccezionePosizioneVuota, EccezionePosizioneNonValida
    {   
       
        /*if (posizione<0 || posizione>=getN_MAX_PASTICCINI())
            return -1; //posizione non valida*/
        try
        {
            if (pasticcino[posizione]==null)
                throw new EccezionePosizioneVuota();
            pasticcino[posizione]=null;
        }
        //return posizione;
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        }
    }

    /**
     * Metodo che cerca dall' elenco un pasticcino dato il suo codice identificativo
     * @param codiceDaCercare il codice del pasticcino che si vuole cercare
     * @return il pasticcino cercato
     */
    public Pasticcino cercaPasticcino(int codiceDaCercare)
    {
        for(int i=0;i<N_MAX_PASTICCINI;i++)
        {
            if(pasticcino[i].getCodice()==codiceDaCercare)
                return new Pasticcino(pasticcino[i]);
        }
        return null;
    }
    
    /**
     * Metodo che restituisce true--> pasticcino presente false--> pasticcino inesistente
     * @param tipo il tipo di pasticcino di cui si vuole sapere se c'è oppure no.
     * @return true se il pasticcino è presente, false se non è presente
     */
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
    
    
    /**
     * Metodo che crea un elenco (stringa) con all'interno i pasticcini di un certo tipo
     * @param tipo
     * @return l'elenco dei pasticcini di un certo tipo 
     */
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

    
    /**
     * Metodo he restituisce un elenco (stringa) dei pastccini presenti
     * @return l'elenco dei pasticcini presenti
     */
    public Pasticcino[] elencoPasticciniPresenti()
    {
        Pasticcino[] elencoPasticciniPresenti=new Pasticcino[nPasticciniPresenti()];
        Pasticcino p;
        int c=0; //contatore
        for (int i=0;i<N_MAX_PASTICCINI;i++)
        {
            try {
                p=getPasticcino(i);
                elencoPasticciniPresenti[c]=p;
                c++;
            } 
            catch (EccezionePosizioneNonValida ex) 
            {
                //non accade
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                //non fare nulla
            }
                  
        }
        
        return elencoPasticciniPresenti;
    }
   
    /**
     * Mostra ogni posizione con l'eventuale pasticcino contenuto
     * @return 
     */
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
