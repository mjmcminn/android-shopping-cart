package com.example.mariomcminn.shoppingcart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by mariomcminn on 3/5/16.
 */
public class PriorityFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_priority, null);

        final NumberPicker np = (NumberPicker) v.findViewById(R.id.numberPicker);
        np.setMaxValue(7);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        int priority = np.getValue();
        Intent i = new Intent();
        i.putExtra(CartFragment.EXTRA_CART_ID, priority);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.item_priority_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
