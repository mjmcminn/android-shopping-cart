package com.example.mariomcminn.shoppingcart;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by mariomcminn on 2/17/16.
 */
public class CartFragment extends Fragment{

    private CartItems c = new CartItems();
    private static final String DIALOG_QUANTITY = "quantity";
    private static final String DIALOG_PRIORITY = "priority";
    private Button mQuantityButton;
    private Button mPriorityButton;
    private Button mAddCartItemButton;
    private Button mViewCartButton;
    private Button mDeleteCartItemButton;
    CartDatabase db;
    double itemCost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping, parent, false);
        mQuantityButton = (Button)v.findViewById(R.id.cart_quantity_button);
        mQuantityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getActivity().getFragmentManager();
                QuantityFragment dialog = new QuantityFragment();
                dialog.show(fm, DIALOG_QUANTITY);
            }
        });

        mPriorityButton = (Button)v.findViewById(R.id.cart_priority_button);
        mPriorityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getActivity().getFragmentManager();
                PriorityFragment dialog = new PriorityFragment();
                dialog.show(fm, DIALOG_PRIORITY);
            }
        });

        mAddCartItemButton = (Button)v.findViewById(R.id.add_cart_item_button);
        mAddCartItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                db = new CartDatabase(getActivity());
                ShoppingCartActivity a = (ShoppingCartActivity) getActivity();
                String itemName = a.passData();
                int itemQuantity = a.passItemQuantity();
                int itemPriority = a.passItemPriority();

                if (itemName.equals("Axe @ $40")) {
                    itemCost = 40 * itemQuantity;
                } else if (itemName.equals("Chainsaw @ $50")){
                    itemCost = 50 * itemQuantity;
                } else if (itemName.equals("Crossbow @ $70")){
                    itemCost = 70 * itemQuantity;
                } else if (itemName.equals("Hammer @ $20")){
                    itemCost = 20 * itemQuantity;
                } else if (itemName.equals("Machete @ $30")){
                    itemCost = 30 * itemQuantity;
                } else if (itemName.equals("Shovel @ $25")){
                    itemCost = 25 * itemQuantity;
                } else if (itemName.equals("Toothpick @ $0.05")){
                    itemCost = 0.05 * itemQuantity;
                }

                boolean isInserted = db.insertCartItem(itemName, itemQuantity,
                        itemPriority, itemCost);
                if (isInserted = true) {
                    Toast.makeText(getActivity(), "ITEMS INSERTED", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "ITEMS NOT INSERTED", Toast.LENGTH_LONG).show();
                }
                db.deleteDuplicates();
            }
        });

        mViewCartButton = (Button)v.findViewById(R.id.view_cart_button);
        mViewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = db.getAllData();
                if (result.getCount() == 0) {
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()) {
                    buffer.append("Id " + result.getString(0) + "\n");
                    buffer.append("Item name " + result.getString(1) + "\n");
                    buffer.append("Quantity " + result.getString(2) + "\n");
                    buffer.append("Priority " + result.getString(3) + "\n");
                    buffer.append("Cost " + result.getString(4) + "\n\n");
                }
                showMessage("Data", buffer.toString());
            }
        });

        mDeleteCartItemButton = (Button)v.findViewById(R.id.delete_cart_item_button);
        mDeleteCartItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteData();
                Toast.makeText(getActivity(), "DATA DELETED", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }

    public void showMessage (String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
