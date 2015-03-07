package com.tag.custom_contentproviderdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PlatesAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private ArrayList<HashMap<String, String>> plates;

	public PlatesAdapter(Context context,
			ArrayList<HashMap<String, String>> plates) {
		this.plates = plates;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return plates.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		Holder holder;
		if (v == null) {
			v = inflater.inflate(R.layout.list_item, null);
			holder = new Holder();
			holder.tvTitle = (TextView) v.findViewById(R.id.tvItemPlate);
			holder.tvContent = (TextView) v.findViewById(R.id.tvItemContent);
			v.setTag(holder);
		} else {
			holder = (Holder) v.getTag();
		}

		holder.tvTitle.setText(plates.get(position).get(Constants.TAG_TITLE));
		holder.tvContent.setText(plates.get(position)
				.get(Constants.TAG_CONTENT));
		return v;
	}

	class Holder {
		TextView tvTitle, tvContent;
	}
}