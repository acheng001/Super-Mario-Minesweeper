package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ca.cmpt276.cmpt276assignmentthree.model.Opt;

public class helpUI extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.help);
    }

    public static Intent makeHelpIntent(Context context){

        Intent intent = new Intent(context, helpUI.class);
//        intent.putExtra("row", row);
//        intent.putExtra("column", column);
        return intent;
    }
}
