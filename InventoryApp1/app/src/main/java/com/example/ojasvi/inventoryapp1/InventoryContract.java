package com.example.ojasvi.inventoryapp1;

import android.provider.BaseColumns;

public final class InventoryContract {

    private InventoryContract(){}
    public static abstract class ProductEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "product_name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";

    }
}
