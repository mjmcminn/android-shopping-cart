package com.example.mariomcminn.shoppingcart;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartItems {

    private String mItemName;
    private double mItemCost;
    private int mQuantity;
    private int mPriority;
    private UUID mId;


    CartItems(){
        mId = UUID.randomUUID();
    }

    CartItems(String n, int q, int p, double c){
        mItemName = n;
        mQuantity = q;
        mPriority = p;
        mItemCost = c;
    }

    public String getItemName(){
        return mItemName;
    }

    public void setItemName(String itemName){
        mItemName = itemName;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public double getItemCost() {
        return mItemCost;
    }

    public void setItemCost(double cost) {
        mItemCost = cost;
    }

    public UUID getId() {
        return mId;
    }

    @Override
    public String toString() {
        return mItemName;
    }

}
