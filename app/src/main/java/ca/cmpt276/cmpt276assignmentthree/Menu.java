package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Remember to extend AppCompatACtivity when creating a new Java file
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        callGameButton();

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

    private void callGameButton(){
        // When the gameButton is clicked
        Button gameButt= findViewById(R.id.playButton);
        gameButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Menu.this,"Switching to play game",Toast.LENGTH_SHORT).show();
                // Launch the game screen by using intent
                Intent intent = game.makeIntentGameScreen(Menu.this);
                //Intent intent =  new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}



