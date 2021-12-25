package com.example.jscarsstyle.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import Object_Class.Stock;
import Object_Class.Vendedores;

public class Pag_Administrador extends AppCompatActivity {

    private TextView cargo, vendedor;
    private ListView stock;

    Vendedores obj_ven = new Vendedores();

    //creamos objetos de firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //creamos un array list que alamcenara lo que contiene firebase
    private ArrayList<Stock> stockProductos = new ArrayList<>();
    //creamos el adaptador que nos permitira rellenar la lista
    ArrayAdapter<Stock> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_administrador);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedorAdmin);
        cargo = (TextView)findViewById(R.id.txt_cargoVenAdmin);

        stock = (ListView)findViewById(R.id.ListViewStockAdmin);

        obtenerBaseDatos();

        databaseReference.child("Stock").orderByChild("nombreProducto").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                stockProductos.clear();

                for (DataSnapshot op : snapshot.getChildren()) {
                    Stock stockk = op.getValue(Stock.class);
                    stockProductos.add(stockk);

                    arrayAdapter = new ArrayAdapter<Stock>(getBaseContext(), android.R.layout.simple_list_item_1, stockProductos);
                    stock.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");


        for (int i = 0 ; i <= obj_ven.getIds().length ; i++){
            if (vend.equals(obj_ven.getUsuarios()[i])){
                vendedor.setText("Nombre: " + obj_ven.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_ven.getCargo()[i]);
                break;
            }
        }

    }

    public void ingresoStock(View view){
        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");
        Intent i = new Intent(getBaseContext(), Ingreso_Stock.class);
        Bundle bund = new Bundle();
        bund.putString("vender", vend);
        i.putExtras(bund);
        startActivity(i);
    }

    public void ingresoVenta(View view){
        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("loginVendedor");
        Intent i = new Intent(getBaseContext(), Ingreso_Venta.class);
        Bundle bund = new Bundle();
        bund.putString("vender", vend);
        i.putExtras(bund);
        startActivity(i);
    }

    //metodo para inicializar y obtener la base de datos
    public void obtenerBaseDatos(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}