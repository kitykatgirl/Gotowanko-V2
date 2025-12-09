package com.example.skprzepisy;

import android.widget.Toast;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    private static ArrayList<Przepis> przepisy = new ArrayList<>();
    private static ArrayList<String> skladniki = new ArrayList<>();
    public static void generujPrzepisy(){
        skladniki.add("Rosół"); skladniki.add("Koncentrat Barszczu");
        przepisy.add(new Przepis("Barszcz", "Zupy", R.drawable.barszcz, skladniki, "Wlej koncentrat barszczu do rosołu :D"));
        skladniki.clear();

        skladniki.add("Tłuste np. mięso, kość"); skladniki.add("Warzywa (opcjonalne)");
        przepisy.add(new Przepis("Rosol", "Zupy", R.drawable.rosol, skladniki, "Wlej do garnka wodę, daj coś tłustego i odstaw aż się ugutoje"));
        skladniki.clear();

        skladniki.add("Rosół"); skladniki.add("Pomidory");
        przepisy.add(new Przepis("Pomidorowa", "Zupy", R.drawable.pomidorowa, skladniki, "Dodaj pomidory do rosołu"));
        skladniki.clear();

        skladniki.add("Czekolada gorzka 100g"); skladniki.add("Czekolada biała 50g"); skladniki.add("Mąka 100g"); skladniki.add("Jajko M");
        przepisy.add(new Przepis("Brownie", "Ciastka", R.drawable.brownie, skladniki, "Dasz radę <3"));
        skladniki.clear();


    }

    public static ArrayList<Przepis> getPrzepisy() {
        generujPrzepisy();
        return przepisy;
    }

    public  static ArrayList<Przepis> zwrocPrzepisyKategoria(String kategoria){
        ArrayList<Przepis> przepisyKategoria = new ArrayList<>();
        getPrzepisy();
        for (Przepis przepis:przepisy){
            if (przepis.getKategoria().equalsIgnoreCase(kategoria)){
                przepisyKategoria.add(przepis);
            }
        }
        return przepisyKategoria;
    }
}
