package com.example.mariomcminn.shoppingcart;

import android.app.Fragment;

/**
 * Created by mariomcminn on 3/30/16.
 */
public class CompleteCartActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return new CompleteCartFragment();
    }

}
