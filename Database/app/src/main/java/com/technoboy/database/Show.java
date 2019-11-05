package com.technoboy.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

    databaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ListView listView=findViewById(R.id.listview);
        databaseHelper=new databaseHelper(this);

        ArrayList<String> arrayList=new ArrayList<>();
        Cursor data=databaseHelper.getData();

        if(data.getCount()==0){
            Toast.makeText(this, "Empty Database", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                arrayList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
