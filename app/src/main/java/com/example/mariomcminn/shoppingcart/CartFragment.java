package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.UUID;

/**
 * Created by mariomcminn on 2/17/16.
 */
public class CartFragment extends Fragment {

    public static final String EXTRA_CART_ID = "com.example.mariomcminn.shoppingcart.cart_id";
    private CartItems mShoppingCart;
    private static final String DIALOG_QUANTITY = "quantity";
    private static final String DIALOG_PRIORITY = "priority";
    private Button mQuantityButton;
    private Button mPriorityButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID cartId = (UUID)getActivity().getIntent()
                .getSerializableExtra(EXTRA_CART_ID);
        mShoppingCart = CartContents.get(getActivity()).getCart(cartId);
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

        return v;
    }
}
