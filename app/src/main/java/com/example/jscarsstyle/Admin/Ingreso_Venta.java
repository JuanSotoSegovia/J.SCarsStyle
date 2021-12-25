package com.example.jscarsstyle.Admin;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Object_Class.Productos;
import Object_Class.Stock;
import Object_Class.Vendedores;
import Object_Class.Ventas;

public class Ingreso_Venta extends AppCompatActivity {

    private TextView vendedor, cargo;
    private Spinner sp_vendedor, sp_producto;
    private EditText numVenta, fechaVenta, cantidad;
    private Button ingresarVenta;

    Vendedores obj_ven = new Vendedores();
    Productos obj_pro = new Productos();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_venta);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedorAdmin);
        cargo = (TextView)findViewById(R.id.txt_cargoVenAdmin);

        sp_vendedor = (Spinner)findViewById(R.id.sp_Vendedor);
        sp_producto = (Spinner)findViewById(R.id.sp_producto2);
        numVenta = (EditText)findViewById(R.id.edt_IngresoNumVenta);
        fechaVenta = (EditText)findViewById(R.id.edt_ingresoFechaVenta);
        cantidad = (EditText)findViewById(R.id.edt_cantidad);

        ingresarVenta = (Button)findViewById(R.id.btt_IngresarVenta);

        Bundle bun =getIntent().getExtras();
        String vend =bun.getString("vender");

        for (int i = 0 ; i <= obj_ven.getIds().length ; i++){
            if (vend.equals(obj_ven.getUsuarios()[i])){
                vendedor.setText("Nombre: " + obj_ven.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_ven.getCargo()[i]);
                break;
            }
        }

        ArrayAdapter adapterVendedor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, obj_ven.getNombreApe());
        sp_vendedor.setAdapter(adapterVendedor);

        ArrayAdapter adapterProducto = new ArrayAdapter(this, android.R.layout.simple_list_item_1, obj_pro.getProducto());
        sp_producto.setAdapter(adapterProducto);

        obtenerFirebase();

        ingresarVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idVenta = numVenta.getText().toString();
                String feVenta = fechaVenta.getText().toString();
                String venedorSe = sp_vendedor.getSelectedItem().toString();
                String productoSe = sp_producto.getSelectedItem().toString();
                String cantidadPro = cantidad.getText().toString();

                try {
                    for (int i = 0 ; i <= obj_pro.getId().length ; i++){
                        if (productoSe.equals(obj_pro.getProducto()[i])){
                            String idPro = obj_pro.getId()[i];
                            String precioPro = obj_pro.getPrecio()[i];
                            String comisionPro = obj_pro.getComision()[i];

                            //pasamos a int
                            int precioProducto = Integer.parseInt(precioPro);
                            int comisionProducto = Integer.parseInt(comisionPro);

                            int cantidadProducto = Integer.parseInt(cantidadPro);

                            int tPrecio = precioProducto*cantidadProducto;
                            int tcomision = comisionProducto*cantidadProducto;

                            String totalPrecio = String.valueOf(tPrecio);
                            String totalComision = String.valueOf(tcomision);

                            Ventas vProducto = new Ventas();

                            vProducto.setUid(UUID.randomUUID().toString());
                            vProducto.setId(idVenta);
                            vProducto.setFecha(feVenta);
                            vProducto.setVendedor(venedorSe);
                            vProducto.setProducto(productoSe);
                            vProducto.setIdProducto(idPro);
                            vProducto.setPrecio(precioPro);
                            vProducto.setComision(comisionPro);
                            vProducto.setCatidad(cantidadPro);
                            vProducto.setTotalPrecio(totalPrecio);
                            vProducto.setTotalComision(totalComision);

                            databaseReference.child("Ventas").child(vProducto.getUid()).setValue(vProducto);

                            limpiarCampo();

                            Toast.makeText(getBaseContext(),"Venta Añadida",Toast.LENGTH_SHORT).show();

                            break;
                        }
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }

    public void limpiarCampo (){
        numVenta.setText("");
        fechaVenta.setText("");
        cantidad.setText("");

    }

    public void obtenerFirebase(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}