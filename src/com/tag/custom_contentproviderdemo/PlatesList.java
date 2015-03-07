package com.tag.custom_contentproviderdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.plurals;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.tag.custom_contentproviderdemo.PlatesData.Plates;

public class PlatesList extends Activity implements OnClickListener {

	private ListView lvPlates;
	private Button btnAdd;
	private boolean isUpdate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plates_list);
		setWidgetReference();
		bindWidgetEvents();
	}

	private void setWidgetReference() {
		lvPlates = (ListView) findViewById(R.id.lvPlatesList);
		btnAdd = (Button) findViewById(R.id.btnPlateListAddPlate);
	}

	private void bindWidgetEvents() {
		lvPlates.setAdapter(new PlatesAdapter(getApplicationContext(),
				getPlates()));
		btnAdd.setOnClickListener(this);

		lvPlates.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(PlatesList.this, AddPlate.class);
				intent.putExtra(Constants.TAG_MAP, getPlates().get(position));
				startActivity(intent);
			}
		});
	}

	private void getIntentData() {
		if (getIntent().getSerializableExtra(Constants.TAG_MAP) != null) {
			isUpdate = true;
			btnAdd.setVisibility(View.VISIBLE);

		}
	}

	private ArrayList<HashMap<String, String>> getPlates() {
		ArrayList<HashMap<String, String>> plates = new ArrayList<HashMap<String, String>>();
		Cursor cur = getContentResolver().query(PlatesData.CONTENT_URI, null,
				null, null, null);
		if (cur.getCount() > 0) {
			while (cur.moveToNext()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Constants.TAG_TITLE,
						cur.getString(cur.getColumnIndex(Plates._TITLE)));
				map.put(Constants.TAG_ID,
						cur.getString(cur.getColumnIndex(Plates._ID)));
				map.put(Constants.TAG_CONTENT,
						cur.getString(cur.getColumnIndex(Plates._CONTENT)));
				plates.add(map);
			}
			return plates;
		} else {
			return plates;
		}
	}

	@Override
	public void onClick(View v) {
		if (v == btnAdd) {
			startActivity(new Intent(this, AddPlate.class));
		}
	}
}