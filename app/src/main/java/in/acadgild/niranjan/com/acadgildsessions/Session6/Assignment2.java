package in.acadgild.niranjan.com.acadgildsessions.Session6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import in.acadgild.niranjan.com.acadgildsessions.R;

// Assignment 2 & 3 Done

public class Assignment2 extends AppCompatActivity {

    TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        helloTextView = (TextView) findViewById(R.id.hello_text);

        (findViewById(R.id.open_assignment_4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Assignment2.this, Assignment4.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assignment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.text_color:
                return true;
            case R.id.red:
                helloTextView.setTextColor(getResources().getColor(R.color.red));
                return true;
            case R.id.blue:
                helloTextView.setTextColor(getResources().getColor(R.color.blue));
                return true;
            case R.id.green:
                helloTextView.setTextColor(getResources().getColor(R.color.green));
        }
        return super.onOptionsItemSelected(item);
    }
}
