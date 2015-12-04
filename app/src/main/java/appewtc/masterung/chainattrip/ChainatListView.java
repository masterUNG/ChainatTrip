package appewtc.masterung.chainattrip;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ChainatListView extends AppCompatActivity {

    //Explicit
    private String[] titleStrings, shortDetailStrings,
            URLimege1Strings, URLimage2Strings, URLimage3Strings,
            LongDetailStrings, LatStrings, LngStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chainat_list_view);

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        //Read SQLite Form Where Hotel, Restaurant, ...
        String strCategory = getIntent().getStringExtra("Category");

        //Read All Data
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("Chainat.db", MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM chainatTABLE WHERE Category = " + "'" + strCategory + "'", null);

        objCursor.moveToFirst();
        int intCursor = objCursor.getCount();
        titleStrings = new String[intCursor];
        shortDetailStrings = new String[intCursor];
        URLimege1Strings = new String[intCursor];
        URLimage2Strings = new String[intCursor];
        URLimage3Strings = new String[intCursor];
        LongDetailStrings = new String[intCursor];
        LatStrings = new String[intCursor];
        LngStrings = new String[intCursor];

        for (int i=0;i<intCursor;i++) {

            titleStrings[i] = objCursor.getString(objCursor.getColumnIndex("Title"));
            shortDetailStrings[i] = objCursor.getString(objCursor.getColumnIndex("ShortDetail"));
            URLimege1Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage1"));
            URLimage2Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage2"));
            URLimage3Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage3"));
            LongDetailStrings[i] = objCursor.getString(objCursor.getColumnIndex("LongDetail"));
            LatStrings[i] = objCursor.getString(objCursor.getColumnIndex("Lat"));
            LngStrings[i] = objCursor.getString(objCursor.getColumnIndex("Lng"));

            objCursor.moveToNext();

        }   // for

        objCursor.close();

        MyAdapter objMyAdapter = new MyAdapter(ChainatListView.this, titleStrings, shortDetailStrings, URLimege1Strings);
        ListView objListView = (ListView) findViewById(R.id.listView);
        objListView.setAdapter(objMyAdapter);

    }   // createListView

}   // Main Class
