package com.example.app3;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Halaman2 extends Activity {
	ListView listview;
	String data;
	ArrayList<String> dataAray;
	ArrayAdapter<Item> arrayadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.halaman2);
		// populate view
		listview = (ListView) findViewById(R.id.listView1);

		// background task untuk query semua row ke sqlite 
		new GetAllRowTask().execute();

	}

	class GetAllRowTask extends AsyncTask<Void, Void, ArrayList<Item>> {

		@Override
		protected ArrayList<Item> doInBackground(Void... params) {

			ItemDataSource ids = new ItemDataSource(getApplicationContext());
			ids.open();
			ArrayList<Item> itemList = ids.getAllItems();
			ids.close();

			return itemList;
		}

		@Override
		protected void onPostExecute(ArrayList<Item> result) {

			// set data ke sqlite, tetep pake ArrayAdapter nggak jadi custom
			// adapter
			ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(getApplicationContext(),
					R.layout.mytextview, result);
			listview.setAdapter(adapter);
		}

	}

}
