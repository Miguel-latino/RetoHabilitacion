package com.example.retoh.presentacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.retoh.R;
import com.example.retoh.datos.DBHelper;
import com.example.retoh.modelos.Producto;
import com.example.retoh.modelos.ProductoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private DBHelper dbHelper;
    private ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());
        gridView = (GridView) findViewById(R.id.gridProductos);
        productos = new ArrayList<>();

        Cursor cursor = dbHelper.getProductos();
        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Producto producto = new Producto(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getBlob(3)
                );
                productos.add(producto);
            }
        }
        ProductoAdapter productoAdapter = new ProductoAdapter(getApplicationContext(), productos);
        gridView.setAdapter(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this, FormProducts.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}