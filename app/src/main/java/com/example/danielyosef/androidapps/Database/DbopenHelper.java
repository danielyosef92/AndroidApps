/**
 *
 */
package com.example.danielyosef.androidapps.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import static com.example.danielyosef.androidapps.Database.dbContract.DB_NAME;

/**
 * Created by danielyosef on 11/30/16.
 */


public class DbopenHelper extends SQLiteOpenHelper {


        private static final String DB_NAME="myDB.DB";
        private static final int DATABASE_VERSION=1;
        private static final String CREATE_QUERY=
                "CREATE TABLE "+dbContract.MyBirthdaysTable.TABLE_NAME + "(" +dbContract.MyBirthdaysTable.NAME+" TEXT,"+
                        dbContract.MyBirthdaysTable.BIRTH_DATE+" TEXT,"+dbContract.MyBirthdaysTable.NEXT_COMING_BIRTHDAY+" TEXT"+
                        dbContract.MyBirthdaysTable.COMMENT+" TEXT);";

    /**
     * SQL DELETE TABLE SENTENCE
     */
    public static final String DROP_MYBIRTHDAYS_TABLE = "DROP TABLE IF EXISTS" + dbContract.MyBirthdaysTable.TABLE_NAME;

    public DbopenHelper(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "database created or opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "table created or opened");
    }

    public void addInformations(String name, String date, String comment, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbContract.MyBirthdaysTable.NAME,name);
        contentValues.put(dbContract.MyBirthdaysTable.BIRTH_DATE,date);
        /*
        contentValues.put(dbContract.MyBirthdaysTable.NEXT_COMING_BIRTHDAY,nextDate);
        */
        contentValues.put(dbContract.MyBirthdaysTable.COMMENT,comment);
        db.insert(dbContract.MyBirthdaysTable.TABLE_NAME,null, contentValues);
        Log.e("DATABASE OPERATIONS", "one row inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_MYBIRTHDAYS_TABLE);
        onCreate(db);
    }


}
