package com.example.jscarsstyle.Categorias.Exterior.Productos;

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

import Object_Class.Exterior;
import Object_Class.Stock;

public class Pro_Exterior_N3 extends AppCompatActivity {

    private TextView txt_nombre, txt_precio, txt_descrip, txt_stock;
    private RatingBar cali;
    private Button cargar;

    Exterior obj_ext = new Exterior();

    //silder de imagenes
    private ViewFlipper vf;
    private int[] image = {R.drawable.brochemetaliconegro1, R.drawable.brocheparachoqueinsta, R.drawable.brochemetalicomediano1, R.drawable.brochemetalicomediano2};


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_exterior_n3);

        //silder de imagenes
        vf = (ViewFlipper)findViewById(R.id.sliderExt3);

        for(int i = 0; i<image.length; i++){
            flip_image(image[i]);
        }

        txt_nombre = (TextView)findViewById(R.id.txt_nombreExt3);
        txt_precio = (TextView)findViewById(R.id.txt_precioExt3);
        txt_descrip = (TextView)findViewById(R.id.txt_descripExt3);
        txt_stock = (TextView)findViewById(R.id.txt_stock_pro3_ext);
        cali = (RatingBar)findViewById(R.id.rtb_pro3_ext);
        cargar = (Button)findViewById(R.id.btt_agregar_pro3_ext);

        cargar.setVisibility(View.INVISIBLE);

        cali.setRating(obj_ext.getCalificcion()[0]);
        //bloquear Ratingbar
        cali.setIsIndicator(true);

        txt_nombre.setText(obj_ext.getNombreExterior()[2]);
        txt_precio.setText("$"+obj_ext.getPrecioExterior()[2]);
        txt_descrip.setText(obj_ext.getDetalleExterior()[2]);

        txt_stock.setVisibility(View.INVISIBLE);

        obtenerBD();

        databaseReference.child("Stock").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot op : snapshot.getChildren()){
                    Stock st = op.getValue(Stock.class);
                    String pro = obj_ext.getNombreExterior()[2];
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