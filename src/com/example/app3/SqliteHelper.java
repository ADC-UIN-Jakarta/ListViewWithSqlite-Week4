package com.example.app3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

	private static final String SQLITE_DATABASE = "ADCWeek4.db";

	public static final String SQLITE_TABLE_ITEM = "items";
	public static final String SQLITE_TABLE_ITEM_COL_ID = "_id";
	public static final String SQLITE_TABLE_ITEM_COL_NAME = "name";

	private static final String CREATE_TABLE_ITEM = String.format(
			"create table %s (%s integer not null primary key autoincrement, %s text);", SQLITE_TABLE_ITEM,
			SQLITE_TABLE_ITEM_COL_ID, SQLITE_TABLE_ITEM_COL_NAME);

	public SqliteHelper(Context context) {
		super(context, SQLITE_DATABASE, null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_ITEM);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
