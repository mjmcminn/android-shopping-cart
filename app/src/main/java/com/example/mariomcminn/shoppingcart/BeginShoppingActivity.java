package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;

/**
 * Created by mariomcminn on 3/22/16.
 */
public class BeginShoppingActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LandingFragment();
    }
}
