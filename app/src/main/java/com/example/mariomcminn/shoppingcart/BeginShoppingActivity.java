package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by mariomcminn on 3/22/16.
 */
public class BeginShoppingActivity extends SingleFragmentActivity {

    CartDatabase cartDb;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        cartDb = new CartDatabase(this);
    }

    @Override
    protected Fragment createFragment() {
        return new LandingFragment();
    }

}
