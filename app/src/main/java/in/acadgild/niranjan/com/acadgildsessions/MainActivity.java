package in.acadgild.niranjan.com.acadgildsessions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] sessionsList = {"Session 6","Session 7","Session 8","Session 9","Session 10","Session 11","Session 12",
            "Session 13","Session 14","Session 15","Session 16","Session 17","Session 18","Session 19","Session 20"};
    private ListView sessionsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionsListView = (ListView) findViewById(R.id.sessions_list);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sessionsList);
        sessionsListView.setAdapter(myAdapter);
       sessionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = null;
               switch (position) {
                   case 0:
                       intent = new Intent(MainActivity.this, in.acadgild.niranjan.com.acadgildsessions.Session6.Assignment2.class);
                       break;
                   default:
                       Toast.makeText(MainActivity.this, "not yet Started!" , Toast.LENGTH_LONG).show();
               }

               if(intent != null)
                   startActivity(intent);
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
