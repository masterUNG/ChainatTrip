package appewtc.masterung.chainattrip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 12/2/15 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "Chainat.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CHAINAT_TABLE = "create table chainatTABLE (_id integer primary key, " +
            "Category text, " +
            "Title text, " +
            "ShortDetail text, " +
            "URLimage1 text, " +
            "URLimage2 text, " +
            "URLimage3 text, " +
            "LongDetail text, " +
            "Lat text, " +
            "Lng text);";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CHAINAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
