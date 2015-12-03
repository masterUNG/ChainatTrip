package appewtc.masterung.chainattrip;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView hotelImageView, restaurantImageView, souvenirImageView, travelImageView;
    private ManageTABLE objManageTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Connected Database
        objManageTABLE = new ManageTABLE(this);

        //Image Controller
        imageController();

        //Test Add Value
        //testAddValue();

        //Synchronize JSON to SQLite
        synchronizeJSONtoSQLite();



    }   // Main Method

    private void synchronizeJSONtoSQLite() {

        //Delete All Data
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("Chainat.db", MODE_PRIVATE, null);
        objSqLiteDatabase.delete("chainatTABLE", null, null);

        //Setup New Policy
        StrictMode.ThreadPolicy newThreadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(newThreadPolicy);

        //1. Create InputStream
        InputStream objInputStream = null;
        String strJSON = null;

        try {

            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost("http://swiftcodingthai.com/au/php_get_data_au.php");
            HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
            HttpEntity objHttpEntity = objHttpResponse.getEntity();
            objInputStream = objHttpEntity.getContent();

        } catch (Exception e) {
            Log.d("Chainat", "InputStream ==> " + e.toString());
        }

        //2. Create JSON String
        try {

            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
            StringBuilder objStringBuilder = new StringBuilder();
            String strLine = null;

            while ((strLine = objBufferedReader.readLine()) != null ) {
                objStringBuilder.append(strLine);
            }

            objInputStream.close();
            strJSON = objStringBuilder.toString();

        } catch (Exception e) {
            Log.d("Chainat", "JSON String ==> " + e.toString());
        }

        //3. Update to SQLite
        try {

            JSONArray objJsonArray = new JSONArray(strJSON);
            for (int i=0;i<objJsonArray.length();i++) {

                JSONObject object = objJsonArray.getJSONObject(i);

                String strCategory = object.getString("Category");
                String strTitle = object.getString("Title");
                String strShortDetail = object.getString("ShortDetail");
                String strURLimage1 = object.getString("URLimage1");
                String strURLimage2 = object.getString("URLimage2");
                String strURLimage3 = object.getString("URLimage3");
                String strLongDetail = object.getString("LongDetail");
                String strLat = object.getString("Lat");
                String strLng = object.getString("Lng");

                objManageTABLE.addValueToSQLite(strCategory, strTitle, strShortDetail,
                        strURLimage1, strURLimage2, strURLimage3, strLongDetail,
                        strLat, strLng);

            }

        } catch (Exception e) {
            Log.d("Chainat", "Update ==> " + e.toString());
        }

    }   // synchronizeJSONtoSQLite

    private void testAddValue() {

        objManageTABLE.addValueToSQLite("Category",
                "Title",
                "ShortDetail",
                "URLimage1",
                "URLimage2",
                "URLimage3",
                "LongDetail",
                "Lat",
                "Lng");

    }

    private void imageController() {

        hotelImageView.setOnClickListener(this);
        restaurantImageView.setOnClickListener(this);
        souvenirImageView.setOnClickListener(this);
        travelImageView.setOnClickListener(this);

    }

    private void bindWidget() {

        hotelImageView = (ImageView) findViewById(R.id.imageView);
        restaurantImageView = (ImageView) findViewById(R.id.imageView2);
        souvenirImageView = (ImageView) findViewById(R.id.imageView3);
        travelImageView = (ImageView) findViewById(R.id.imageView4);

    }

    @Override
    public void onClick(View view) {


        //Intent To ChainatListView
        Intent objIntent = new Intent(MainActivity.this, ChainatListView.class);
        startActivity(objIntent);

    }   // onClick

}   // Main Class
