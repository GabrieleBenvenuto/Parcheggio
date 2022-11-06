package main;


public class Parcheggio {
    private final Macchina[] parcheggio;
    private int nAuto = 0;
    private int pos = 0;

    public Parcheggio() {
        parcheggio = new Macchina[5];
    }

    public void aggiungiMacchina(Macchina m) throws ParcheggioPienoException, StessaMacchinaException {

        if (nAuto == 10) {
            throw new ParcheggioPienoException("Il parcheggio è pieno");
        }


        for (int i = 0; i < 10; i++) {
            if (parcheggio[i] != null && m.getTarga() == (parcheggio[i].getTarga())) {
                throw new StessaMacchinaException("La macchina è già nel parcheggio");
            }

        }

        parcheggio[pos] = m;
        nAuto++;

        for (int i = pos; i < 10; i++) {
            if (parcheggio[i] == null) {
                pos = i;
                break;
            }
        }
    }

    public long rimuoviMacchina(String targa) throws MacchinaNonEsistenteException, ParcheggioVuotoException {

        boolean checkPollo = false;


        if (nAuto == 0) {
            throw new ParcheggioVuotoException("il parcheggio è vuoto");
        }


        for (int i = 0; i < 10; i++) {
            if (parcheggio[i] != null && targa == (parcheggio[i].getTarga())) {
                checkPollo = true;
                break;
            }
        }


        if (!checkPollo) {
            throw new MacchinaNonEsistenteException("la macchina è inesistente");
        }

        long secondi = 0;
        int j = 0;

        for (int i = 0; i < parcheggio.length; i++) {

            if (parcheggio[i] != null) {
                System.out.println("In posizione " + i + " veicolo " + parcheggio[i].getTarga() +
                        " entrato al timestamp: " + parcheggio[i].getIngresso());

                if (parcheggio[i].getTarga() == (targa)) {
                    parcheggio[i].setUscita(System.currentTimeMillis());
                    secondi = (parcheggio[i].getUscita().getTime() - parcheggio[i].getIngresso().getTime()) / 1000;
                    j = i;
                }
            }
        }

        parcheggio[j] = null;
        nAuto--;

        if (pos > j) {
            pos = j;
        }

        return secondi;
    }
}