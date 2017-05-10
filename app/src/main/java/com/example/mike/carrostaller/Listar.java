package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Listar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ListView listaCarros = (ListView)findViewById(R.id.listCarros);

        AdaptadorCarro AdaptadorCarro = new AdaptadorCarro(this, Datos.getCarros());
        listaCarros.setAdapter(AdaptadorCarro);
    }
}

