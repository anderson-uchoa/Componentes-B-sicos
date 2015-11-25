package br.ufc.quixada.dspdm.atividade01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufc.quixada.dspdm.atividade01.R;
import br.ufc.quixada.dspdm.atividade01.controller.ControllerNota;
import br.ufc.quixada.dspdm.atividade01.model.Nota;

public class MainActivity extends AppCompatActivity {


   private ListView listView;
    private ArrayAdapter<Nota> adapterNotas;
    private ControllerNota controllerNota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controllerNota = new ControllerNota();


    }

    @Override
    protected void onStart() {
        super.onStart();

        listView = ( ListView )findViewById( R.id.listView );

          adapterNotas = new ArrayAdapter<Nota>(this,
                android.R.layout.simple_dropdown_item_1line,controllerNota.getNotas());
        listView.setAdapter(adapterNotas);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_nota) {
            Intent intent = new Intent(this, AddNotaActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_add_categoria) {
            Intent intent = new Intent(this, AddCategoriaActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}