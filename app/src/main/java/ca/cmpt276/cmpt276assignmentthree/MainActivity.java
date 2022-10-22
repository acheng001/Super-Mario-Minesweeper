package ca.cmpt276.cmpt276assignmentthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Hello World!";
  //  Options option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //https://www.geeksforgeeks.org/animation-in-android-with-example/
        ImageView image = findViewById(R.id.star);
        Animation anime = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anime);
        image.startAnimation(anime);

        // Call the function
        callMenuButton();


    }

    private void callMenuButton(){
        // When the menuButton is clicked
        Button menuButt= findViewById(R.id.menuButton);
        menuButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Launch the menu screen by using intent
                int index = 0;
                Intent intent = Menu.makeIntentHomeScreen(MainActivity.this);
                //Intent intent =  new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}