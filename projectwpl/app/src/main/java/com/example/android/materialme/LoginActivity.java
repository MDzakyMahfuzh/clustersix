package com.example.android.materialme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.materialme.extra.MESSAGE";
    public static String PREFS_NAME = "rememberme";
    public static String PREF_USERNAME = "email";
    public static String PREF_PASSWORD = "password";


//    EditText email, password;
//    Button login;
//    TextView signup;
//    DatabaseHelper database;
//    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        email=findViewById(R.id.editMaillogin);
//        password=findViewById(R.id.editTextpass);
//        login=findViewById(R.id.btnlogin);
//        signup=findViewById(R.id.btnreglog);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth();
//            }
//        });
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),RegisterLogin.class);
//                startActivity(intent);
//            }
//        });
    }
//
//    private void auth() {
//        String Email = email.getText().toString();
//        String Password=password.getText().toString();
//        database=new DatabaseHelper(this);
//
//        SQLiteDatabase db= database.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM user WHERE email='"+Email+"', AND password='"+Password+"';"
//                ,null);
//        cursor.moveToFirst();
//
//        if (cursor.getCount()>0){
//            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//            intent.putExtra("id",cursor.getString(0));
//            startActivity(intent);
//        }else {
//            Toast.makeText(LoginActivity.this,"Email atau Password Salah",Toast.LENGTH_SHORT).show();
//        }
//    }


    public void login(View view) {
        DatabaseHelper database = new DatabaseHelper(this);
        SQLiteDatabase db = database.getReadableDatabase();

        EditText email=findViewById(R.id.editMaillogin);
        EditText password=findViewById(R.id.editTextpass);

        String[] columns={"email", "password"};
        String[] cValues={email.getText().toString(), password.getText().toString()};

        Cursor cursor=db.query("user", columns, "email = ? AND password = ?", cValues,null, null, null);

        CheckBox ch=(CheckBox)findViewById(R.id.remember_me);
        if (ch.isChecked()) {
            rememberme(email,password);
        }
        if (cursor!=null){
            if (cursor.moveToFirst()){
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this,"User atau Pass Salah!",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void getuser(){
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String email = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);

    }
    public void rememberme(EditText email, EditText password){
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME, String.valueOf(email))
                .putString(PREF_PASSWORD, String.valueOf(password))
                .commit();
    }
    public void clickRegister(View view) {
        Intent intent = new Intent(this, RegisterLogin.class);
        startActivity(intent);
    }

    public void twitter(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void instagram(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://Instagram.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void facebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

}
