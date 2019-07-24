package com.example.renade.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.renade.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void siguiente (View view){

        Intent siguiente = new Intent(this,Home2Activity.class);
        startActivity(siguiente);

    }

    public void salir    (View view){

        Intent salir = new Intent(this,LoginActivity.class);
        startActivity(salir);

        FirebaseAuth.getInstance().signOut();
        Intent loginActivity = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(loginActivity);
        finish();

}
}