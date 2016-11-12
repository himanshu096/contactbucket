package ga.himanshu.home.contactbucket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Himanshu on 3/7/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    public static final String DATABASE_NAME = "Bucket";
    public static final String CONTACT_TABLE = "contact";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //code to create the data schema
        Log.d("codekamp", "on create database helper");
        db.execSQL("CREATE TABLE  " + CONTACT_TABLE + "(_id INT PRIMARY KEY , name VARCHAR(255) NOT NULL, email VARCHAR(255), contact int);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("codekamp", "on update database helper");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        Log.d("codekamp", "on downgrade database helper");
    }
}
