package com.melihakkose.parseinstaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText nameTextSignUp;
    EditText passwordTextSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextSignUp=findViewById(R.id.textName_SignUp);
        passwordTextSignUp=findViewById(R.id.textPassword_SignUp);

        ParseUser parseUser= ParseUser.getCurrentUser();

        if(parseUser!=null){
            Intent intent =new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }

    }

    public void SignIn(View view){

        ParseUser.logInInBackground(nameTextSignUp.getText().toString(), passwordTextSignUp.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Welceome: "+user.getUsername(),Toast.LENGTH_LONG).show();

                    //Intent
                    Intent intent =new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void SignUp (View view){

        ParseUser user= new ParseUser();

        user.setUsername(nameTextSignUp.getText().toString());
        user.setPassword(passwordTextSignUp.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"User Created!",Toast.LENGTH_LONG).show();

                    //Intent
                    Intent intent =new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);


                }
            }
        });

    }


}