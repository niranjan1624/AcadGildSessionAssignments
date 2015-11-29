package in.acadgild.niranjan.com.acadgildsessions.Session6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.acadgild.niranjan.com.acadgildsessions.R;

public class Assignment4 extends AppCompatActivity {
    private ListView contactsListView;
    List<Map<String, String>> contactList = new ArrayList<Map<String, String>>();
    String[] contactNames = {"Anil", "Akhil", "Balu", "Srujana", "Likhita"};
    String[] numbers = {"9700618710","9154866461","9676067709", "9440616946","7898789878"};
    private final int ACTION_CALL = 0, ACTION_MESSAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment4);
        contactsListView = (ListView) findViewById(R.id.contacts_list);
        for(int i = 0; i < contactNames.length;i++) {
            Map<String, String> temp = new HashMap<String,String>(2);
            temp.put("name", contactNames[i]);
            temp.put("number", numbers[i]);
            contactList.add(temp);
        }
        SimpleAdapter mAdapter = new SimpleAdapter(this,contactList,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "number"}, new int[] {android.R.id.text1,
                android.R.id.text2});
        contactsListView.setAdapter(mAdapter);
        registerForContextMenu(contactsListView);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.contacts_list) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Map<String, String> obj = (Map<String, String>) lv.getItemAtPosition(acmi.position);
            menu.setHeaderTitle(R.string.action_title);

            menu.add(Menu.NONE, ACTION_CALL, Menu.NONE, "Call");
            menu.add(Menu.NONE, ACTION_MESSAGE, Menu.NONE, "Send Message");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.d("DEBUG",numbers[info.position]+"  "+info.position);
        switch (item.getItemId()) {
            case ACTION_CALL:
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + numbers[info.position]));
                startActivity(intent);
                return true;
            case ACTION_MESSAGE:
                Uri uri = Uri.parse("smsto:" + numbers[info.position]);
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assignment4, menu);
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
