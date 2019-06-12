package com.example.renade.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.renade.R;

public class Home2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }
    public void finalizar (View view){
    Intent finalizar = new Intent(this,RegFinalActivity.class);

    startActivity(finalizar);

    }

}



