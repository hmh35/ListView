package com.example.hmh.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<Map<String,Object>>();
        listView=(ListView) findViewById(R.id.mylist);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.listview,new String[]{"text", "image"},
                new int[]{R.id.text,R.id.image});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }

    private List<Map<String,Object>> getData(){
        list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("text", "Lion");
        map.put("image", R.drawable.lion);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("text", "Tiger");
        map2.put("image", R.drawable.tiger);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("text", "Monkey");
        map3.put("image", R.drawable.monkey);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("text", "Dog");
        map4.put("image", R.drawable.dog);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("text", "cat");
        map5.put("image", R.drawable.cat);
        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("text", "Elephant");
        map6.put("image", R.drawable.elephant);
        list.add(map);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        Log.i("Main", list.size() + "");
        return list;//
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String text=(String) list.get(position).get("text");
        listView.setSelector(R.color.colorPrimary);
        Toast.makeText(MainActivity.this, text, 0).show();
    }
}
