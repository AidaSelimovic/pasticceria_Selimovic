/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pasticceria_selimovic;



import eccezioni.*;
import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;
/**
 *
 * @author selimovic aida
 */
public class Pasticceria implements Serializable
{
    private Pasticcino[] pasticcino;
    private final int N_MAX_PASTICCINI=20;
    int nPasticciniPresenti;
    
    /**
     * Costruttore
     */
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
    
    /**
     * 
     * @return il numero massimo di pasticcini che la pasticceria può contenere 
     */
    public int getN_MAX_PASTICCINI()
    {
        return N_MAX_PASTICCINI;
    }
    
    /**
     * 
     * @return il numero di pasticcini presenti nella pasticceria
     */
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
     * Metodo che consente di esportare i pasticcini su un file CSV
     * @param fileName nome del file CSv
     * @throws IOException
     * @throws FileException 
     */
    public void esportaCSV(String fileName) throws IOException, FileException
    {
        TextFile f1=new TextFile(fileName,'W');
        Pasticcino p;
        String datiPasticcino;
       
       
            for(int i=0;i<N_MAX_PASTICCINI;i++)
            {
               try 
                {
                    p=this.getPasticcino(i);
                    datiPasticcino=i+";"+p.getCodice()+";"+p.getTipo()+";"+p.getQuantita()+";"+p.getCosto()+";";
                    f1.toFile(datiPasticcino);    
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla.
                }
            }
       
        f1.close();
    }
   
    /**
     * Metodo che importa i pasticcini da file CSV 
     * @param fileName
     * @throws IOException 
     */
    public void importaCSV(String fileName) throws IOException
    {
       TextFile f1=new TextFile(fileName, 'R');
       String rigaLetta;
       String[] datiPasticcino;
       String tipo;
       int codice, quantita,posizione = 0;
       double costo;
       LocalDate dataPreparazione;
       Pasticcino p;
       
        try 
        {
            while(true)
            {
                rigaLetta=f1.fromFile();
                datiPasticcino=rigaLetta.split(";");
                codice=Integer.parseInt(datiPasticcino[0]);
                tipo=datiPasticcino[2];
                quantita=Integer.parseInt(datiPasticcino[1]);
                costo=Integer.parseInt(datiPasticcino[3]);
                dataPreparazione=LocalDate.parse(datiPasticcino[4]);
                p=new Pasticcino(tipo, quantita, codice);
                try 
                {
                    this.setPasticcino(p, posizione);
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non fa nulla, il libro non viene messo nello scaffale
                } 
                catch (EccezionePosizioneOccupata ex) 
                {
                    //non fa nulla, il libro non viene messo nello scaffale
                }
            } 
        } 
        catch (FileException ex) 
        {
            //E' finito il file di testo
            f1.close();
        }
       
    }
   
    /**
     * Metodo che salva i dati della pasticceria
     * @param fileName nome del file binario
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvaPasticceria(String fileName) throws FileNotFoundException, IOException
    {
       ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(fileName));
       writer.writeObject(this);
       writer.flush();
       writer.close();
    }
   
    /**
     * Metodo che carica da  file binario i dati della pasticceria
     * @param fileName noe del file binario
     * @return la pasticceria contenente i pasticcini
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Pasticceria caricaPasticceria(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
       Pasticceria p1;
       ObjectInputStream reader=new ObjectInputStream(new FileInputStream(fileName));
       p1=(Pasticceria)reader.readObject();
       reader.close();
       return p1;
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
