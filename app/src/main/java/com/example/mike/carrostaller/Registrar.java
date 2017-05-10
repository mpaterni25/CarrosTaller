package com.example.mike.carrostaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrar extends AppCompatActivity {

    EditText placa, precio;
    Spinner marca, modelo, color;
    Context context;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        context = this;

        Spinner marcaSp = (Spinner) findViewById(R.id.marca_spinner);
        ArrayAdapter<CharSequence> MarcaAdapter = ArrayAdapter.createFromResource(this,
                R.array.marca_spinner, android.R.layout.simple_spinner_item);
        MarcaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marcaSp.setAdapter(MarcaAdapter);

        Spinner modeloSp = (Spinner) findViewById(R.id.modelo_spinner);
        ArrayAdapter<CharSequence> modeloAdapter = ArrayAdapter.createFromResource(this,
                R.array.modelo_spinner, android.R.layout.simple_spinner_item);
        modeloAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeloSp.setAdapter(modeloAdapter);

        Spinner colorSp = (Spinner) findViewById(R.id.color_spinner);
        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this,
                R.array.color_spinner, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSp.setAdapter(colorAdapter);

        placa = (EditText)findViewById(R.id.txtPlaca);
        marca = (Spinner)findViewById(R.id.marca_spinner);
        modelo = (Spinner)findViewById(R.id.modelo_spinner);
        color = (Spinner)findViewById(R.id.color_spinner);
        precio = (EditText)findViewById(R.id.txtPrecio);
    }

    public void registrar(View v){
        String placaFinal="", evalplaca, precioFinal, marcaFinal, modeloFinal, colorFinal;
        int fotoFinal;
        int vector [] = {R.drawable.audi, R.drawable.bmw, R.drawable.buggati, R.drawable.ferrari,
                R.drawable.nissan};

        evalplaca = placa.getText().toString().trim();

        if (evalplaca.isEmpty()){
            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                    msjError3Cuerpo).show();
        }else if (evalplaca.length() == 6) {
            Pattern p = Pattern.compile("^[a-zA-Z]*$");
            Matcher m = p.matcher(evalplaca.substring(0,3));
            boolean b = m.matches();
            System.out.println("letra: "+b);
            if (b == true){
                placaFinal = evalplaca.toUpperCase();
            }else{
                new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                        msjError1Cuerpo).show();
                return;
            }

            p = Pattern.compile("^[0-9]*$");
            m = p.matcher(evalplaca.substring(3, 6));
            b = m.matches();
            //System.out.println("numero: "+b);
            if (b == true){
                placaFinal.concat(evalplaca.substring(3,6));
            }else{
                new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                        msjError2Cuerpo).show();
                return;
            }

            marcaFinal = marca.getSelectedItem().toString();
            modeloFinal = modelo.getSelectedItem().toString();
            colorFinal = color.getSelectedItem().toString();
            precioFinal = precio.getText().toString().trim();

            Random rnd = new Random();
            fotoFinal = rnd.nextInt(5-0);
            //System.out.println(fotoFinal);

            Carro c = new Carro(vector[fotoFinal], placaFinal, marcaFinal, modeloFinal, colorFinal, precioFinal);
            Datos.guardar(c);

            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.msjCuerpo).show();

            limpiar(v);
        }else   {
            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.msjError4Cuerpo).show();
        }
    }

    public void limpiar(View v){
        placa.setText("");
        precio.setText("");
        placa.requestFocus();
    }
}
