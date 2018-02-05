package com.dnerd.dipty.emptyinbox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    protected EditText mPassword;
    protected EditText mEmail;
    protected Button mLoginButton;
    private FirebaseAuth auth;

    protected TextView mSignUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSignUpTextView = (TextView) findViewById(R.id.signUpText);

        mSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        //mUsername = (EditText) findViewById(R.id.usernameField);
        mPassword = (EditText) findViewById(R.id.passwordField);
        mEmail = (EditText) findViewById(R.id.emailField);
        mLoginButton = (Button) findViewById(R.id.loginButton);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String email = mEmail.getText().toString();

                //username = username.trim();
                password = password.trim();
                email = email.trim();

                if(password.isEmpty()||email.isEmpty())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(R.string.login_error_message)
                            .setTitle(R.string.login_error_title)
                            .setPositiveButton(android.R.string.ok,null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else{
                    //authenticating user
                   auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(!task.isSuccessful())
                           {
                               AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                               builder.setMessage(R.string.firebase_authentication_error)
                                       .setTitle(R.string.login_error_title)
                                       .setPositiveButton(android.R.string.ok,null);
                               AlertDialog dialog = builder.create();
                               dialog.show();
                           }
                           else{
                               Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                               startActivity(intent);
                           }
                       }
                   });
                }

            }
        });
    }
}
