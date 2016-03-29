package com.example.mariomcminn.shoppingcart;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartListFragment extends ListFragment {

    private ArrayList<CartItems> mShoppingCart;
    private static final String TAG = "CartListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.cart_title);
        mShoppingCart = CartContents.get(getActivity()).getCart();
        ShoppingCartAdapter adapter = new ShoppingCartAdapter(mShoppingCart);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        CartItems c = ((ShoppingCartAdapter)getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), ShoppingCartActivity.class);
        i.putExtra(CartFragment.EXTRA_CART_ID, c.getId());
        startActivity(i);
    }

    private class ShoppingCartAdapter extends ArrayAdapter<CartItems> {
        public ShoppingCartAdapter(ArrayList<CartItems> cart) {
            super(getActivity(), 0, cart);
        }
        //----------------------------------------------------
        // Inflates the view of the initial screen
        //----------------------------------------------------
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_cart, null);
            }
            // Configure the view for this cart
            CartItems c = getItem(position);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.cart_list_item_titleTextView);
            titleTextView.setText(c.getQuantity());

            return convertView;
        }
    }

}
