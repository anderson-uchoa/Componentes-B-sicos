package br.ufc.quixada.dspdm.atividade01.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import br.ufc.quixada.dspdm.atividade01.R;
import br.ufc.quixada.dspdm.atividade01.controller.ControllerCategoria;
import br.ufc.quixada.dspdm.atividade01.model.Categoria;

public class AddCategoriaActivity extends AppCompatActivity {


    private ControllerCategoria controllerCategoria;
    private Spinner spinnerAreaRelacionada;
    private Button btnAddCategoria;
    private EditText etNome;
    private RadioGroup padrao;
    private Categoria categoria;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controllerCategoria = new ControllerCategoria();
        categoria = new Categoria();
    }


    @Override
    protected void onStart() {
        super.onStart();

        List<String> areasRelacionadas = Arrays.asList(controllerCategoria.AREAS);
        ArrayAdapter<String> adaptorAreasRelacionadas = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,areasRelacionadas);

        spinnerAreaRelacionada = (Spinner) findViewById(R.id.spinner_area_relacionada);
        spinnerAreaRelacionada.setAdapter(adaptorAreasRelacionadas);

        spinnerAreaRelacionada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        categoria.setAreaRelacionada(controllerCategoria.AREAS[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


        etNome = (EditText) findViewById(R.id.nome);

        btnAddCategoria = (Button) findViewById(R.id.btn_add_categoria);
        btnAddCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarCategoria();
            }
        });



    }

    public void adicionarCategoria(){
        categoria.setNome(etNome.getText().toString().trim());
        if(categoria.getNome().equals("")){

            Toast.makeText( getBaseContext(),"Preencha todos os campos!",
                    Toast.LENGTH_LONG ).show();
            return;
        }



       // MediaPlayer sound = MediaPlayer.create(getBaseContext(), R.raw.sound);
       // sound.start();
        this.finish();
    }


}
