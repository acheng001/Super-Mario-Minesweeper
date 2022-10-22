package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ca.cmpt276.cmpt276assignmentthree.model.Opt;

public class Options extends AppCompatActivity {

    public Opt options = Opt.getInstance();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.options);

        createSizeRadioButtons();
        createMinesRadioButtons();


        onSaveButton();
    }

    private void onSaveButton() {
        Button button = (Button) findViewById(R.id.save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this, Menu.class);

                Toast.makeText(Options.this, "Saving Options...", Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });


    }

    private void createMinesRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.num_of_mines_radio);

        int[] mines = getResources().getIntArray(R.array.num_of_mines);

        for (int i = 0; i < mines.length; i++){
            int num_mine = mines[i];

            RadioButton button = new RadioButton(this);
            button.setText(num_mine + " mines");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    options.setMine(num_mine);

                    saveNumMines(num_mine);
                }


            });

            group.addView(button);

            if(getmines(this) == num_mine){
                button.setChecked(true);
            }
        }
    }

    private void createSizeRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.board_size_radio);

        int[] sizes = getResources().getIntArray(R.array.board_size);

        for (int i = 0; i < sizes.length; i+=2){
            int column = sizes[i+1];
            int row = sizes[i];

            RadioButton button = new RadioButton(this);
            button.setText(row + " rows by " + column + " columns");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    options.setColumns(column);
                    options.setRows(row);

                    saveColumnNum(column);
                    saveRowNum(row);
                }
            });

            group.addView(button);

            if(getrow(this) == row){
                button.setChecked(true);
            }

        }

    }

    public static Intent makeOptionsIntent(Context context){

        Intent intent = new Intent(context, Options.class);

        return intent;
    }

    private void saveNumMines(int num_mines){
        SharedPreferences pref = this.getSharedPreferences("minepref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("nummines", num_mines);
        edit.apply();
    }

    private void saveRowNum(int row){
        SharedPreferences pref = this.getSharedPreferences("rowpref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("numrows", row);
        edit.apply();
    }

    private void saveColumnNum(int column){
        SharedPreferences pref = this.getSharedPreferences("columnpref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("numcolumns", column);
        edit.apply();
    }

    static public int getmines(Context context){
        SharedPreferences pref = context.getSharedPreferences("minepref", MODE_PRIVATE);
        return pref.getInt("nummines", 6);
    }

    static public int getcolumn(Context context){
        SharedPreferences pref = context.getSharedPreferences("columnpref", MODE_PRIVATE);
        return pref.getInt("numcolumns", 6);
    }

    static public int getrow(Context context){
        SharedPreferences pref = context.getSharedPreferences("rowpref", MODE_PRIVATE);
        return pref.getInt("numrows", 4);
    }
}
