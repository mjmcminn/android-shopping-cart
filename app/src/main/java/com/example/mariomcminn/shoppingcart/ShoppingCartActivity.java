package com.example.mariomcminn.shoppingcart;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.UUID;

public class ShoppingCartActivity extends SingleFragmentActivity {
    public static final String TAG = "SHOPPING CART ACTIVITY ";
    CartItems c = new CartItems();

    @Override
    protected Fragment createFragment() {
        return new CartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String itemName = i.getStringExtra("ITEM_NAME");
        int itemQuantity = i.getIntExtra("ITEM_QUANTITY", 0);
        double itemCost = i.getDoubleExtra("ITEM_COST", 0);
        c.setItemName(itemName);
        c.setQuantity(itemQuantity);
        c.setItemCost(itemCost);
    }

    public String passData() {
        return c.getItemName();
    }

    public Double passItemCost() {
        return c.getItemCost();
    }

    public int passItemQuantity(){
        return c.getQuantity();
    }

    public int passItemPriority(){
        return c.getPriority();
    }

    public void onItemQuantityPass(int itemQuantity) {
        c.setQuantity(itemQuantity);
    }

    public void onItemPriorityPass(int itemPriority) {
        c.setPriority(itemPriority);
    }
}
