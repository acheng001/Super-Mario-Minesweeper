package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;
import android.widget.Toast;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import ca.cmpt276.cmpt276assignmentthree.model.gameLogic;

public class game extends AppCompatActivity {

    // Number of rows and columns
    private int numRows = 4;
    private int numColumns = 6;

    // Number of mines (Must crate 6 mines)
    private int mines = 6;

    // Number of scans
    private int scans = 0;

    // Have two integer arrays
    List<Integer> rArray = new ArrayList<>();
    List<Integer> cArray = new ArrayList<>();

    // Create an array of buttons to store the image
    Button buttons[][] = new Button[numRows][numColumns];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        popButtons();
    }

    private void popButtons(){
        // Have the random part
        //Random controlStar = new Random();
        gameLogic myGame = new gameLogic();
        // Call the random star generator with game
        myGame.setRandomStar(mines,numRows,numColumns); // Has two array of random numbers

        // Set our arrays to the two arrays from gameLogic
        rArray = myGame.getRowArray();
        cArray = myGame.getColArray();
        /*
        // Add them to teh arrays
        for (int i = 0; i < mines; i++) {
            int r = controlStar.nextInt(4);
            int c = controlStar.nextInt(6);
        }

        for(int i = 0; i < mines;i++){
            Toast.makeText(game.this,"ROW ARRAY: " + rowArray[i],Toast.LENGTH_SHORT).show();
        }

        for(int i = 0; i < mines;i++){
            Toast.makeText(game.this,"COL ARRAY: " + colArray[i],Toast.LENGTH_SHORT).show();
        }
        */

            //int r = controlStar.nextInt(4);
        //int c = controlStar.nextInt(6);
        // Find the table we are working with
        TableLayout table = (TableLayout)  findViewById(R.id.tableforButtons);
        for(int row = 0; row < numRows; row++){
            TableRow tabRow = new TableRow(this);
            // Format the rows by changing the layout (Is the constructor in LayoutParams)
            tabRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            // Add a new row with the table
            table.addView(tabRow);
            for(int col = 0; col < numColumns; col++){
                // When a variable is declared the FINAL keyword, its value CANT be modified which
                // ,makes it a constant
                // Saves each column and row value
                final int finalCOLUMN = col;
                final int finalROW = row;
                //Toast.makeText(game.this, "COLUMN: " + finalCOLUMN,Toast.LENGTH_SHORT).show();
                //Toast.makeText(game.this, "ROW: " + finalROW,Toast.LENGTH_SHORT).show();
                // Populate the row by creating a new button for each column
                Button newButton = new Button(this);

                // Stretches all the buttons correctly
                newButton.setLayoutParams(new TableRow.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1));


                // To display text on the buttons
                // Do button.setText("string")
                newButton.setPadding(0,0,0,0);
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(game.this,"BUTTON CLICKED",Toast.LENGTH_SHORT).show();
                        // Create some kind of boolean that keeps track if it is an image
                        // Generates the whole matrix and if the numnbers match, we are able to clcik
                        //Toast.makeText(game.this, "COLUMN: " + finalCOLUMN, Toast.LENGTH_SHORT).show();
                       //Toast.makeText(game.this, "ROW: " + finalROW, Toast.LENGTH_SHORT).show();
                       // Two random generating ints for sure
                        boolean test = myGame.checkStar(finalROW,finalCOLUMN);
                        if(test == true){
                            clickHelper(finalCOLUMN, finalROW);
                        }
                        // Else if it is not true call the scanner function
                        else{
                            int s = myGame.helpScanner(finalROW, finalCOLUMN);
                            Toast.makeText(game.this,"Score: " + s,Toast.LENGTH_SHORT).show();
                            newButton.setText("" + s);
                        }
                        /*
                        for (int i = 0; i < mines; i++) {
                            final int r = controlStar.nextInt(4);
                            final int c = controlStar.nextInt(6);

                            if (finalROW == r && finalCOLUMN == c) {
                                clickHelper(finalCOLUMN, finalROW);
                            }
                        }
                         */






                        // Else print a text on the number
                        // scannerHelper();

                        //Button myMatrix = buttons[row][col];
                        // When clicked it shows the image of the star
                       // myMatrix.setBackgroundResource(R.drawable.star);
                        // Cannot assign a value to a final variable
                        //newButton = buttons[row][col];
                        //newButton.setBackgroundResource(R.drawable.star);
                    }
                });
                // Add a newButton with the row
               tabRow.addView(newButton);
               buttons[row][col] = newButton;


            }
        }
    }

    private void clickHelper(int c, int r){
        // Calls this function where button is clicked but crashes
       // Toast.makeText(game.this,"BUTTON CLICKED",Toast.LENGTH_SHORT).show();
        Button butt = buttons[r][c]; // Create a 2d array and set it to buttons (PROBLEM IS WITH THIS LINE)
        // Set the background of the buttons to be the picture
        //Toast.makeText(game.this,"EUREKA",Toast.LENGTH_SHORT).show();

        // Lock sizes of the button so they don't change
       buttonSizes();
        // THIS DOESNT SCALE IMAGE TO BUTTON
        //butt.setBackgroundResource(R.drawable.star);
        // Code below scales image to the button
        int currWidth = butt.getWidth();
        int currHeight = butt.getHeight();
        // Use the Bitmap data type
        Bitmap map = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        // Scale the Bitmap
        Bitmap scaledMap = Bitmap.createScaledBitmap(map,currWidth,currHeight,true);
        Resources res = getResources();
        // Set the background for the button to be the star in the end
        butt.setBackground(new BitmapDrawable(res,scaledMap));

    }

    // Helps display the text on the box (UI)
    private void UIScanner(){
        //button.setT
    }

    private void buttonSizes() {
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col< numColumns; col++){
                // Access all the buttons
                Button butt = buttons[row][col];
                // Lock the width
                int width = butt.getWidth();
                butt.setMinimumWidth(width);
                butt.setMaxWidth(width);

                // Lock the height
                int height = butt.getHeight();
                butt.setMinimumHeight(height);
                butt.setMaxHeight(height);
            }
        }
    }

    public static Intent makeIntentGameScreen(Context context){
        // Have the make intent from the game
        return new Intent(context,game.class);
    }

}
