package ca.cmpt276.cmpt276assignmentthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Hello World!";
  //  Options option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        option = Options.getInstance();
        setContentView(R.layout.activity_main);

        //Log.e(TAG, "sefsefse");
        // Call the function
        callMenuButton();


    }

    private void callMenuButton(){
        // When the menuButton is clicked
        Button menuButt= findViewById(R.id.menuButton);
        menuButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"WORKS",Toast.LENGTH_SHORT).show();
                // Launch the menu screen by using intent
                int index = 0;
                Intent intent = Menu.makeIntentHomeScreen(MainActivity.this);
                //Intent intent =  new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}