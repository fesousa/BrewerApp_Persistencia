package br.com.fernandosousa.brewerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fsousa on 09/09/2017.
 */

public class CervejasAdapter extends BaseAdapter {

    private final Context context;
    private final List<Cerveja> listaCervejas;

    public CervejasAdapter(Context context, List<Cerveja> listaCervejas) {
        this.context = context;
        this.listaCervejas = listaCervejas;
    }

    @Override
    public int getCount() {
        return listaCervejas != null? listaCervejas.size():0;
    }

    @Override
    public Object getItem(int posicao) {
        return listaCervejas.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        // Infla a View
        View viewText = LayoutInflater.from(context).inflate(R.layout.tela_inicial_itens, viewGroup, false);
        // Procura elementos de tela para atualizar
        TextView t = (TextView)viewText.findViewById(R.id.textItemList);
        ImageView img = (ImageView)viewText.findViewById(R.id.imgCerveja);
      // atualiza valores da view
        Cerveja cerveja = listaCervejas.get(posicao);
        t.setText(cerveja.nome);
        img.setImageResource(cerveja.imagem);
        return viewText;
    }


}
