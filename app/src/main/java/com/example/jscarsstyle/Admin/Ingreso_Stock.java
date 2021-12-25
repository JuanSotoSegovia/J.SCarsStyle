package com.example.jscarsstyle.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jscarsstyle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import Object_Class.Productos;
import Object_Class.Stock;
import Object_Class.Vendedores;

public class Ingreso_Stock extends AppCompatActivity {

    private TextView vendedor, cargo;
    private Spinner sp_pro;
    private EditText cant;
    private Button cargar, modificar;

    Vendedores obj_ven = new Vendedores();
    Productos pro =new Productos();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_stock);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedorAdmin);
        cargo = (TextView)findViewById(R.id.txt_cargoVenAdmin);

        sp_pro = (Spinner)findViewById(R.id.sp_producto);
        cant = (EditText)findViewById(R.id.edt_ing_cantidad);

        cargar = (Button)findViewById(R.id.btt_cargar);
        modificar = (Button)findViewById(R.id.btt_modificar_stock);

        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("vender");

        for (int i = 0 ; i <= obj_ven.getIds().length ; i++){
            if (vend.equals(obj_ven.getUsuarios()[i])){
                vendedor.setText("Nombre: " + obj_ven.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_ven.getCargo()[i]);
                break;
            }
        }

        ArrayAdapter adapterPro = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pro.getProducto());
        sp_pro.setAdapter(adapterPro);

        obtenerFirebase();

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String producto = sp_pro.getSelectedItem().toString();
                String cantidad = cant.getText().toString();

                databaseReference.child("Stock").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            String Uid = dataSnapshot.getKey();
                            try {
                                for (int i  = 0; i <= pro.getId().length; i++) {
                                    if(producto.equals(pro.getProducto()[i])) {

                                        Toast.makeText(getBaseContext(),"Este producto ya cuenta con Stock...",Toast.LENGTH_SHORT).show();

                                        //break;
                                    }
                                    else{
                                        String idPro = String.valueOf(pro.getId()[i]);

                                        Stock pStock = new Stock();

                                        pStock.setUid(UUID.randomUUID().toString());
                                        pStock.setId(idPro);
                                        pStock.setNombreProducto(producto);
                                        pStock.setStock(cantidad);

                                        databaseReference.child("Stock").child(pStock.getUid()).setValue(pStock);

                                        limpiarCampo();

                                        Toast.makeText(getBaseContext(),"Stock Añadido",Toast.LENGTH_SHORT).show();

                                        //break;
                                    }
                                }
                            } catch (Exception e){
                                System.out.println(e);
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String producto = sp_pro.getSelectedItem().toString();
                String cantidad = cant.getText().toString();

                databaseReference.child("Stock").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            String Uid = dataSnapshot.getKey();
                            try {
                                for (int i  = 0; i <= pro.getId().length; i++) {
                                    if (producto.equals(pro.getProducto()[i])) {
                                        String idPro = pro.getId()[i];
                                        Map<String, Object> mapPrducto = new HashMap<>();
                                        mapPrducto.put("id", idPro);
                                        mapPrducto.put("nombreProducto", producto);
                                        mapPrducto.put("stock", cantidad);
                                        mapPrducto.put("uid", Uid);

                                        databaseReference.child("Stock").child(Uid).updateChildren(mapPrducto);

                                        limpiarCampo();

                                        Toast.makeText(getBaseContext(),"Stock Modificado",Toast.LENGTH_SHORT).show();

                                        break;
                                    }
                                }
                            } catch (Exception e){
                                System.out.println(e);
                                break;
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }


    public void limpiarCampo (){
        cant.setText("");

    }

    public void obtenerFirebase(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}