package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Remember to extend AppCompatACtivity when creating a new Java file
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        optionsButton();

    }

    private void optionsButton() {
        Button button = findViewById(R.id.optionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionIntent = Options.makeOptionsIntent(Menu.this);

                startActivity(optionIntent);
            }
        });
    }

    public static Intent makeIntentHomeScreen(Context context){
        // Returning our new intent
        Intent i = new Intent(context, Menu.class);
        return i;
        //return new Intent(context, Menu.class);
        /*
        Intent intent = new Intent(context, GameScore.class);
        intent.putExtra("positioning", index);
        intent.putExtra("editting", edit);

       */
    }


}
