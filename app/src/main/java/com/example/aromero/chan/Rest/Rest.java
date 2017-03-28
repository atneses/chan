package com.example.aromero.chan.Rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aromero.chan.interfaces.IVolleyCallback;


public class Rest
{
    private RequestQueue queue;
    Rest(Context context)
    {
        queue = Volley.newRequestQueue(context);
    }

    public void get(String url, final IVolleyCallback callback)
    {
        StringRequest request = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("RESPONSE", response);
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

        queue.add(request);
    }
}
