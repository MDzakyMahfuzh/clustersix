package com.example.android.materialme;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterLogin extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.materialme.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

//        EditText name=findViewById(R.id.editTextreg);
//        EditText email=findViewById(R.id.editTextmail);
//        EditText password=findViewById(R.id.editTextpassReg);
//        register=findViewById(R.id.btnregister);
//        database=new DatabaseHelper(this);

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = database.getReadableDatabase();
//                db.execSQL("INSERT INTO user (name,email,password) VALUES ('"+
//                        name.getText().toString()+"', '"+
//                        email.getText().toString()+"', '"+
//                        password.getText().toString()+"'); ");
//                Toast.makeText(getApplicationContext(),"Register Berhasil",Toast.LENGTH_SHORT).show();
//
//                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    public void Register(View view) {
        EditText Editname=findViewById(R.id.editTextreg);
        EditText Editemail=findViewById(R.id.editTextmail);
        EditText Editpassword=findViewById(R.id.editTextpassReg);
        String name=Editname.getText().toString();
        String email=Editemail.getText().toString();
        String password=Editpassword.getText().toString();


        DatabaseHelper database = new DatabaseHelper(this);
        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("email",email);
        values.put("password",password);

        db.insert("user",null,values);
        Toast.makeText(this,"Register Sukses", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
