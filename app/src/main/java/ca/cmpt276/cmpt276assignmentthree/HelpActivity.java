package ca.cmpt276.cmpt276assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);


        //https://www.geeksforgeeks.org/how-to-add-hyperlink-to-textview-in-android/
        TextView star = (TextView) findViewById(R.id.marioStar);
        star.setMovementMethod(LinkMovementMethod.getInstance());
        star.setLinkTextColor(Color.YELLOW);
        TextView course_site = (TextView) findViewById(R.id.courseSite);
        course_site.setMovementMethod(LinkMovementMethod.getInstance());
        course_site.setLinkTextColor(Color.YELLOW);
        TextView back1 = (TextView) findViewById(R.id.background);
        back1.setMovementMethod(LinkMovementMethod.getInstance());
        back1.setLinkTextColor(Color.YELLOW);
        TextView back2 = (TextView) findViewById(R.id.background2);
        back2.setMovementMethod(LinkMovementMethod.getInstance());
        back2.setLinkTextColor(Color.YELLOW);
    }

    public static Intent makeHelpIntent(Context context){
        Intent intent = new Intent(context, HelpActivity.class);

        return intent;
    }
}
