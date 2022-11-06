package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parcheggio p = new Parcheggio();
        String scelta;

        do {
            System.out.println("a = aggiungi auto, r = rimuovi auto, esci = esci dal programma");
            scelta = in.next();

            if (scelta.toUpperCase() == ("A")) {

                try {
                    System.out.println("Inserire targa:");
                    String targa1 = in.next();
                    p.aggiungiMacchina(new Macchina(targa1, System.currentTimeMillis()));

                } catch (ParcheggioPienoException | StessaMacchinaException e) {
                    System.out.println("errore: " + e.getMessage());
                }
            } else if (scelta.toUpperCase() == ("R")) {

                System.out.println("Inserire targa:");
                long secondi = 0;

                try {
                    secondi = p.rimuoviMacchina(in.next());
                } catch (MacchinaNonEsistenteException | ParcheggioVuotoException e) {
                    System.out.println("errore: " + e.getMessage());
                }

                System.out.println("sono passati " + secondi);
            } else if (scelta.toUpperCase() == ("esci")) {
                System.exit(0);
            }

        } while (true);

    }
}