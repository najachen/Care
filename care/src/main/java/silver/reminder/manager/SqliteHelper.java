package silver.reminder.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import silver.reminder.care.model.CareDrug;
import silver.reminder.care.model.CareMain;
import silver.reminder.care.model.CareMember;
import silver.reminder.care.model.CareTask;
import silver.reminder.care.model.CareTime;


public class SqliteHelper extends SQLiteOpenHelper {

    private static final String TAG = "careLog: " + SqliteHelper.class.getName();

    private static final String DATABASE_NAME = "care.db";
    private static final int DATABASE_VERSION = 5;

    public SqliteHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG,"SqliteHelper() ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate()" );
        sqLiteDatabase.execSQL(CareMain.CREATE_TABLE);
        Log.d(TAG,"onCreate() ");
        sqLiteDatabase.execSQL(CareTask.CREATE_TABLE);
        Log.d(TAG,"onCreate() ");
        sqLiteDatabase.execSQL(CareDrug.CREATE_TABLE);
        Log.d(TAG,"onCreate() ");
        sqLiteDatabase.execSQL(CareMember.CREATE_TABLE);
        Log.d(TAG,"onCreate() ");
        sqLiteDatabase.execSQL(CareTime.CREATE_TABLE);
        Log.d(TAG,"onCreate() ");
        //
        Log.d(TAG,"onCreate() ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpgrade() ");
        Log.d(TAG,"onUpgrade() ");
        sqLiteDatabase.execSQL(CareMain.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ");
        sqLiteDatabase.execSQL(CareTask.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ");
        sqLiteDatabase.execSQL(CareDrug.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ");
        sqLiteDatabase.execSQL(CareMember.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ");
        sqLiteDatabase.execSQL(CareTime.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ");
        onCreate(sqLiteDatabase);
    }
}
