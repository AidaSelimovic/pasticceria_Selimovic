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
        int esito;
        Scanner tastiera=new Scanner(System.in);
        String tipo;
        int quantita;
        long codice;
        double costo;
        Pasticcino p = null;
        int posizione;
        String[] elencoTipiPasticcini;
        
        
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
                    System.out.println(p.toString());
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
                    break;
                
            }
        }while(voceScelta!=0);
    }
}
