package com.example.mike.carrostaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Informe_2 extends AppCompatActivity {

    private ArrayList<Carro> carroArrayList;
    private TextView audiText, bmwText, buggatiText, ferrariText, nissanText;
    int audi = 0, buggati = 0, bmw = 0, ferrari = 0 , nissan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_2);

        carroArrayList = Datos.getCarros();

        for (int i = 0; i < carroArrayList.size(); i++) {
            if(carroArrayList.get(i).getMarca().equals("Audi")){
                audi++;
            }else if (carroArrayList.get(i).getMarca().equals("Buggati")) {
                buggati++;
            }else if(carroArrayList.get(i).getMarca().equals("Nissan")) {
                nissan++;
            }else if(carroArrayList.get(i).getMarca().equals("Ferrari")){
                ferrari++;
            }else {
                bmw++;
            }
        }

        audiText = (TextView)findViewById(R.id.txtCarrosAudi);
        buggatiText = (TextView)findViewById(R.id.txtCarrosBuggati);
        ferrariText = (TextView)findViewById(R.id.txtCarrosFerrari);
        nissanText = (TextView)findViewById(R.id.txtCarrosNissan);
        bmwText = (TextView)findViewById(R.id.txtCarrosBmw);

        bmwText.setText(String.valueOf(bmw));
        audiText.setText(String.valueOf(audi));
        buggatiText.setText(String.valueOf(buggati));
        ferrariText.setText(String.valueOf(ferrari));
        nissanText.setText(String.valueOf(nissan));
    }
}

