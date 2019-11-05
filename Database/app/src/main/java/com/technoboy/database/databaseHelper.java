package com.technoboy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String Db_Name="GOT.db";
    private static final String Tb_Name="GOT";
    private static final String Col1="Id";
    private static final String Col2="Name";
    private static final String Col3="House";

    public databaseHelper(@Nullable Context context) {
        super(context, Db_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Tb_Name + "("+Col1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Col2+" TEXT,"+Col3+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tb_Name);
        onCreate(db);
    }

    public boolean insertData(String Name,String House){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(Col2,Name);
        data.put(Col3,House);
        long insert = db.insert(Tb_Name, null, data);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Tb_Name,null);
        return cursor;
    }

    public boolean updateData(String Id,String Name,String House){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col1,Id);
        contentValues.put(Col2,Name);
        contentValues.put(Col3,House);
        int update = db.update(Tb_Name, contentValues, Col1 + "=?", new String[]{Id});
        if(update>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteData(String Id){
        SQLiteDatabase db=this.getWritableDatabase();
        int delete = db.delete(Tb_Name, Col1 + "=?", new String[]{Id});
        if(delete>0){
            return true;
        }
        else {
            return false;
        }
    }
}
