package com.example.senamit.booklistingapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;

/**
 * Created by senamit on 1/10/17.
 */

public class AlertDialogSettingFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);


        /**
         * Return the {@link FragmentActivity} this fragment is currently associated with.
         * May return {@code null} if the fragment is associated with a {@link Context}
         * instead.   this is for getActivity()
         */



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.internetAlertMessage).setTitle(R.string.interntAlertTitle).setPositiveButton(R.string.firealert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        return builder.create();


    }


}
