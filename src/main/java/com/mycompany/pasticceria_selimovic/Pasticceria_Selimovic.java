/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pasticceria_selimovic;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilita.*;

/**
 *
 * @author selim
 */
public class Pasticceria_Selimovic {

    public static void main(String[] args) 
    {
        String[] vociMenu;
        int numeroVoci=7;
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
        Pasticcino p;
        int posizione = 0;
        String[] elencoTipoPasticcini = null;
        
        
        vociMenu[0]="0\t--> Esci";
        vociMenu[1]="1\t--> Visualizza tutti i pasticcini presenti";
        vociMenu[2]="2\t--> Aggiungi pasticcino";
        vociMenu[3]="3\t--> Visualizza pasticcino (posizione) ";
        vociMenu[4]="4\t--> Elimina pasticcino (posizione)";
        vociMenu[5]="5\t--> Mostra pasticcino di un certo tipo";
        vociMenu[6]="6\t--> Mostra pasticcini presenti in ordine crescente di prezzo";
        
        
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
                        System.out.println("Quantità --> ");
                        quantita=tastiera.readInt();
                        System.out.println("Posizione (0..19) --> ");
                        posizione=tastiera.readInt();    
                        esito=p1.setPasticcino(new Pasticcino(tipo, costo, quantita, (int) codice), posizione);
                        if(esito==-1)
                            System.out.println("Posizione inesistente");
                        else if(esito==-2)
                            System.out.println("Posizione già occupata");
                        else
                            System.out.println("Pasticcino aggiunto correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossbile leggere da tastiera");
                    }
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Formato non corretto");
                    }

                    break;

                case 3:
                    System.out.println("Posizione (0..19) --> ");
                  
                    try 
                    {
                        posizione=tastiera.readInt();
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Formato non corretto");
                    }
                
                    p=p1.getPasticcino(posizione);
                    if (p==null)
                        System.out.println("Pasticcino non trovato!");
                    else
                        System.out.println("Pasticcino cercato: "+p.toString());
                    break;

                case 4:
                    System.out.println("Posizione pasticcino da eliminare --> ");
                
                    try 
                    {
                        posizione=tastiera.readInt();
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da tastoera");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Formato non corretto");
                    }
                
                    esito=p1.eliminaPasticcinoPosizione(posizione);
                    if(esito==-1)
                        System.out.println("Posizione inesistente");
                    else if(esito==-2)
                        System.out.println("Posizione già vuota. Nessun pasticcino è stato rimosso.");
                    else
                        System.out.println("Pasticcino rimosso correttamente");
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

                
            }
        }while(voceScelta!=0);
    }
}
