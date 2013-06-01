package com.example.app3;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Halaman1 extends Activity {
	Button button;
	EditText edittext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.halaman1);
		
		//populating view
		button = (Button) findViewById(R.id.button1);
		edittext = (EditText) findViewById(R.id.editText1);

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				// ketika tombol button di click, ambil datanya dari textview
				String data;
				data = edittext.getText().toString();

				// melakukan background task untuk query data ke sqlite
				new InsertNewRowTask().execute(data);
			}
		});
	}

	class InsertNewRowTask extends AsyncTask<String, Void, Void> {

		@Override
		protected Void doInBackground(String... params) {

			//background task jalan
			
			ItemDataSource ids = new ItemDataSource(getApplicationContext());
			ids.open();
			Item item = new Item();
			item.setName(params[0]);
			ids.insertRow(item); //query insert row ke sqlite
			ids.close();

			return null;
			
			//background task selesai
		}

		@Override
		protected void onPostExecute(Void result) {
			
			//launch activity berikutnya
			Intent i = new Intent(Halaman1.this, Halaman2.class);
			startActivity(i);
		}

	}

}
