package com.example.mariomcminn.shoppingcart;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartContents {
    private ArrayList<CartItems> mCart;

    private static CartContents sCartContents;
    private Context mAppContext;

    private CartContents(Context appContext) {
        mAppContext = appContext;
        mCart = new ArrayList<CartItems>();
        CartItems c1 = new CartItems();
        CartItems c2 = new CartItems();
        CartItems c3 = new CartItems();
        CartItems c4 = new CartItems();
        CartItems c5 = new CartItems();
        CartItems c6 = new CartItems();
        CartItems c7 = new CartItems();
        //Title of list element
        c1.setItemName("Axe @ $40");
        c2.setItemName("Chainsaw @ $50");
        c3.setItemName("Crossbow @ $70");
        c4.setItemName("Hammer @ $20");
        c5.setItemName("Machete @ $30");
        c6.setItemName("Shovel @ $25");
        c7.setItemName("Toothpick @ $0.05");
        //Adding titles to list to display in adapter
        mCart.add(c1);
        mCart.add(c2);
        mCart.add(c3);
        mCart.add(c4);
        mCart.add(c5);
        mCart.add(c6);
        mCart.add(c7);

    }

    public static CartContents get(Context c){
        if (sCartContents == null){
            sCartContents = new CartContents(c.getApplicationContext());
        }
        return sCartContents;
    }

    public ArrayList<CartItems> getCart(){
        return mCart;
    }

}
