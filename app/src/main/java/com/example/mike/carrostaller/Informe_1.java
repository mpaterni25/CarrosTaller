package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Informe_1 extends AppCompatActivity {

    private ArrayList<Carro> carroArrayList;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_1);

        carroArrayList = Datos.getCarros();
        result = (TextView)findViewById(R.id.txtCarrosRegis);
        result.setText(String.valueOf(carroArrayList.size()));
    }

}
