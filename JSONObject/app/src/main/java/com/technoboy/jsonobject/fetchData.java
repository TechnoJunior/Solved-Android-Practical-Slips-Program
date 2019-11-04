package com.technoboy.jsonobject;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String data="",singleline,alldata;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://api.myjson.com/bins/v8v8g");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line="";
            while(line!=null){
                line=br.readLine();
                data=data+line;
            }

            JSONArray jsonArray=new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                singleline=jsonObject.getString("emp_name")+" --> "+jsonObject.getString("emp_age")+" --> "
                        +jsonObject.getString("emp_dept")+" --> "+jsonObject.getString("emp_sal")+"\n";
                alldata=alldata+singleline;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.show.setText(alldata);
    }
}
