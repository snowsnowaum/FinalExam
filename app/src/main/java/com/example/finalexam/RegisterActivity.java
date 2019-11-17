package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    public static final String TABLE_NAME = "userTable";

    public static final String COLUMN_USER = "Username";
    public static final String COLUMN_NAME = "FullName";
    public static final String COLUMN_PASS = "Pass";

    private String user;
    private String name;
    private String pass;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_USER + " TEXT PRIMARY KEY "
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_PASS + " TEXT"
                    + ")";

    public RegisterActivity() {
    }

    public RegisterActivity(String user, String name, String pass) {
        this.user = user;
        this.name = name;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean dupli = false;
                List<RegisterActivity> List = new ArrayList<>();
                DB db= new DB(RegisterActivity.this);
                EditText userEditText = findViewById(R.id.username_edit_text);
                EditText passwordEditText = findViewById(R.id.password_edit_text);
                EditText nameEditText = findViewById(R.id.full_name_edit_text);
                if(userEditText.getText().toString().equals("")||passwordEditText.getText().toString().equals("")||nameEditText.getText().toString().equals("")){
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(List.size()==0){
                        db.insertName(userEditText.getText().toString(),nameEditText.getText().toString(), passwordEditText.getText().toString());
                        Toast.makeText(RegisterActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        for(int i = 0;i<List.size();i++){
                            if(List.get(i).equals(userEditText.getText().toString())){
                                Toast.makeText(RegisterActivity.this,"Duplicate Username",Toast.LENGTH_SHORT).show();
                                dupli = true;
                                break;
                            }
                            else{
                                dupli = false;
                            }
                        }
                        if(dupli==false){
                            db.insertName(userEditText.getText().toString(),nameEditText.getText().toString(), passwordEditText.getText().toString());
                            Toast.makeText(RegisterActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}