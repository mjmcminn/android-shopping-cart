package com.example.mariomcminn.shoppingcart;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by mariomcminn on 3/5/16.
 */
public class PriorityFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_priority, null);
        NumberPicker np = (NumberPicker) v.findViewById(R.id.numberPicker);
        np.setMaxValue(7);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                ShoppingCartActivity a = (ShoppingCartActivity) getActivity();
                int itemPriority = newVal;
                a.onItemPriorityPass(itemPriority);
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.item_priority_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();

    }
}
