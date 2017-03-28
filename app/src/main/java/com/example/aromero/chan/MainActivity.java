package com.example.aromero.chan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://a.4cdn.org/boards.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject json = new JSONObject(response);
                            Log.d("RESPONSE", response);
                            JSONArray array = json.getJSONArray("boards");
                            for(int i = 0; i < array.length(); i++)
                            {
                                JSONObject j = array.getJSONObject(i);
                                Log.d("Board", j.get("board").toString());
                            }
                        }
                        catch (Exception e)
                        {
                            Log.d("ERROR", e.toString());
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("ERROR", error.toString());
                    }
                });
        queue.add(stringRequest);
    }
}
