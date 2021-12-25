package com.example.jscarsstyle.Categorias.Escape.Productos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.jscarsstyle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Object_Class.Escape;
import Object_Class.Stock;

public class Pro_Escape_N4 extends AppCompatActivity {

    private TextView txt_nombre, txt_precio, txt_descrip, txt_stock;
    private RatingBar cali;
    private Button agregar;


    //silder de imagenes
    private ViewFlipper vf;
    private int[] image = {R.drawable.colaa2, R.drawable.colaa21, R.drawable.colaa22, R.drawable.colaa23};

    Escape obj_esca = new Escape();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_escape_n4);

        //silder de imagenes
        vf = (ViewFlipper)findViewById(R.id.sliderEscaPro4);

        for(int i = 0; i<image.length; i++){
            flip_image(image[i]);
        }

        txt_nombre = (TextView)findViewById(R.id.txt_nombreEsca4);
        txt_precio = (TextView)findViewById(R.id.txt_precioEsca4);
        txt_descrip = (TextView)findViewById(R.id.txt_descripEsca4);
        txt_stock = (TextView)findViewById(R.id.txt_stock_pro4_esca);
        cali = (RatingBar)findViewById(R.id.rtb_pro4_esca);
        agregar = (Button)findViewById(R.id.btt_agregar_pro4_esca);

        agregar.setVisibility(View.INVISIBLE);

        cali.setRating(obj_esca.getCalificacion()[3]);
        //bloquear Ratingbar
        cali.setIsIndicator(true);

        txt_nombre.setText(obj_esca.getNombreEscape()[3]);
        txt_precio.setText("$"+obj_esca.getPrecioEscape()[3]);
        txt_descrip.setText(obj_esca.getDetalleEscape()[3]);

        txt_stock.setVisibility(View.INVISIBLE);

        obtenerBD();

        databaseReference.child("Stock").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot op : snapshot.getChildren()){
                    Stock st = op.getValue(Stock.class);
                    String pro = obj_esca.getNombreEscape()[3];
                    if (st.getNombreProducto().equals(pro)){
                        String stPro = st.getStock();

                        txt_stock.setText("Stock: " + stPro);

                        txt_stock.setVisibility(View.VISIBLE);

                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //silder de imagenes
    public void flip_image(int i){
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void agregar(View view){

    }

    public void obtenerBD(){
        FirebaseApp.initializeApp(getBaseContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}