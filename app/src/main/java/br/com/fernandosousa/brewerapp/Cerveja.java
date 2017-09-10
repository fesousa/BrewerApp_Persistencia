package br.com.fernandosousa.brewerapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsousa on 09/09/2017.
 */

public class Cerveja {
    String nome;
    int imagem;

    public Cerveja(String nome, int imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    public static List<Cerveja> getCervejas(){
        List<Cerveja> cervejas = new ArrayList<Cerveja>();
        cervejas.add(new Cerveja("Franziskaner", R.drawable.franziskaner));
        cervejas.add(new Cerveja("Paulaner", R.drawable.paulaner));
        cervejas.add(new Cerveja("Hofabrau", R.drawable.hofbrau));
        cervejas.add(new Cerveja("Sierra Nevada", R.drawable.sierra_nevada));
        cervejas.add(new Cerveja("Heineken", R.drawable.heineken));
        cervejas.add(new Cerveja("Murphys", R.drawable.murphys));

        return cervejas;
    }

}
