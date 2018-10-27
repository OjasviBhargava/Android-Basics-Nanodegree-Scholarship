package com.example.ojasvi.inventoryapp1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.ojasvi.inventoryapp1.InventoryContract.ProductEntry;

public class MainActivity extends AppCompatActivity {

    InventoryHelper dbHelper;
    @BindView(R.id.fab)
    FloatingActionButton inventoryFab;
    @BindView(R.id.text_view_products)
    TextView displayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        inventoryFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        dbHelper = new InventoryHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String project[] = {ProductEntry._ID,
                ProductEntry.COLUMN_PRODUCT_NAME,
                ProductEntry.COLUMN_PRICE,
                ProductEntry.COLUMN_QUANTITY,
                ProductEntry.COLUMN_SUPPLIER_NAME,
                ProductEntry.COLUMN_SUPPLIER_PHONE_NUMBER};

        Cursor cursor = db.query(ProductEntry.TABLE_NAME,
                project, null,
                null, null,
                null, null);
        try {
            displayProducts.setText("The products table contains " + cursor.getCount() + " products:)\n\n");
            displayProducts.append(ProductEntry._ID + " - " +
                    ProductEntry.COLUMN_PRODUCT_NAME + " - " +
                    ProductEntry.COLUMN_PRICE + " - " +
                    ProductEntry.COLUMN_QUANTITY + " - " +
                    ProductEntry.COLUMN_SUPPLIER_NAME + " - " +
                    ProductEntry.COLUMN_SUPPLIER_PHONE_NUMBER + "\n");

            int idColumnIndex = cursor.getColumnIndex(ProductEntry._ID);
            int productNameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME);
            int productPriceColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRICE);
            int productQuantityColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_QUANTITY);
            int productSupplierNameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_SUPPLIER_NAME);
            int productSupplierPhoneNumberColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String productName = cursor.getString(productNameColumnIndex);
                int productPrice = cursor.getInt(productPriceColumnIndex);
                int productQuantity = cursor.getInt(productQuantityColumnIndex);
                String supplierName = cursor.getString(productSupplierNameColumnIndex);
                String supplierNumber = cursor.getString(productSupplierPhoneNumberColumnIndex);

                displayProducts.append(("\n" + currentID + " - " +
                        productName + " - " +
                        productPrice + " - " +
                        productQuantity + " - " +
                        supplierName + " - " +
                        supplierNumber));
            }
        } finally {
            cursor.close();
        }
    }

    private void insertProduct() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_PRODUCT_NAME, "HP Laptop");
        values.put(ProductEntry.COLUMN_PRICE, 20012);
        values.put(ProductEntry.COLUMN_QUANTITY, 10);
        values.put(ProductEntry.COLUMN_SUPPLIER_NAME, "Anand Electronics");
        values.put(ProductEntry.COLUMN_SUPPLIER_PHONE_NUMBER, "91-8011021552");

        long id = db.insert(ProductEntry.TABLE_NAME, null, values);
        Log.i("database Id ", String.valueOf(id));

    }

    private void deleteAllProduct() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(InventoryContract.ProductEntry.TABLE_NAME, null, null);
    }
}