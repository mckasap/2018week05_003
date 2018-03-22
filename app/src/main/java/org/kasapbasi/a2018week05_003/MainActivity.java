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
// TABLE Create
       // db.execSQL("Drop Table MyTable");
        db.execSQL("Create Table If not exists " +
                "MyTable(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " Lastname varchar NOT NULL, " +
                " FirstName CHAR(50) NOT NULL,  " +
                " Age int(3) NOT NULL);");
// INSERT
        db.execSQL("insert  into MyTable(Lastname, FirstName, Age ) Values('kasapbasi', 'mustafa', 61);");
        Cursor c=db.rawQuery("SELECT *from SQLITE_SEQUENCE",null);
        if(c!=null&&c.moveToFirst())
          Log.i("DATABASE:", " INSERTED ID:"+ c.getInt(1));


        db.close();

//UPDATE
        db= openOrCreateDatabase("Test",MODE_PRIVATE,null);
        db.execSQL("UPDATE MyTable set Lastname='HEADBUTCHER', " +
                " FirstName='Mustafa' where Id=1");
//
        db.close();
//Delete
        db= openOrCreateDatabase("Test",MODE_PRIVATE,null);
        db.execSQL("Delete  from MyTable where Id=3");

//
        db.close();

  // READING
        db= openOrCreateDatabase("Test",MODE_PRIVATE,null);
       // test
        c= db.rawQuery("Select * from MyTable",null);
        Log.i("DATABASE",c.getColumnCount()+"");

        if(c!=null && c.moveToFirst())
             do{
                 Log.i("DATABASE","ID:"+c.getInt(c.getColumnIndex("Id")));
                 Log.i("DATABASE","LastName:"+c.getString(c.getColumnIndex("Lastname")));
                 Log.i("DATABASE","FirstName:"+c.getString(c.getColumnIndex("FirstName")));
                 Log.i("DATABASE","Age:"+c.getInt(c.getColumnIndex("Age")));
             }while(c.moveToNext());
        db.close();




    }
}



