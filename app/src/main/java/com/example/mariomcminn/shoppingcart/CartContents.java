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
        c1.setQuantity("Axe");
        c2.setQuantity("Chainsaw");
        c3.setQuantity("Crossbow");
        c4.setQuantity("Hammer");
        c5.setQuantity("Machete");
        c6.setQuantity("Shovel");
        c7.setQuantity("Toothpick");
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

    public CartItems getCart(UUID id){
        for (CartItems c : mCart){
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
}
