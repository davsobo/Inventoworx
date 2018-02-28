package com.orpheus.rebuffer;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IT-PC2 on 27/02/2018.
 */

public class UserData {
    private static String mEmail;
    private static String mLevel;

    public static Map<String, String> mapMerk = new HashMap<String, String>();
    private static Map<String, String> mapTipe = new HashMap<String, String>();
    private static Map<String, String> mapUkuran = new HashMap<String, String>();
    private static Map<String, String> mapBahan = new HashMap<String, String>();
    private static Map<String, String> mapJumlah = new HashMap<String, String>();
    private static Map<String, String> mapLokasi = new HashMap<String, String>();

    public static Map<String, Map<String, String>> mapInventory = new HashMap<String, Map<String, String>>();


    public static void setmEmail(String x) {
        mEmail = x;
    }

    public static String getmEmail() {
        return mEmail;
    }

    public static void setmLevel(String x) {
        mLevel = x;
    }

    public static String getmLevel() {
        return mLevel;
    }

    public static void fetchDataInventory(Context context) {
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DBConnection.INVENTORY_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        Log.d("Json Response: Inventory", response);
                        //If we are getting success from server
                        if (response.length() > 10) {
                            try {
                                JSONArray mInventory = new JSONArray(response);
                                Log.d("Json Response: Inventory", "INVENTORY FETCH SUCCESS");
                                for (int i = 0; i < mInventory.length(); i++) {
                                    mapMerk.put(mInventory.getJSONObject(i).getString("merk"), mInventory.getJSONObject(i).getString("merk"));
                                    mapTipe.put(mInventory.getJSONObject(i).getString("tipe"), mInventory.getJSONObject(i).getString("tipe"));
                                    mapUkuran.put(mInventory.getJSONObject(i).getString("ukuran"), mInventory.getJSONObject(i).getString("ukuran"));
                                    mapBahan.put(mInventory.getJSONObject(i).getString("bahan"), mInventory.getJSONObject(i).getString("bahan"));
                                    mapJumlah.put(mInventory.getJSONObject(i).getString("jumlah"), mInventory.getJSONObject(i).getString("jumlah"));
                                    mapLokasi.put(mInventory.getJSONObject(i).getString("lokasi"), mInventory.getJSONObject(i).getString("lokasi"));
                                }
                                mapInventory.put("merk", mapMerk);
                                mapInventory.put("tipe", mapTipe);
                                mapInventory.put("ukuran", mapUkuran);
                                mapInventory.put("bahan", mapBahan);
                                mapInventory.put("jumlah", mapJumlah);
                                mapInventory.put("lokasi", mapLokasi);

//                                Log.d("Json Response: Inventory", "Email: " + mUserData.getJSONObject(0).getString("email"));
                                /*for (Map.Entry<String,String> temp : mInventory.EntrySet()) {
                                    
                                }*/

                            } catch (JSONException e) {
                                Log.d("Json ERROR", "Content: " + e.toString() + " -- Message: " + e.getMessage());
                                //Toast.makeText(getApplicationContext(), "JSON ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }

                            //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();

                        } else {
                            //Displaying an error message on toast
                            //Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                            Log.d("Json ERROR", "Login Failed");

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "The server unreachable: "+error, Toast.LENGTH_LONG).show();
                        Log.d("Json Error", error.getMessage() + " -- " + error.toString());

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put("function", "VIEW_ALL");
//                params.put("password", password);

                //returning parameter
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Cookie", "__test=e833043ed0ff06493dd5189f7e598644; expires=Thu, 31-Dec-37 23:55:55 GMT; path=/");
                return params;
            }
        };

        Volley.newRequestQueue(context).add(stringRequest);
    }

}
