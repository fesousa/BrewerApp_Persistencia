package br.com.fernandosousa.brewerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button) findViewById(R.id.botaoCadastro);
        botao.setOnClickListener(clickCadastro());

        CheckBox check = (CheckBox) findViewById(R.id.checkFavorita);
        check.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CadastroActivity.this, "Favorita: " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup grupo = (RadioGroup) findViewById(R.id.grupoBrilho);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(CadastroActivity.this, "Marcado: " + checkedId, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public View.OnClickListener clickCadastro() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText nomeCerveja = (EditText) findViewById(R.id.nomeCerveja);
                EditText tipoCerveja = (EditText) findViewById(R.id.tipoCerveja);
                EditText paisCerveja = (EditText) findViewById(R.id.paisCerveja);
                EditText enderecoCerveja = (EditText) findViewById(R.id.enderecoCerveja);
                EditText precoCerveja = (EditText) findViewById(R.id.precoCerveja);
                EditText imagemCerveja = (EditText) findViewById(R.id.urlImagem);
                EditText latitudeCerveja = (EditText) findViewById(R.id.latitude);
                EditText longitudeCerveja = (EditText) findViewById(R.id.longitude);

                String textoNomeCerveja = nomeCerveja.getText().toString();
                String textoTipoCerveja = tipoCerveja.getText().toString();
                String textoPaisCerveja = paisCerveja.getText().toString();
                String textoEnderecoCerveja = enderecoCerveja.getText().toString();
                String textoPrecoCerveja = precoCerveja.getText().toString();
                String textoImagemCerveja = imagemCerveja.getText().toString();
                String textoLatitudeCerveja = latitudeCerveja.getText().toString();
                String textoLongitudeCerveja = longitudeCerveja.getText().toString();

                // verificar se checkbox está selecionado
                CheckBox check = (CheckBox) findViewById(R.id.checkFavorita);
                boolean checkFavorita = check.isChecked();

                // verificar se Toggle está ligado ou desligado
                ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
                boolean toggleOrigem = toggle.isChecked();

                // recuperar id do Radio selecionado
                RadioGroup grupoBrilho = (RadioGroup) findViewById(R.id.grupoBrilho);
                int idRadio = grupoBrilho.getCheckedRadioButtonId();

                //recuperar texto do grupo selecionado
                RadioButton botaoSelecionado = (RadioButton) findViewById(idRadio);
                String textoRadio = botaoSelecionado.getText().toString();

                Cerveja cerveja = new Cerveja();
                cerveja.brilho = idRadio;
                cerveja.nome = textoNomeCerveja;
                cerveja.endereco = textoEnderecoCerveja;
                cerveja.favorita = checkFavorita ? 1 : 0;
                cerveja.origem = toggleOrigem ? 1: 0;
                cerveja.pais = textoPaisCerveja;
                cerveja.preco = Double.valueOf(textoPrecoCerveja);
                cerveja.tipo = textoTipoCerveja;
                cerveja.imagem = textoImagemCerveja;
                cerveja.latitude = textoLatitudeCerveja;
                cerveja.longitude = textoLongitudeCerveja;

                CervejaDB cervejaDB = new CervejaDB(CadastroActivity.this);

                cervejaDB.save(cerveja);

                //setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        };
    }
}
