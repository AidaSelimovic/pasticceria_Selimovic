/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pasticceria_selimovic;

import java.util.Scanner;
import utilita.Menu;

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
        Scanner tastiera=new Scanner(System.in);
        String tipo;
        int quantita;
        long codice = 0;
        double costo = 0;
        Pasticcino p;
        int posizione = 0;
        String[] elencoTipoPasticcini;
        
        
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
                    System.out.println("Premi invio per continuare...");
                    tastiera.nextLine();
                    System.out.println("Tipo --> ");
                    tipo=tastiera.nextLine();
                    System.out.println("Quantità --> ");
                    quantita=tastiera.nextInt();
                    System.out.println("Posizione (0..20) --> ");
                    posizione=tastiera.nextInt();    
                    esito=p1.setPasticcino(new Pasticcino(tipo, costo, quantita, (int) codice), posizione);
                    if(esito==-1)
                        System.out.println("Posizione inesistente");
                    else if(esito==-2)
                        System.out.println("Posizione già occupata");
                    else
                        System.out.println("Pasticcino aggiunto correttamente");
                    break;
                case 3:
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();  
                    p=p1.getPasticcino(posizione);
                    if (p==null)
                        System.out.println("Pasticcino non trovato!");
                    else
                        System.out.println("Pasticcino cercato: "+p.toString());
                    break;
                case 4:
                    System.out.println("Posizione pasticcino da cercare --> ");
                    codice=tastiera.nextInt();
                    esito=p1.eliminaPasticcinoPosizione(posizione);
                    if(esito==-1)
                        System.out.println("Posizione inesistente");
                    else if(esito==-2)
                        System.out.println("Posizione già vuota. Nessun pasticcino è stato rimosso.");
                    else
                        System.out.println("Pasticcino rimosso correttamente");
                    break;
                case 5:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare...");
                    tastiera.nextLine();
                    System.out.println("Tipo --> ");
                    tipo=tastiera.nextLine();
                    elencoTipoPasticcini=p1.elencoTipoPasticcini(tipo);
                    if(elencoTipoPasticcini==null)
                        System.out.println("Nessun pasticcino presente");
                    else
                    {
                        for(int i=0;i<elencoTipoPasticcini.length;i++)
                        {
                            System.out.println(elencoTipoPasticcini[i]);
                        }
                    }
                    break;   
       

                
            }
        }while(voceScelta!=0);
    }
}
