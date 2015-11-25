package br.ufc.quixada.dspdm.atividade01.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import br.ufc.quixada.dspdm.atividade01.R;
import br.ufc.quixada.dspdm.atividade01.controller.ControllerCategoria;
import br.ufc.quixada.dspdm.atividade01.controller.ControllerNota;
import br.ufc.quixada.dspdm.atividade01.model.Categoria;
import br.ufc.quixada.dspdm.atividade01.model.Nota;

public class AddNotaActivity extends AppCompatActivity {


    private ControllerCategoria controllerCategoria;
    private ControllerNota controllerNota;
    private AutoCompleteTextView autoTextCategoria;
    private ToggleButton tgEscolherCategoria;
    private EditText etNome;
    private EditText etDescricao;
    private Button btAddNota;
    private Nota nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controllerCategoria = new ControllerCategoria();
        controllerNota = new ControllerNota();
        nota = new Nota();

    }


    @Override
    protected void onStart() {
        super.onStart();

   autoTextCategoria = (AutoCompleteTextView) findViewById(R.id.textAut_Categoria);
        ArrayAdapter<Categoria> adapterCategorias= new ArrayAdapter<Categoria>(this,android.R.layout.simple_dropdown_item_1line, controllerCategoria.getCategorias());

    autoTextCategoria.setAdapter(adapterCategorias);
    autoTextCategoria.setThreshold(0);
        Categoria categoriaPadrao = controllerCategoria.getCategoriaPadrao();
        if (categoriaPadrao != null){
            autoTextCategoria.setText(categoriaPadrao.toString());

        }
    tgEscolherCategoria = (ToggleButton) findViewById(R.id.toggle_sem_categoria);
    tgEscolherCategoria.setChecked(false);
        tgEscolherCategoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    autoTextCategoria.setEnabled(false);
                } else {
                    autoTextCategoria.setEnabled(true);
                }
            }
        });

     etNome = (EditText) findViewById(R.id.nome);
      etDescricao = (EditText) findViewById(R.id.descricao);

        btAddNota = (Button) findViewById(R.id.bt_add_nota);

        btAddNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarNota();
            }
        });


    }

    public void adicionarNota() {

     String descricao = etDescricao.getText().toString().trim();
     String nome = etNome.getText().toString().trim();
        String nomeCategoria = autoTextCategoria.getText().toString().trim();
        if(descricao.equals("") || nome.equals("") ){

            Toast.makeText( getBaseContext(),"Preencha todos os campos!",
                    Toast.LENGTH_LONG ).show();

        } else {

            nota.setNome(nome);
            nota.setDescricao(descricao);

            if (tgEscolherCategoria.isChecked()) {
                controllerNota.addNota(nota);
            } else {
                Categoria categoria = controllerCategoria.getCategoria(nomeCategoria);
                if (categoria == null) {
                    categoria = new Categoria(nomeCategoria, controllerCategoria.AREAS[0]);
                }
                controllerNota.addNota(nota, categoria);
            }

            Toast.makeText( getBaseContext(),"Nota adicionada!",
                    Toast.LENGTH_LONG ).show();

          //  MediaPlayer sound = MediaPlayer.create(getBaseContext(), R.raw.sound);
           // sound.start();

            this.finish();

        }

    }
}