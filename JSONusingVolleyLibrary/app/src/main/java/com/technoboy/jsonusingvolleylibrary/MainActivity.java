package com.technoboy.jsonusingvolleylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button parse;
    TextView textView;
    RequestQueue result;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.show);
        parse=findViewById(R.id.button);
        result= Volley.newRequestQueue(this);

        parse.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jsonparse();
                    }
                }
        );
    }

    private void jsonparse() {
        String url="https://api.myjson.com/bins/v8v8g";
        final JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String name=jsonObject.getString("emp_name");
                        String age=jsonObject.getString("emp_age");
                        String dept=jsonObject.getString("emp_dept");
                        String sal=jsonObject.getString("emp_sal");
                        textView.append("Name : "+name+"\nAge : "+age+"\nDept : "+dept+"\nSal : "+sal+"\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        result.add(request);
    }
}
