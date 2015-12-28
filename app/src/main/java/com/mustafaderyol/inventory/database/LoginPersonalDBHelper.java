package com.mustafaderyol.inventory.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by MstfDryl on 28.12.2015.
 */
public class LoginPersonalDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "LoginPersonal.db";
    public static final String CONTACTS_TABLE_NAME = "LoginPersonal";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_PASSWORD = "password";

    private HashMap hp;

    public LoginPersonalDBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE  TABLE '"+CONTACTS_TABLE_NAME
                +"' ( '"+CONTACTS_COLUMN_ID+"' INTEGER PRIMARY KEY  NOT NULL , '"
                +CONTACTS_COLUMN_EMAIL+"' VARCHAR NOT NULL  UNIQUE , '"
                +CONTACTS_COLUMN_PASSWORD+"' VARCHAR NOT NULL )"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(db);
    }


    public boolean insertLoginPersonal(int id,String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+CONTACTS_TABLE_NAME+" where "+CONTACTS_COLUMN_ID+"="+id+"", null );
        res.moveToFirst();
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
    public boolean updateLoginPersonal(Integer id,String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.update(CONTACTS_TABLE_NAME, contentValues, CONTACTS_COLUMN_ID+" = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteLoginPersonal (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CONTACTS_TABLE_NAME,
                CONTACTS_COLUMN_ID+" = ? ",
                new String[] { Integer.toString(id) });
    }

}

