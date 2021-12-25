package com.example.jscarsstyle.Vendedores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.jscarsstyle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import Object_Class.Vendedores;
import Object_Class.Ventas;

public class Caja_Vendedores extends AppCompatActivity {

    private TextView vendedor, cargo, ventaTotal, comisionTotal;
    private VideoView videoCaja;

    Vendedores obj_vend = new Vendedores();

    //variable que contiene al vendedor logiado
    private String vendedorUsr;

    //array que almacena los datos de firebase
    ArrayList<Integer> VV = new ArrayList<>();
    ArrayList<Integer> CC = new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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
        setContentView(R.layout.activity_caja_vendedores);

        vendedor = (TextView)findViewById(R.id.txt_nomVendedorCaja);
        cargo = (TextView)findViewById(R.id.txt_cargoVenCaja);
        videoCaja = (VideoView)findViewById(R.id.vw_caja);

        ventaTotal = (TextView)findViewById(R.id.txt_ventaTotalMes);
        comisionTotal = (TextView)findViewById(R.id.txt_TotalComisionMes);

        //rura para llamar el video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoinsentivo;
        Uri uri =  Uri.parse(ruta); //parseo la ruta

        videoCaja.setVideoURI(uri);

        //inicio video automatico
        videoCaja.start();

        //loop para reproducir el video.
        videoCaja.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        Bundle bun = getIntent().getExtras();
        String vend =bun.getString("vender");

        for (int i = 0 ; i <= obj_vend.getIds().length ; i++){
            if (vend.equals(obj_vend.getUsuarios()[i])){
                vendedorUsr = obj_vend.getNombreApe()[i];
                vendedor.setText("Nombre: " + obj_vend.getNombreApe()[i]);
                cargo.setText("Cargo: " + obj_vend.getCargo()[i]);
                break;
            }
        }

        //validacion de toma de datos por consola
        System.out.println(vendedorUsr);

        //--------------------
        obtenerBaseDatos();

        databaseReference.child("Ventas").orderByChild("fecha").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot op : snapshot.getChildren()) {
                    Ventas ventaa = op.getValue(Ventas.class);
                    if (ventaa.getVendedor().equals(vendedorUsr) && ventaa.getFecha().contains(mesAñoActual)) {

                        String valorP = ventaa.getTotalPrecio();
                        String comisionP = ventaa.getTotalComision();
                        int valorPI = Integer.parseInt(valorP);
                        int comisionPI = Integer.parseInt(comisionP);

                        VV.add(valorPI);
                        CC.add(comisionPI);
                        //System.out.println(VV);
                        continue;
                    }
                }
                //System.out.println(VV);
                System.out.println(CC);
                Integer x = 0;
                Integer y = 0;
                for (int i = 0 ; i <= VV.size() ; i++){
                    try {
                        x = x + VV.get(i);
                        y = y + CC.get(i);
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
                //System.out.println(x);
                ventaTotal.setText("Venta Total del Mes: $" + x);
                comisionTotal.setText("Comision Total del Mes: $" + y);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void obtenerBaseDatos(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}