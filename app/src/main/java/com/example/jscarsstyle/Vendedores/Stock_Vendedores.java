package com.example.jscarsstyle.Vendedores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class Stock_Vendedores extends AppCompatActivity {

    private TextView vendedor, cargo;
    private ListView stock;

    Vendedores obj_vend = new Vendedores();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ArrayList<Stock> stockProductos = new ArrayList<>();
    ArrayAdapter<Stock> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_vendedores);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedorStock);
        cargo = (TextView)findViewById(R.id.txt_cargoVenStock);

        stock = (ListView)findViewById(R.id.listViewStockVendedores);

        obtenerBaseDatos();

        databaseReference.child("Stock").orderByChild("nombreProducto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                stockProductos.clear();

                for (DataSnapshot op : snapshot.getChildren()){
                    Stock st = op.getValue(Stock.class);
                    stockProductos.add(st);

                    arrayAdapter = new ArrayAdapter<Stock>(getBaseContext(), android.R.layout.simple_list_item_1, stockProductos);
                    stock.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Bundle bun = getIntent().getExtras();
        String vend =bun.getString("vender");

        for (int i = 0 ; i <= obj_vend.getIds().length ; i++){
            if (vend.equals(obj_vend.getUsuarios()[i])){
                vendedor.setText("Nombre: " + obj_vend.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_vend.getCargo()[i]);
                break;
            }
        }
    }

    public void obtenerBaseDatos(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}