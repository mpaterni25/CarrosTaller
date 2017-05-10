package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Informe_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_6);

        ListView listaCarro = (ListView)findViewById(R.id.listCarroEco);
        ArrayList<Carro> carroArrayList = Datos.getCarros();
        ArrayList<Carro> resultadoArrayList = new ArrayList<>();
        double costoMenor = Double.parseDouble(carroArrayList.get(0).getPrecio());
        resultadoArrayList.add(carroArrayList.get(0));

        for (int i = 0; i < carroArrayList.size(); i++) {
            double costo = Double.parseDouble(carroArrayList.get(i).getPrecio());
            if (costo < costoMenor){
                costoMenor = costo;
                resultadoArrayList.clear();
                resultadoArrayList.add(carroArrayList.get(i));
            }
        }

        AdaptadorCarro AdaptadorCarro = new AdaptadorCarro(this, resultadoArrayList);
        listaCarro.setAdapter(AdaptadorCarro);
    }

}
