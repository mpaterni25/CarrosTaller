package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Informe_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_4);

        ListView listaCarros = (ListView)findViewById(R.id.listCarrosModelos);
        ArrayList<Carro> carroArrayList = Datos.getCarros();
        ArrayList<Carro> resultadosArrayList = new ArrayList<>();

        for (int i = 0; i < carroArrayList.size(); i++) {
            int modelo = Integer.parseInt(carroArrayList.get(i).getModelo());
            if (modelo >= 2010 && modelo <= 2015){
                resultadosArrayList.add(carroArrayList.get(i));
            }
        }

        AdaptadorCarro AdaptadorCarro = new AdaptadorCarro(this, resultadosArrayList);
        listaCarros.setAdapter(AdaptadorCarro);
    }

}

