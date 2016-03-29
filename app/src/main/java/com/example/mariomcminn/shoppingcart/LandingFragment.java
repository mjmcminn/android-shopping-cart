package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.UUID;

/**
 * Created by mariomcminn on 3/22/16.
 */
public class LandingFragment extends Fragment {

    public static final String EXTRA_CART_ID = "com.example.mariomcminn.shoppingcart.cart_id";
    private Button mBeginShoppingButton;
    private Button mCartCompleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.landing_fragment, parent, false);

        mBeginShoppingButton = (Button)v.findViewById(R.id.cart_begin_button);
        mBeginShoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CartListActivity.class);
                //i.putExtra(CartFragment.EXTRA_CART_ID, c.getId());
                startActivity(i);
            }
        });

        mCartCompleteButton = (Button)v.findViewById(R.id.cart_complete_button);
        mCartCompleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getActivity().getFragmentManager();
                PriorityFragment dialog = new PriorityFragment();
                //dialog.show(fm, DIALOG_PRIORITY);
            }
        });

        return v;
    }
}
