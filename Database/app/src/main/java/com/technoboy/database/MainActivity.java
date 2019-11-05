package com.technoboy.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert,show,update,delete;
    EditText name,house,id;
    databaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper=new databaseHelper(this);

        insert=findViewById(R.id.btnInsert);
        show=findViewById(R.id.btnShow);
        update=findViewById(R.id.btnUpdate);
        delete=findViewById(R.id.btnDelete);
        name=findViewById(R.id.gotname);
        house=findViewById(R.id.gothouse);
        id=findViewById(R.id.gotid);

        insert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=databaseHelper.insertData(name.getText().toString(),house.getText().toString());
                        if(result){
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Unable to Insert Data", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        show.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor data=databaseHelper.getData();
                        if(data.getCount()==0){
                            Toast.makeText(MainActivity.this, "Empty Database", Toast.LENGTH_SHORT).show();
                        }
                        StringBuffer stringBuffer=new StringBuffer();
                        while(data.moveToNext()){
                            stringBuffer.append("Id : "+data.getString(0)+"\nName : "+data.getString(1)
                            +"\nHouse : "+data.getString(2)+"\n\n");
                        }
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Data");
                        builder.setMessage(stringBuffer);
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
//                        Intent intent=new Intent(MainActivity.this,Show.class);
//                        startActivity(intent);
                    }
                }
        );

        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (id.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Id cannot be blank", Toast.LENGTH_SHORT).show();
                        }
                        else if(name.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
                        }
                        else if(house.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "House cannot be blank", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            boolean update=databaseHelper.updateData(id.getText().toString(),name.getText().toString(),house.getText().toString());
                            if(update){
                                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Unable to Update", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );

        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (id.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Id cannot be blank", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            boolean b = databaseHelper.deleteData(id.getText().toString());
                            if (b) {
                                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
    }
}
