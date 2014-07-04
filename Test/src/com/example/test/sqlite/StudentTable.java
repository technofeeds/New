package com.example.test.sqlite;

import android.provider.BaseColumns;

public final class StudentTable implements BaseColumns {

	private StudentTable() {

	}

	public static final String TABLE_NAME = "student";
	public static final String COLUMN_NAME_NAME = "name";
	public static final String COLUMN_NAME_SNO = "sno";
	public static final String COLUMN_NAME_DEPT = "dept";
}
