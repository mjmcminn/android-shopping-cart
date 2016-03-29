package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;

/**
 * Created by mariomcminn on 2/18/16.
 */
public class CartListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CartListFragment();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().popBackStack();
        }
    }
}
