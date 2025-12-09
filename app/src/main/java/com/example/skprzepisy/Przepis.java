package com.example.skprzepisy;

import java.util.ArrayList;

public class Przepis {
    private String nazwaPrzepisu;
    private String kategoria;
    private int idObrazka;
    private ArrayList<String> skladniki = new ArrayList<>();
    private String opis;
    private int idPrzepisu;
    private static int licznikPrzepisow = 0;

    public Przepis(String nazwaPrzepisu, String kategoria, int idObrazka, ArrayList<String> skladniki, String opis, int idPrzepisu) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        this.kategoria = kategoria;
        this.idObrazka = idObrazka;
        this.skladniki = skladniki;
        this.opis = opis;
        this.idPrzepisu = idPrzepisu;
    }

    public Przepis(String nazwaPrzepisu) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        kategoria = "ciasta";
        idObrazka = R.drawable.piernik;
        skladniki = new ArrayList<>();
        opis = "";
        licznikPrzepisow++;
        idPrzepisu = licznikPrzepisow;
    }

    public Przepis(String nazwaPrzepisu, String kategoria, int idObrazka) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        this.kategoria = kategoria;
        skladniki = new ArrayList<>();
        skladniki.add("cokolwiek");
        this.opis = "Dasz radę :D";
        this.idObrazka = idObrazka;
        licznikPrzepisow++;
        idPrzepisu = licznikPrzepisow;
    }

    public Przepis(String nazwaPrzepisu, String kategoria, int idObrazka, ArrayList<String> skladniki, String opis) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        this.kategoria = kategoria;
        this.idObrazka = idObrazka;
        this.skladniki = skladniki;
        this.opis = opis;
        licznikPrzepisow++;
        idPrzepisu = licznikPrzepisow;
    }

    @Override
    public String toString() {
        return "Przepisy{" +
                "nazwaPrzepisu='" + nazwaPrzepisu + '\'' +
                '}';
    }

    public int getIdPrzepisu() {
        return idPrzepisu;
    }

    public String getNazwaPrzepisu() {
        return nazwaPrzepisu;
    }

    public String getKategoria() {
        return kategoria;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public ArrayList<String> getSkladniki() {
        return skladniki;
    }

    public String getOpis() {
        return opis;
    }
}
