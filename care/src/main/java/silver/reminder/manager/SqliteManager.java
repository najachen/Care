package silver.reminder.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteManager {

    private static final String TAG = "careLog: " + SqliteManager.class.getName();

    private Integer openCounter = 0;
    private static SqliteManager instance;
    private static SQLiteOpenHelper sqlhelper;
    private SQLiteDatabase database;

    public static synchronized SqliteManager getInstance(Context c) {
        if (instance == null) {
            instance = new SqliteManager();
            sqlhelper = new SqliteHelper(c);
            Log.d(TAG,"getInstance() ");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase() {
        openCounter++;
        if(openCounter == 1) {
            database = sqlhelper.getWritableDatabase();
            Log.d(TAG,"openDatabase() ");
        }
        return database;
    }

    public synchronized void closeDatabase() {
        openCounter--;
        if(openCounter == 0) {
            database.close();
            Log.d(TAG,"closeDatabase() ");
        }
    }
}
