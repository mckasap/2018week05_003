package org.kasapbasi.a2018week05_003;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
// Acıklama Satırı :) 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db= openOrCreateDatabase("Test",MODE_PRIVATE,null);

       // db.execSQL("Drop Table MyTable");
        db.execSQL("Create Table If not exists " +
                "MyTable(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " Lastname varchar NOT NULL, " +
                " FirstName CHAR(50) NOT NULL,  " +
                " Age int(3) NOT NULL);");

        db.execSQL("insert  into MyTable(Lastname, FirstName, Age ) Values('kasapbasi', 'mustafa', 61);");

        db.close();

        db= openOrCreateDatabase("Test",MODE_PRIVATE,null);
       // test
        Cursor c= db.rawQuery("Select * from MyTable",null);
        Log.i("DATABASE",c.getColumnCount()+"");

        db.close();
    }
}
