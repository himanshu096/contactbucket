package ga.himanshu.home.contactbucket;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
ArrayList<String> items;    ListView listview;
    int i=0;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DataBaseHelper dbHelper=new DataBaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        items = new ArrayList<String>();
        items.add("screen");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);




        String[] columns = {"name"};
        Cursor cursor = db.query(DataBaseHelper.CONTACT_TABLE, columns, null, null, null, null, null);

        int nameIndex = cursor.getColumnIndex("name");
      //  int emailIndex = cursor.getColumnIndex("email");

        while (cursor.moveToNext()) {
            Log.d("codekamp", "name: " + cursor.getString(nameIndex));
            items.add(cursor.getString(nameIndex));
            adapter.notifyDataSetChanged();
            i++;
        }
    }
}
