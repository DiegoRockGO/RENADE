package com.example.renade.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.renade.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {






    public void registrar (View view){

        Intent registrar = new Intent(this,RegisterActivity.class);
        startActivity(registrar);

    }




    public static final String TAG = "LoginActivity";

    private EditText login_Mail,login_Password;
    private Button loginBtn;
    private ProgressBar Login_ProgressBar;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Log.i(TAG, "onCreate: Iniciando Login activity dentro del contexto main");

        setContentView(R.layout.activity_login);

        login_Mail = findViewById(R.id.login_Mail);
        login_Password = findViewById(R.id.login_Password);
        loginBtn = findViewById(R.id.loginBtn);
        Login_ProgressBar = findViewById(R.id.Login_ProgressBar);
        mAuth = FirebaseAuth.getInstance();
        HomeActivity = new Intent(this,com.example.renade.Activities.HomeActivity.class);



    }

    public void onClick(View view) {
        Login_ProgressBar.setVisibility(View.INVISIBLE);
        loginBtn.setOnClickListener(new View.OnClickListener()


        {

            @Override
            public void onClick(View view) {
                Login_ProgressBar.setVisibility(View.VISIBLE);
                loginBtn.setVisibility(View.INVISIBLE);

                final String mail = login_Mail.getText().toString();
                final String password = login_Password.getText().toString();

                if (mail.isEmpty() || password.isEmpty()) {
                    showMessage("Por favor verifique todos los campos");
                    loginBtn.setVisibility(View.VISIBLE);
                    Login_ProgressBar.setVisibility(View.INVISIBLE);
                }
                else
                {
                    signIn(mail,password);
                }


            }




        });
    }

    private void signIn(String mail, String password) {


        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {

                    Login_ProgressBar.setVisibility(View.INVISIBLE);
                    loginBtn.setVisibility(View.VISIBLE);
                    updateUI();

                }
                else {
                    showMessage(task.getException().getMessage());
                    loginBtn.setVisibility(View.VISIBLE);
                    Login_ProgressBar.setVisibility(View.INVISIBLE);
                }


            }
        });



    }

    private void updateUI() {

        startActivity(HomeActivity);
        finish();

    }

    private void showMessage(String text) {

        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {

            updateUI();

        }


    }
}
