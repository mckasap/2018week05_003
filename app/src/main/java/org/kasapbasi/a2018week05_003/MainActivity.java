package org.kasapbasi.a2018week05_003;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
// Acıklama Satırı :) 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db= openOrCreateDatabase("Test",MODE_PRIVATE,null);

        db.execSQL("Create Table if not exists " +
                "MyTable(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "Lastname varchar, " +
                "FirstName CHAR(50),  " +
                "Age int(3));");




    }
}
