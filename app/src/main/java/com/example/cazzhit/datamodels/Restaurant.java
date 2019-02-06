package com.example.cazzhit.datamodels;

public class Restaurant {

    String nome;
    String indirizzo;
    float prezzoMedio;
    int immagine;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public float getPrezzoMedio() {
        return prezzoMedio;
    }

    public void setPrezzoMedio(float prezzoMedio) {
        this.prezzoMedio = prezzoMedio;
    }

    public int getImmagine() {
        return immagine;
    }

    public void setImmagine(int immagine) {
        this.immagine = immagine;
    }

    public Restaurant(String nome, String indirizzo, float prezzoMedio, int immagine) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.prezzoMedio = prezzoMedio;
        this.immagine=immagine;
    }
}
