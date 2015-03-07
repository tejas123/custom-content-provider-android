package com.tag.custom_contentproviderdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.tag.custom_contentproviderdemo.PlatesData.Plates;

public class AddPlate extends Activity implements OnClickListener {

	private EditText etAddTitle, etAddContent;
	private Button btnAdd, btnDelete;
	private String _ID, _TITLE, _CONTENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_plate);
		setWidgetReference();
		bindWidgetEvents();
	}

	private void setWidgetReference() {
		etAddTitle = (EditText) findViewById(R.id.etAddPlateTitle);
		etAddContent = (EditText) findViewById(R.id.etAddPlateContent);
		btnAdd = (Button) findViewById(R.id.btnAddPlateSubmit);
		btnDelete = (Button) findViewById(R.id.btnAddPlateDelete);
	}

	private void getDataFromBundle() {

	}

	private void bindWidgetEvents() {
		btnAdd.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
	}

	void updatePlate(String str_id) {
		try {
			int id = Integer.parseInt(str_id);
			ContentValues values = new ContentValues();
			values.put(Plates._TITLE, etAddTitle.getText().toString());
			values.put(Plates._CONTENT, etAddContent.getText().toString());
			getContentResolver().update(PlatesData.CONTENT_URI, values,
					PlatesData.Plates._ID + " = " + id, null);
			startActivity(new Intent(this, PlatesList.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValid() {
		if (etAddTitle.getText().toString().length() > 0) {
			if (etAddContent.getText().toString().length() > 0) {
				return true;
			} else {
				etAddContent.setError("Enter Content");
			}
		} else {
			etAddContent.setError("Enter Title");
		}
		return false;
	}

	void deletePlate(String str_id) {
		try {
			int id = Integer.parseInt(str_id);
			getContentResolver().delete(PlatesData.CONTENT_URI,
					PlatesData.Plates._ID + " = " + id, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addPlateToDB() {
		if (isValid()) {
			ContentValues values = new ContentValues();
			values.put(Plates._TITLE, etAddTitle.getText().toString());
			values.put(Plates._CONTENT, etAddContent.getText().toString());
			getContentResolver().insert(PlatesData.CONTENT_URI, values);
			startActivity(new Intent(this, PlatesList.class));
		}
	}

	@Override
	public void onClick(View v) {
		if (v == btnAdd) {
			addPlateToDB();
		} else if (v == btnDelete) {

		}
	}
}