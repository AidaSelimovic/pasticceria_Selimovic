/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pasticceria_selimovic;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.*;
import eccezioni.*;

/**
 *
 * @author selim
 */
public class Pasticceria_Selimovic {

    public static void main(String[] args) throws IOException 
    {
        String[] vociMenu;
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta = 0;
        Pasticceria p1=new Pasticceria();
        int esito = 0;
        ConsoleInput tastiera=new ConsoleInput();
        String tipo = null;
        int quantita;
        long codice = 0;
        double costo = 0;
        Pasticcino p = null;
        int posizione = 0;
        String[] elencoTipoPasticcini = null;
        Pasticcino[] pasticciniPresenti;
        
        
        vociMenu[0]="0\t--> Esci";
        vociMenu[1]="1\t--> Visualizza tutti i pasticcini presenti";
        vociMenu[2]="2\t--> Aggiungi pasticcino";
        vociMenu[3]="3\t--> Visualizza pasticcino (posizione) ";
        vociMenu[4]="4\t--> Elimina pasticcino (posizione)";
        vociMenu[5]="5\t--> Mostra pasticcino di un certo tipo";
        vociMenu[6]="6\t--> Mostra pasticcini presenti in ordine crescente di prezzo";
        vociMenu[6]="7\t--> Mostra pasticcini presenti in ordine alfabetico di tipo";
        vociMenu[7]="8\t--> Esporta i pasticcini su file CSV";
        vociMenu[8]="9\t--> Importa i pasticcini da file CSV";
        vociMenu[9]="10\t--> Salva dati pasticceria";
        vociMenu[10]="11\t--> Carica dati pasticceria";
        
        menu=new Menu(vociMenu);
        
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch(voceScelta)
            {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1:
                    System.out.println(p1.toString());
                    break;
                case 2:
                    try 
                    {
                        System.out.println("Tipo --> ");
                        tipo=tastiera.readString();
                        do
                        {
                            try
                            {
                                System.out.println("Quantità --> ");
                                quantita=tastiera.readInt();
                                break;
                            }
                            catch(NumberFormatException ex)
                            {
                                System.out.println("Formato non corretto, devi inserire un numero");
                            }
                        }while(true);
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..19) --> ");
                                posizione=tastiera.readInt();   
                                break;
                            }
                            catch (NumberFormatException ex) 
                            {
                                System.out.println("Formato non corretto");
                            }
                            
                        }while(true);
                        try
                        {
                            p1.setPasticcino(new Pasticcino(tipo, costo, quantita, (int) codice), posizione);
                            System.out.println("Pasticcino aggiunto correttamente");
                        }
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida");
                        }
                        catch (EccezionePosizioneOccupata e) 
                        {
                            System.out.println("Posizione già occupata");
                        }
                    }
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Formato non corretto");
                        }
                    
                    break;

                case 3:
                    try
                    {
                        do
                        {
                            try 
                            {
                                System.out.println("Posizione (0..19) --> ");
                                posizione=tastiera.readInt();
                                break;
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Impossibile leggere da file");
                            } 
                            catch (NumberFormatException ex) 
                            {
                                System.out.println("Formato non corretto");
                            }

                        }while(true);
                        p1.getPasticcino(posizione);
                        System.out.println("Pasticcino cercato: "+p.toString());
                    }    
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Posizione vuota");
                    }
                    break;


                case 4:
                    try
                    {
                        do
                        {
                            try 
                            {
                                System.out.println("Posizione (0..19) --> ");
                                posizione=tastiera.readInt();
                                break;
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Impossibile leggere da file");
                            } 
                            catch (NumberFormatException ex) 
                            {
                                System.out.println("Formato non corretto");
                            }

                        }while(true);
                        p1.eliminaPasticcinoPosizione(posizione);
                        System.out.println("Pasticcino rimosso corretamente");
                    }
                    catch(EccezionePosizioneNonValida e)
                    {
                        System.out.println("Posizione non valida");
                    }
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessun pasticcino è stato rimosso.");
                    }
                   
                    break;


                case 5:

                    System.out.print("Tipo --> ");
                
                    try 
                    {
                        tipo=tastiera.readString();
                        elencoTipoPasticcini=p1.elencoTipoPasticcini(tipo);
                        if(elencoTipoPasticcini==null)
                            System.out.println("Nessun pasticcino presente");
                        else
                        {
                            for(int i=0;i<elencoTipoPasticcini.length;i++)
                            {
                                System.out.println("Pasticcini presenti--> ");
                                System.out.println(elencoTipoPasticcini[i]);
                            }
                        }
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Formato non corretto");
                    }
           
                    break;   
                case 6:
                    pasticciniPresenti=p1.elencoPasticciniPresenti();
                    pasticciniPresenti=Ordinatore.selectionSortCrescenteLibri(pasticciniPresenti);
                    for(int i=0;i<pasticciniPresenti.length;i++)
                    {
                        System.out.println(pasticciniPresenti[i].toString());
                    }
                    break;

                
            }
        }while(voceScelta!=0);
    }
}
