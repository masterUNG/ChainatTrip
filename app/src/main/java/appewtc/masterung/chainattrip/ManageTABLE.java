package appewtc.masterung.chainattrip;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 12/2/15 AD.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String CHAINAT_TABLE = "chainatTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_SHORT_DETAIL = "ShortDetail";
    public static final String COLUMN_URL_IMAGE1 = "URLimage1";
    public static final String COLUMN_URL_IMAGE2 = "URLimage2";
    public static final String COLUMN_URL_IMAGE3 = "URlimage3";
    public static final String COLUMN_LONG_DETAIL = "LongDetail";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";


    public ManageTABLE(Context context) {

        //Create & Connected
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    //Add Value to chainatTABLE
    public long addValueToSQLite(String strCategory,
                                 String strTitle,
                                 String strShortDetail,
                                 String strURLimage1,
                                 String strURLimage2,
                                 String strURLimage3,
                                 String strLongDetail,
                                 String strLat,
                                 String strLng) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CATEGORY, strCategory);
        objContentValues.put(COLUMN_TITLE, strTitle);
        objContentValues.put(COLUMN_SHORT_DETAIL, strShortDetail);
        objContentValues.put(COLUMN_URL_IMAGE1, strURLimage1);
        objContentValues.put(COLUMN_URL_IMAGE2, strURLimage2);
        objContentValues.put(COLUMN_URL_IMAGE3, strURLimage3);
        objContentValues.put(COLUMN_LONG_DETAIL, strLongDetail);
        objContentValues.put(COLUMN_LAT, strLat);
        objContentValues.put(COLUMN_LNG, strLng);

        return writeSqLiteDatabase.insert(CHAINAT_TABLE, null, objContentValues);
    }


}   // Main Class
