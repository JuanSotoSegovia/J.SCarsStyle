package com.example.jscarsstyle.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jscarsstyle.Admin.Pag_Administrador;
import com.example.jscarsstyle.R;
import com.example.jscarsstyle.Vendedores.Pag_Vendedores;

import Object_Class.Vendedores;

public class Login extends AppCompatActivity {

    private EditText user, pass;
    private Button inicio;
    private ProgressBar bar;
    private TextView error;
    Vendedores vendedor = new Vendedores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.edt_user);
        pass = (EditText)findViewById(R.id.edt_pass);
        inicio = (Button)findViewById(R.id.btt_inicio);
        bar = (ProgressBar)findViewById(R.id.pgb_redondo);
        error = (TextView)findViewById(R.id.txt_error);

        user.setText("");
        pass.setText("");

        bar.setVisibility(View.INVISIBLE);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                error.setText("");
                new Task().execute();
            }
        });

    }

    //tarea asincrona
    class Task extends AsyncTask<String, Void, String> {
        //define la configuracion inicial de mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar.setVisibility(View.VISIBLE);
        }
        //realiza el proceso en segundo plano o mi tarea pesada
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 3; i++){
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        //finaliza tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //validacion en on postexecute
            //captura de valores ingrewsados por pantalla
            String usuario = user.getText().toString().trim();
            String contraseña = pass.getText().toString().trim();

            for(int i = 0; i <= vendedor.getIds().length; i++){
                try {
                    if(usuario.equals(vendedor.getUsuarios()[i]) && contraseña.equals(vendedor.getPasswords()[i])){
                        if (vendedor.getCargo()[i].equals("Administrador")){
                            Intent inte = new Intent(getBaseContext(), Pag_Administrador.class);
                            user.setText("");
                            pass.setText("");
                            error.setText("");
                            Bundle bun = new Bundle();
                            bun.putString("loginVendedor", usuario);
                            inte.putExtras(bun);
                            bar.setVisibility(View.INVISIBLE);
                            startActivity(inte);
                            break;
                        }
                        Intent intent = new Intent(getBaseContext(), Pag_Vendedores.class);
                        user.setText("");
                        pass.setText("");
                        error.setText("");
                        Bundle bun = new Bundle();
                        bun.putString("loginVendedor", usuario);
                        intent.putExtras(bun);
                        bar.setVisibility(View.INVISIBLE);
                        startActivity(intent);
                        break;
                    }

                    else if(usuario.equals("") && contraseña.isEmpty()){
                        bar.setVisibility(View.INVISIBLE);
                        error.setText("Campos vacios, ingrese usuario y contraseña.");
                        break;
                    }

                    else if(!usuario.equals(vendedor.getUsuarios()[i]) && !contraseña.equals(vendedor.getPasswords()[i])){
                        bar.setVisibility(View.INVISIBLE);
                        user.setText("");
                        pass.setText("");
                        error.setText("Usuario o contraseña invalida, intente nuevamente.");
                    }
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        }
    }
}