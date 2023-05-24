package com.example.myapplication3;

import android.content.Context;
import android.os.StrictMode;

import com.android.volley.AuthFailureError;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FCMSend {


    private static String BASE_URL = "https://fcm.googleapis.com/fcm/send";
    private static String SERVER_KEY = "Key=AAAADu__eQQ:APA91bGJr13Et_wF2PcYmTYyEpl_vyh4ojxKRbqDzRtAMAuSeUe7tazHrwxxEbhsPLdgoOCYhvNrHbnFlYJw10mQrh3FsMktaPX5lZznotbtvMzCPupVZUiTpguA1ZgP4nyZQpKTIS3a";

    public static void pushNotification(Context context, String token, String title, String message){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RequestQueue queue = Volley.newRequestQueue(context);

        try {
            JSONObject json = new JSONObject();
            json.put("to", token);
            JSONObject notification = new JSONObject();
            notification.put("title", title);
            notification.put("body", message);
            json.put("notification", notification);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    System.out.println("FCM" + response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", SERVER_KEY);
                return params;
            }
        };
            queue.add(jsonObjectRequest);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
}