package com.example.jscarsstyle;

import com.google.firebase.database.FirebaseDatabase;

public class MyFirebaseApp extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //activamos la persistencia para que cuando no tengamos internet
        //y hagamos cambios en la app se guarden igual en firebase una ves
        //tengamos internet
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
