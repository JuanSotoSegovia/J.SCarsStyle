package com.example.jscarsstyle.Categorias.Escape.Categoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jscarsstyle.Categorias.Escape.Productos.Pro_Escape_N1;
import com.example.jscarsstyle.Categorias.Escape.Productos.Pro_Escape_N2;
import com.example.jscarsstyle.Categorias.Escape.Productos.Pro_Escape_N3;
import com.example.jscarsstyle.Categorias.Escape.Productos.Pro_Escape_N4;
import com.example.jscarsstyle.Menu_Apartado;
import com.example.jscarsstyle.R;

import Object_Class.Categorias;
import Object_Class.Escape;

public class Cat_Escape extends AppCompatActivity {

    private TextView txt_nombreCat, txt_nombrePro1, txt_precioPro1, txt_nombrePro2, txt_precioPro2,
            txt_nombrePro3, txt_precioPro3,txt_nombrePro4, txt_precioPro4;

    Escape obj_esca = new Escape();
    Categorias obj_cat = new Categorias();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_escape);

        txt_nombreCat = (TextView)findViewById(R.id.txt_nombreCatEsca);
        txt_nombrePro1 = (TextView)findViewById(R.id.txt_escaNomProd1);
        txt_precioPro1 = (TextView)findViewById(R.id.txt_escaPrecProd1);
        txt_nombrePro2 = (TextView)findViewById(R.id.txt_escaNomProd2);
        txt_precioPro2 = (TextView)findViewById(R.id.txt_escaPrecProd2);
        txt_nombrePro3 = (TextView)findViewById(R.id.txt_escaNomProd3);
        txt_precioPro3 = (TextView)findViewById(R.id.txt_escaPrecProd3);
        txt_nombrePro4 = (TextView)findViewById(R.id.txt_escapNomPro4);
        txt_precioPro4 = (TextView)findViewById(R.id.txt_escaPrePro4);

        txt_nombreCat.setText(obj_cat.getNombreCategorias()[0]);

        txt_nombrePro1.setText(obj_esca.getNombreEscape()[0]);
        txt_precioPro1.setText("$"+obj_esca.getPrecioEscape()[0]);
        txt_nombrePro2.setText(obj_esca.getNombreEscape()[1]);
        txt_precioPro2.setText("$"+obj_esca.getPrecioEscape()[1]);
        txt_nombrePro3.setText(obj_esca.getNombreEscape()[2]);
        txt_precioPro3.setText("$"+obj_esca.getPrecioEscape()[2]);
        txt_nombrePro4.setText(obj_esca.getNombreEscape()[3]);
        txt_precioPro4.setText("$"+obj_esca.getPrecioEscape()[3]);
    }

    public void abrirProEsca1(View view){
        Intent i = new Intent(this, Pro_Escape_N1.class);
        startActivity(i);
    }

    public void abrirProEsca2(View view){
        Intent i = new Intent(this, Pro_Escape_N2.class);
        startActivity(i);
    }

    public void abrirProEsca3(View view){
        Intent i = new Intent(this, Pro_Escape_N3.class);
        startActivity(i);
    }

    public void abrirProEsca4(View view){
        Intent i = new Intent(this, Pro_Escape_N4.class);
        startActivity(i);
    }

    public void bttMenu(View view){
        Intent i = new Intent(this, Menu_Apartado.class);
        startActivity(i);
    }
}