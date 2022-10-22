package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Remember to extend AppCompatACtivity when creating a new Java file
public class Menu extends AppCompatActivity {

    private Opt option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        option = Opt.getInstance();
        option.setColumns(getcolumn(this));
        option.setRows(getrow(this));
        option.setMine(getmines(this));
        setContentView(R.layout.menu);
        optionsButton();
        helpButton();

        callGameButton();

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


    private void helpButton(){
        Button button = findViewById(R.id.helpbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = HelpActivity.makeHelpIntent(Menu.this);

                startActivity(helpIntent);
            }
        });
    }

    public static Intent makeIntentHomeScreen(Context context){
        // Returning our new intent
        Intent i = new Intent(context, Menu.class);
        return i;


    }
    static public int getmines(Context context){
        SharedPreferences pref = context.getSharedPreferences("minepref", MODE_PRIVATE);
        return pref.getInt("nummines", 6);
    }

        private void callGameButton () {
            // When the gameButton is clicked
            Button gameButt = findViewById(R.id.playButton);
            gameButt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Menu.this, "Switching to play game", Toast.LENGTH_SHORT).show();
                    // Launch the game screen by using intent
                    Intent intent = game.makeIntentGameScreen(Menu.this);
                    //Intent intent =  new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                }
            });
        }

        static public int getcolumn (Context context){
            SharedPreferences pref = context.getSharedPreferences("columnpref", MODE_PRIVATE);
            return pref.getInt("numcolumns", 6);
        }

    static public int getrow(Context context){
        SharedPreferences pref = context.getSharedPreferences("rowpref", MODE_PRIVATE);
        return pref.getInt("numrows", 4);
    }

}
