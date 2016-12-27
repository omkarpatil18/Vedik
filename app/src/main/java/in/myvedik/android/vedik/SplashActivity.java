package in.myvedik.android.vedik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import static in.myvedik.android.vedik.ParsingConstants.TAG_NAME;


/**
 * Created by admin on 25-12-2016.
 */

public class SplashActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> mPostData;
    private JSONArray jsonArray;
    private static final String url="http://www.myvedik.in/api/posts/uploads";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        jsonArray=response;
                        ParseJSON parseJSON= new ParseJSON();
                        mPostData= parseJSON.getPostData(response);

                        Intent intent = new Intent(SplashActivity.this, UserPostActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);

    }

    public JSONArray getJsonArray(){

        return jsonArray;
    }

    public ArrayList<HashMap<String, String>> getPostData(){

        return mPostData;
    }



}