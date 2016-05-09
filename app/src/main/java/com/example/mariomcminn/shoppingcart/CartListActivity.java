package com.example.mariomcminn.shoppingcart;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartListActivity extends SingleFragmentActivity implements CartListFragment.OnDataPass {
    public static final String TAG = "CART LIST ACTIVITY";
    CartItems c = new CartItems();

    @Override
    protected Fragment createFragment() {
        return new CartListFragment();
    }

    @Override
    public void onDataPass(String data) {
        Intent i = new Intent(this, ShoppingCartActivity.class);
        i.putExtra("ITEM_NAME", String.valueOf(data));
        startActivity(i);
    }

    public double passItemCost() {
        return c.getItemCost();
    }

}
