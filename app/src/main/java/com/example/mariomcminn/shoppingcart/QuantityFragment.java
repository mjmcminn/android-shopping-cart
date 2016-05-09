package com.example.mariomcminn.shoppingcart;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.UUID;

/**
 * Created by mariomcminn on 2/23/16.
 */
public class QuantityFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_quantity, null);
        NumberPicker np = (NumberPicker) v.findViewById(R.id.numberPicker);
        np.setMaxValue(20);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                ShoppingCartActivity a = (ShoppingCartActivity) getActivity();
                int itemQuantity = newVal;
                a.onItemQuantityPass(itemQuantity);
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.item_quantity_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}