package com.example.ojasvi.inventoryapp1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorActivity extends AppCompatActivity{

    @BindView(R.id.p_name)
    EditText productName;

    @BindView(R.id.p_price)
    EditText productPrice;

    @BindView(R.id.quantity_et)
    EditText quantity;

    @BindView(R.id.supplier_name)
    EditText supplierName;

    @BindView(R.id.supplier_phone_number)
    EditText supplierContact;

    InventoryHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        ButterKnife.bind(this);

        dbHelper = new InventoryHelper(this);
    }

    private void insertBook() {

        String productName = this.productName.getText().toString().trim();
        int productQuantity = Integer.parseInt(quantity.getText().toString().trim());
        int productPrice = Integer.parseInt(this.productPrice.getText().toString().trim());

        String productSupplierName = supplierName.getText().toString().trim();
        String productSupplierPhoneNumber = supplierContact.getText().toString().trim();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME, productName);
        values.put(InventoryContract.ProductEntry.COLUMN_PRICE, productPrice);
        values.put(InventoryContract.ProductEntry.COLUMN_QUANTITY, productQuantity);
        values.put(InventoryContract.ProductEntry.COLUMN_SUPPLIER_NAME, productSupplierName);
        values.put(InventoryContract.ProductEntry.COLUMN_SUPPLIER_PHONE_NUMBER, productSupplierPhoneNumber);

        long id = db.insert(InventoryContract.ProductEntry.TABLE_NAME, null, values);

        if (id != -1) {
            Toast.makeText(this, "product is saved with row id " + id, Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, "Error in saving the product", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                insertBook();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
