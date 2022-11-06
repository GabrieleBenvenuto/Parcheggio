package main;

import java.sql.Timestamp;

public class Macchina {
    private String targa;
    Timestamp ingresso, uscita;

    public Macchina(String targa, long ingresso) {
        this.targa = targa;
        this.ingresso = new Timestamp(ingresso);
        System.out.println("Ingresso veicolo " + targa + " al timestamp " + this.ingresso);
    }


    public String getTarga() {
        return targa;
    }

    public Timestamp getIngresso() {
        return ingresso;
    }

    public Timestamp getUscita() {
        return uscita;
    }

    public void setUscita(long uscita) {
        this.uscita = new Timestamp(uscita);
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setIngresso(Timestamp ingresso) {
        this.ingresso = ingresso;
    }
}
