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


    // Create an int score that keeps track
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

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

            // Assign the numbers in the row and col array
            rowArray.add(r);
            colArray.add(c);

            // Decrement mines
            mines--;
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
    }

    // Checks to see if there's a star
    public boolean checkStar(int row, int col){
        for(int i = 0; i < rowArray.size(); i++){
            // If we find the star return true
            if(row == rowArray.get(i) && col == colArray.get(i)){
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
        // Loop through the row
        for(int i = 0; i < rowArray.size(); i++){
            if(row == rowArray.get(i)){
                score++;
            }
        }
        // Loop through the col
        for(int i = 0; i < colArray.size(); i++){
            if(col == colArray.get(i)){
                score++;
            }
        }
        return score;
    }






}
