package com.example.renade.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.renade.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_final);
    }


    public void fin (View view){
        Intent fin = new Intent(this,HomeActivity.class);

        startActivity(fin);

    }

    public void salir (View view){
        Intent salir = new Intent(this,LoginActivity.class);

        startActivity(salir);

        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(loginActivity);
        finish();


    }
}
