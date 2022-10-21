package ca.cmpt276.cmpt276assignmentthree.model;

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
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import ca.cmpt276.cmpt276assignmentthree.R;

public class gameLogic extends AppCompatActivity {

    // Number of mines
   // private int mines = 6;

    // Create two arrays
    List<Integer> rowArray = new ArrayList<>();
    List<Integer> colArray = new ArrayList<>();
    // Have a boolean array for help Scanner
    List<Boolean> boolArray = new ArrayList<>();

    // Two more arrays to store the user's cclicked buttons
    List<Integer> userRow = new ArrayList<>();
    List<Integer> userColumn= new ArrayList<>();


    // Create an int score that keeps track
    private int score = 0;

    // Keep track of the reduced scan
    private int trackScan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

    }

    // Helper function to check if there's a bomb already there
    public boolean checkBomb(int row, int col){
        for(int i = 0; i < rowArray.size(); i++){
            // If we find the star return true
            if(row == rowArray.get(i) && col == colArray.get(i)){
                return false;
            }
        }
        return true;
    }
    // Random star getter
    public void setRandomStar(int m, int my_Rows, int my_Col){
        // Have the random part
        Random controlStar = new Random();
        int mines = m;
        int row = my_Rows;
        int col = my_Col;
        // While the mines are bigger than 0
        while(mines > 0){
            // Generate a random number for the row and column
            int r = controlStar.nextInt(row);
            int c = controlStar.nextInt(col);

            boolean check = checkBomb(r,c);
            // If there is no duplicate bomb, add it in that spot
            if(check == true){
                // Assign the numbers in the row and col array
                rowArray.add(r);
                colArray.add(c);
                boolArray.add(false);


                // Add to the bool array
                //boolArray.add(true);

                // Decrement mines
                mines--;
            }
        }

        for (int j = 0; j < boolArray.size(); j++){
            boolArray.set(j, false);
        }
    }

    // Checks to see if there's a star
    public boolean checkStar(int row, int col){
        for(int i = 0; i < rowArray.size(); i++){
            // If we find the star return true
            if(row == rowArray.get(i) && col == colArray.get(i)){
                boolArray.set(i, true);
                return true;
            }
        }
        // Else return false
        return false;
    }

    // Return the rowArray
    public List<Integer> getRowArray(){
        return rowArray;
    }

    // Return the colArray
    public List<Integer> getColArray(){
        return colArray;
    }

    // Scanning helper function (Get the row and col)
    public int helpScanner(int row, int col){
        score = 0;
        userColumn.add(col);
        userRow.add(row);
        // Loop through the row array and check to see if there is a star in the row or col
        for(int i = 0; i < rowArray.size(); i++){
            // Check each element in the row and column
            if((row == rowArray.get(i) || col == colArray.get(i)) && boolArray.get(i) == false){
                score++;
            }
        }
        return score;
    }

    // Re-scan everything (For each mine we found, the row and column of that mine
    // Subtracts by one)
    // Is only done when the user clicks on a non star button or the star twice
    public int rescan(int row, int col){
        for (int i = 0; i < userColumn.size(); i++ ){
            if (row == userRow.get(i) && col == userColumn.get(i)){
                int count = helpScanner(row, col);
                return count;
            }
        }
        return -1;
    }

    // Helper function







}
