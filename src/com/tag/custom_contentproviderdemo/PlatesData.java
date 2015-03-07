package com.tag.custom_contentproviderdemo;

import android.net.Uri;
import android.provider.BaseColumns;

public class PlatesData {

	public PlatesData() {

	}

	// A content URI is a URI that identifies data in a provider. Content URIs
	// include the symbolic name of the entire provider (its authority)
	public static final String AUTHORITY = "com.tag.custom_contentproviderdemo.Plates";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/plates");

	public static final String DATABASE_NAME = "plates.db";
	public static final int DATABASE_VERSION = 1;

	public static final String CONTENT_TYPE_PLATES = "vnd.android.cursor.dir/vnd.tag.plates";
	public static final String CONTENT_TYPE_PLATE = "vnd.android.cursor.item/vnd.tag.plate";

	public class Plates implements BaseColumns {

		private Plates() {

		}

		public static final String TABLE_NAME = "plates";

		public static final String _ID = "_id";
		public static final String _TITLE = "title";
		public static final String _CONTENT = "content";
	}
}