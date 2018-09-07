package com.example.donna.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donna.inventoryapp.data.BooksContract;

public class BooksCursorAdapter extends CursorAdapter {

    int qty = 1;

    /**
     * Constructs a new {@link BooksCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public BooksCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = view.findViewById(R.id.name);
        final TextView qtyTextView = view.findViewById(R.id.qty);
        TextView priceTextView = view.findViewById(R.id.price);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(BooksContract.BookEntry.COLUMN_BOOK_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(BooksContract.BookEntry.COLUMN_BOOK_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(BooksContract.BookEntry.COLUMN_BOOK_PRICE);

        // Read the pet attributes from the Cursor for the current pet
        String bookName = cursor.getString(nameColumnIndex);
        String bookQuantity = cursor.getString(quantityColumnIndex);
        String bookPrice = cursor.getString(priceColumnIndex);


        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(bookName);
        qtyTextView.setText(bookQuantity);
        priceTextView.setText(bookPrice);


        // Quantity Button
        final Button sale = view.findViewById(R.id.sale);
        // Change the quantity when you click the button
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = Integer.parseInt(qtyTextView.getText().toString());
                String stringValue;
                if (qty > 0) {
                    qty -= 1;
                    stringValue = String.valueOf(qty);
                    qtyTextView.setText(stringValue);
                } else {
                    Toast.makeText(context, "Can't have negative input.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

