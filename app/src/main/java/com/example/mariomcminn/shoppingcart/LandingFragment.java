package com.example.mariomcminn.shoppingcart;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
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

    Button mBeginShoppingButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.landing_fragment, parent, false);

        mBeginShoppingButton = (Button) v.findViewById(R.id.cart_begin_button);
        mBeginShoppingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CartListActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

}
