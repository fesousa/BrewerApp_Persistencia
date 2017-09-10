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

                String textoNomeCerveja = nomeCerveja.getText().toString();
                String textoTipoCerveja = tipoCerveja.getText().toString();
                String textoPaisCerveja = paisCerveja.getText().toString();
                String textoEnderecoCerveja = enderecoCerveja.getText().toString();
                String textoPrecoCerveja = precoCerveja.getText().toString();


                Intent returnIntent = new Intent();
                returnIntent.putExtra("nomeCerveja", textoNomeCerveja);
                returnIntent.putExtra("tipoCerveja", textoTipoCerveja);
                returnIntent.putExtra("paisCerveja", textoPaisCerveja);
                returnIntent.putExtra("enderecoCerveja", textoEnderecoCerveja);
                returnIntent.putExtra("precoCerveja", textoPrecoCerveja);

                // vverificar se checkbox está selecionado
                CheckBox check = (CheckBox) findViewById(R.id.checkFavorita);
                boolean checkFavorita = check.isChecked();
                returnIntent.putExtra("favorita", checkFavorita);

                // verificar se Toggle está ligado ou desligado
                ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
                boolean toggleOrigem = toggle.isChecked();
                returnIntent.putExtra("origem", toggleOrigem);

                // recuperar id do Radio selecionado
                RadioGroup grupoBrilho = (RadioGroup) findViewById(R.id.grupoBrilho);
                int idRadio = grupoBrilho.getCheckedRadioButtonId();

                //recuperar texto do grupo selecionado
                RadioButton botaoSelecionado = (RadioButton) findViewById(idRadio);
                String textoRadio = botaoSelecionado.getText().toString();
                returnIntent.putExtra("brilho", textoRadio);


                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        };
    }
}
