package com.example.jscarsstyle.Categorias.Exterior.Categoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N1;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N10;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N2;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N3;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N4;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N5;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N6;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N7;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N8;
import com.example.jscarsstyle.Categorias.Exterior.Productos.Pro_Exterior_N9;
import com.example.jscarsstyle.Menu_Apartado;
import com.example.jscarsstyle.R;

import Object_Class.Categorias;
import Object_Class.Exterior;

public class Cat_Exterior extends AppCompatActivity {

    private TextView txt_nombreExt1, txt_nombreExt2, txt_nombreExt3, txt_precioExt1, txt_precioExt2, txt_precioExt3,
            txt_nombreExt4, txt_nombreExt5, txt_nombreExt6, txt_precioExt4, txt_precioExt5, txt_precioExt6,
            txt_nombreExt7, txt_nombreExt8, txt_nombreExt9, txt_precioExt7, txt_precioExt8, txt_precioExt9,
            txt_nomCatGlobalPag1, txt_nombreExt10, txt_precioExt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_exterior);

        txt_nomCatGlobalPag1 = (TextView)findViewById(R.id.txt_nomCatGlobalExtPag1);

        txt_nombreExt1 = (TextView)findViewById(R.id.txt_nobreExtPro1);
        txt_precioExt1 = (TextView)findViewById(R.id.txt_precioExtPro1);
        txt_nombreExt2 = (TextView)findViewById(R.id.txt_nobreExtPro2);
        txt_precioExt2 = (TextView)findViewById(R.id.txt_precioExtPro2);
        txt_nombreExt3 = (TextView)findViewById(R.id.txt_nobreExtPro3);
        txt_precioExt3 = (TextView)findViewById(R.id.txt_precioExtPro3);
        txt_nombreExt4 = (TextView)findViewById(R.id.txt_nobreExtPro4);
        txt_precioExt4 = (TextView)findViewById(R.id.txt_precioExtPro4);
        txt_nombreExt5 = (TextView)findViewById(R.id.txt_nobreExtPro5);
        txt_precioExt5 = (TextView)findViewById(R.id.txt_precioExtPro5);
        txt_nombreExt6 = (TextView)findViewById(R.id.txt_nobreExtPro6);
        txt_precioExt6 = (TextView)findViewById(R.id.txt_precioExtPro6);
        txt_nombreExt7 = (TextView)findViewById(R.id.txt_nobreExtPro7);
        txt_precioExt7 = (TextView)findViewById(R.id.txt_precioExtPro7);
        txt_nombreExt8 = (TextView)findViewById(R.id.txt_nobreExtPro8);
        txt_precioExt8 = (TextView)findViewById(R.id.txt_precioExtPro8);
        txt_nombreExt9 = (TextView)findViewById(R.id.txt_nobreExtPro9);
        txt_precioExt9 = (TextView)findViewById(R.id.txt_precioExtPro9);
        txt_nombreExt10 = (TextView)findViewById(R.id.txt_nobreExtPro10);
        txt_precioExt10 = (TextView)findViewById(R.id.txt_precioExtPro10);

        Categorias obj_cat = new Categorias();

        txt_nomCatGlobalPag1.setText(obj_cat.getNombreCategorias()[1]);

        Exterior obj_ext = new Exterior();

        txt_nombreExt1.setText(obj_ext.getNombreExterior()[0]);
        txt_precioExt1.setText("$" + obj_ext.getPrecioExterior()[0]);
        txt_nombreExt2.setText(obj_ext.getNombreExterior()[1]);
        txt_precioExt2.setText("$" + obj_ext.getPrecioExterior()[1]);
        txt_nombreExt3.setText(obj_ext.getNombreExterior()[2]);
        txt_precioExt3.setText("$" + obj_ext.getPrecioExterior()[2]);
        txt_nombreExt4.setText(obj_ext.getNombreExterior()[3]);
        txt_precioExt4.setText("$" + obj_ext.getPrecioExterior()[3]);
        txt_nombreExt5.setText(obj_ext.getNombreExterior()[4]);
        txt_precioExt5.setText("$" + obj_ext.getPrecioExterior()[4]);
        txt_nombreExt6.setText(obj_ext.getNombreExterior()[5]);
        txt_precioExt6.setText("$" + obj_ext.getPrecioExterior()[5]);
        txt_nombreExt7.setText(obj_ext.getNombreExterior()[6]);
        txt_precioExt7.setText("$" + obj_ext.getPrecioExterior()[6]);
        txt_nombreExt8.setText(obj_ext.getNombreExterior()[7]);
        txt_precioExt8.setText("$" + obj_ext.getPrecioExterior()[7]);
        txt_nombreExt9.setText(obj_ext.getNombreExterior()[8]);
        txt_precioExt9.setText("$" + obj_ext.getPrecioExterior()[8]);
        txt_nombreExt10.setText(obj_ext.getNombreExterior()[9]);
        txt_precioExt10.setText("$" + obj_ext.getPrecioExterior()[9]);
    }

    public void bttMenu(View view){
        Intent i = new Intent(this, Menu_Apartado.class);
        startActivity(i);
    }

    public void abrirExteriorPro1(View view){
        Intent i = new Intent(this, Pro_Exterior_N1.class);
        startActivity(i);
    }

    public void abrirExteriorPro2(View view){
        Intent i = new Intent(this, Pro_Exterior_N2.class);
        startActivity(i);
    }

    public void abrirExteriorPro3(View view){
        Intent i = new Intent(this, Pro_Exterior_N3.class);
        startActivity(i);
    }

    public void abrirExteriorPro4(View view){
        Intent i = new Intent(this, Pro_Exterior_N4.class);
        startActivity(i);
    }

    public void abrirExteriorPro5(View view){
        Intent i = new Intent(this, Pro_Exterior_N5.class);
        startActivity(i);
    }

    public void abrirExteriorPro6(View view){
        Intent i = new Intent(this, Pro_Exterior_N6.class);
        startActivity(i);
    }

    public void abrirExteriorPro7(View view){
        Intent i = new Intent(this, Pro_Exterior_N7.class);
        startActivity(i);
    }

    public void abrirExteriorPro8(View view){
        Intent i = new Intent(this, Pro_Exterior_N8.class);
        startActivity(i);
    }

    public void abrirExteriorPro9(View view){
        Intent i = new Intent(this, Pro_Exterior_N9.class);
        startActivity(i);
    }

    public void abrirExteriorPro10(View view){
        Intent i = new Intent(this, Pro_Exterior_N10.class);
        startActivity(i);
    }
}