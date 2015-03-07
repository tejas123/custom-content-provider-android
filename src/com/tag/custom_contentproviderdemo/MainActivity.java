package com.tag.custom_contentproviderdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tag.custom_contentproviderdemo.PlatesData.Plates;

public class MainActivity extends Activity implements OnClickListener {

	private final static String TAG = "CustomContentProvider";
	private EditText title, content, delete_id;
	private Button addPlate, updatePlate, deletePlate, showPlates;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// add Click Listners
		setWidgetReference();
		bindWidgetEvents();
		getPlatesDetails();
	}

	private void bindWidgetEvents() {
		addPlate.setOnClickListener(this);
		updatePlate.setOnClickListener(this);
		deletePlate.setOnClickListener(this);
		showPlates.setOnClickListener(this);
	}

	private void setWidgetReference() {
		title = (EditText) findViewById(R.id.title);
		content = (EditText) findViewById(R.id.content);
		delete_id = (EditText) findViewById(R.id.delete_id);
		addPlate = (Button) findViewById(R.id.button_add);
		updatePlate = (Button) findViewById(R.id.button_update);
		deletePlate = (Button) findViewById(R.id.button_delete);
		showPlates = (Button) findViewById(R.id.show_notes);
	}

	void getPlatesDetails() {

	}

	@Override
	public void onClick(View v) {
		if (v == addPlate) {
			// addPlate();
		}
		if (v == updatePlate) {
			// update note with Id
			// updatePlate(delete_id.getText().toString());
		}
		if (v == deletePlate) {
			// delete note with Id
			// deletePlate(delete_id.getText().toString());
		}
		if (v == showPlates) {
			// show all
			getPlatesDetails();
		}
	}

	// private void makeToast(String text) {
	// Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	// }
}