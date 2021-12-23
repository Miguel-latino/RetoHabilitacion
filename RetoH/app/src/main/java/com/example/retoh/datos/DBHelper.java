package com.example.retoh.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, "RetoH.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTOS(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title VARCHAR," +
                "description VARCHAR," +
                "image BLOB" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
    }


    //  **** CRUD ****

    public void insertProductos(String title, String description, byte[] image){
        String sql = "INSERT INTO PRODUCTOS VALUES(null, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, title);
        statement.bindString(2, description);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public Cursor getProductos(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS", null);
        return cursor;
    }

    public void deleteProducto(int id){
        sqLiteDatabase.execSQL("DELETE FROM PRODUCTOS WHERE id = "+ id);
    }

}
