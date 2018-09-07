package com.example.donna.inventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class BooksContract {
    //** Content authority*/
    public static final String CONTENT_AUTHORITY = "com.example.android.book";
    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    //** Possible paths*/
    public static final String PATH_BOOKS = "books";

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BooksContract() {
    }

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single pet.
     */
    public static final class BookEntry implements BaseColumns {

        /**
         * The content URI to access the pet data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);


        /**
         * Name of database table for pets
         */
        public final static String TABLE_NAME = "books";

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * Unique ID for book (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME = "name";

        /**
         * Author of the book.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_AUTHOR = "author";


        /**
         * Price of the pet.
         * <p>
         * Type: Int
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of the books.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Book supplier
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER = "supplier";

        /**
         * Supploer phone number.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplier_phone";

    }

}