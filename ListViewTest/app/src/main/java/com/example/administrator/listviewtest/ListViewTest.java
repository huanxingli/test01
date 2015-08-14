package com.example.administrator.listviewtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListViewTest extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

    public BaseAdapter adapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return DataInput.data.length;
        }

        @Override
        public ListData getItem(int position) {
            return DataInput.data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RelativeLayout ll = null;
            if (convertView!=null){
                ll = (RelativeLayout) convertView;
            }else{
                ll = (RelativeLayout) LayoutInflater.from(ListViewTest.this)
                        .inflate(R.layout.list_cell_layout, null);
            }

            ListData data = getItem(position);
            ImageView icon = (ImageView) ll.findViewById(R.id.image);
            TextView name = (TextView) ll.findViewById(R.id.tvname);

            icon.setImageResource(data.getImageId());
            name.setText(data.getName());
            return ll;
        }
    };


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
