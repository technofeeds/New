package com.example.test.activity.sqlite.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test.sqlite.StudentTable;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + StudentTable.TABLE_NAME + " ("
				+ StudentTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"

				+ ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
