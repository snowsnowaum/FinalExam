package com.example.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam.DB;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private DB db;
    private List<store> List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DB(LoginActivity.this);
        List.addAll(db.getAllNotes());
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userEditText = findViewById(R.id.username_edit_text);
                EditText passwordEditText = findViewById(R.id.password_edit_text);
                if(userEditText.getText().toString().equals("")||passwordEditText.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else if(List.size()==0){
                    Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
                }
                else {
                    for(int i = 0;i<List.size();i++){
                        if(List.get(i).equals(userEditText.getText().toString())){
                            if(List.get(i).equals(passwordEditText.getText().toString())){
                                Toast.makeText(LoginActivity.this,"Welcome"+" "+List.get(i).getName(),Toast.LENGTH_SHORT).show();
                                break;
                            }
                            else{
                                Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        if(i==List.size()){
                            Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }


}
