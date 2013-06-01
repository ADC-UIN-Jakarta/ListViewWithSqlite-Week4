package com.example.app3;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ItemDataSource {

	private SQLiteDatabase db;
	private SqliteHelper dbHelper;

	private static String[] allColoumns = { SqliteHelper.SQLITE_TABLE_ITEM_COL_ID,
			SqliteHelper.SQLITE_TABLE_ITEM_COL_NAME };

	public ItemDataSource(Context context) {
		dbHelper = new SqliteHelper(context);
	}
	
	/**
	 * Mendapatkan akses ke database untuk melakukan query
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	/**
	 * Tutup akses ke database, selalu panggil method ini setelah melakukan
	 * query
	 */
	public void close() {
		if (db.isOpen()) {
			db.close();
		}
	}

	/**
	 * Query untuk semua row yang ada di table items
	 * 
	 * @return array list yang berisi object Item
	 */
	public ArrayList<Item> getAllItems() {

		ArrayList<Item> itemList = new ArrayList<Item>();
		Item item = new Item();
		Cursor cursor = db.query(SqliteHelper.SQLITE_TABLE_ITEM, allColoumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			// convert ke array list
			item.setId(cursor.getLong(0));
			item.setName(cursor.getString(1));
			itemList.add(item);
			item = new Item();
			cursor.moveToNext();
		}

		return itemList;
	}

	/**
	 * Query untuk insert row baru ke table items
	 * 
	 * @param item
	 *            object Item sebagai representasi row yang akan di query
	 */
	public void insertRow(Item item) {
		ContentValues values = new ContentValues();
		values.put(SqliteHelper.SQLITE_TABLE_ITEM_COL_NAME, item.getName());

		db.insert(SqliteHelper.SQLITE_TABLE_ITEM, null, values);
	}

}
