package com.example.mariomcminn.shoppingcart;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartItems implements Comparator<CartItems>, Comparable<CartItems>  {

    private String itemName;
    private int itemPri;
    private double itemCost;
    private UUID mId;
    private String mQuantity;
    private String mPriority;
    private Date mDate;
    private boolean mSolved;

    CartItems(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    CartItems(String n, int p, double i){
        itemName = n;
        itemPri = p;
        itemCost = i;
    }

    public String getItemName(){
        return itemName;
    }

    public int getItemPri(){
        return itemPri;
    }

    public double getItemCost() {
        return itemCost;
    }

    public UUID getId(){

        return mId;
    }

    public String getQuantity(){

        return mQuantity;
    }

    public void setQuantity(String quantity){

        mQuantity = quantity;
    }

    @Override
    public String toString(){

        return mQuantity;
    }

    public String getmPriority() {
        return mPriority;
    }

    public void setmPriority(String mPriority) {
        this.mPriority = mPriority;
    }

    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
        mDate = date;
    }
    public boolean isSolved() {
        return mSolved;
    }
    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    @Override
    public int compareTo(CartItems c) {
        return (this.itemName).compareTo(c.getItemName());
    }

    @Override
    public int compare(CartItems c1, CartItems c2) {
        return c1.itemPri - c2.itemPri;
    }
}
