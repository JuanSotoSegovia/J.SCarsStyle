package com.example.jscarsstyle.Vendedores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jscarsstyle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Object_Class.Stock;
import Object_Class.Vendedores;
import Object_Class.Ventas;

public class Pag_Vendedores extends AppCompatActivity {

    private TextView cargo, vendedor;
    private ListView ventas;


    //variable que contiene al vendedor logiado
    private String vendedorUsr;

    //objeto de vendedores
    Vendedores obj_ven = new Vendedores();

    //creamos objetos de firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //creamos un array list que alamcenara lo que contiene firebase
    private ArrayList<Ventas> ventaProducto = new ArrayList<>();
    //creamos el adaptador que nos permitira rellenar la lista
    ArrayAdapter<Ventas> arrayAdapter;

    //objeto y variables que contienen el mes y el año
    Calendar fechas = Calendar.getInstance();
    String año = String.valueOf(fechas.get(Calendar.YEAR));
    //al ems se le suma uno por desfase
    String mes = String.valueOf(fechas.get(Calendar.MONTH)+1);

    //validacion de concatenacion mes año
    String mesAñoActual = mes + "-" + año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_vendedores);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedor);
        cargo = (TextView)findViewById(R.id.txt_cargoVen);

        ventas = (ListView)findViewById(R.id.listViewVentas);

        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");

        for (int i = 0 ; i <= obj_ven.getIds().length ; i++){
            if (vend.equals(obj_ven.getUsuarios()[i])){
                vendedorUsr = obj_ven.getNombreApe()[i];
                vendedor.setText("Nombre: " + obj_ven.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_ven.getCargo()[i]);
                break;
            }
        }

        //validacion de toma de datos por consola
        System.out.println(vendedorUsr);

        obtenerBaseDatos();

        databaseReference.child("Ventas").orderByChild("fecha").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ventaProducto.clear();

                for (DataSnapshot op : snapshot.getChildren()) {
                    Ventas ventaa = op.getValue(Ventas.class);

                    if (ventaa.getVendedor().equals(vendedorUsr) && ventaa.getFecha().contains(mesAñoActual)) {
                            ventaProducto.add(ventaa);

                            arrayAdapter = new ArrayAdapter<Ventas>(getBaseContext(), android.R.layout.simple_list_item_1, ventaProducto);
                            ventas.setAdapter(arrayAdapter);

                            continue;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    //metodo para inicializar y obtener la base de datos
    public void obtenerBaseDatos(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void stockVendedores(View view){
        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");

        Intent i = new Intent(getBaseContext(), Stock_Vendedores.class);
        Bundle bund = new Bundle();
        bund.putString("vender", vend);
        i.putExtras(bund);
        startActivity(i);
    }

    public void cajaVendedores(View view){
        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");

        Intent i = new Intent(getBaseContext(), Caja_Vendedores.class);
        Bundle bund = new Bundle();
        bund.putString("vender", vend);
        i.putExtras(bund);
        startActivity(i);
    }

}