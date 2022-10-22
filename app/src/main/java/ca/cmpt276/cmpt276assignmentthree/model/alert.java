package ca.cmpt276.cmpt276assignmentthree.model;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatDActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ca.cmpt276.cmpt276assignmentthree.R;

public class alert extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Create view
        View myView = LayoutInflater.from(getActivity()).inflate(R.layout.alert_layout, null);

        // Button Listener
        DialogInterface.OnClickListener myListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int w) {

                switch(w){
                    case DialogInterface.BUTTON_POSITIVE:
                        getActivity().finish();


                    case DialogInterface.BUTTON_NEGATIVE:

                }
            }
        };
        // Build alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Changing message")
                .setView(myView)
                .setPositiveButton(android.R.string.ok, myListener)
                .create();

    }

}
