package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Informe_3 extends AppCompatActivity {

    private ArrayList<Carro> carroArrayList;
    private TextView amarilloText, rojoText, azulText;
    int amarillo = 0, rojo = 0, azul = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_3);

        carroArrayList = Datos.getCarros();
        amarilloText = (TextView) findViewById(R.id.txtCarrosAmarillos);
        rojoText = (TextView) findViewById(R.id.txtCarrosRojos);
        azulText = (TextView) findViewById(R.id.txtCarrosAzules);

        for (int i = 0; i < carroArrayList.size(); i++) {
            if (carroArrayList.get(i).getColor().equals("Amarillo") || carroArrayList.get(i).
                    getColor().equals("Yellow")) {
                amarillo++;
            } else if (carroArrayList.get(i).getColor().equals("Rojo") || carroArrayList.get(i).
                    getColor().equals("Red")) {
                rojo++;
            } else {
                azul++;
            }
        }

        amarilloText.setText(String.valueOf(amarillo));
        rojoText.setText(String.valueOf(rojo));
        azulText.setText(String.valueOf(azul));
    }
}

