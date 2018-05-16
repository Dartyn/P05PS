package com.example.a16022667.p05ps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

	//TODO Define the Database properties
	private static final String DATABASE_NAME = "songs.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NOTE = "song";
	private static final String COLUMN_TITLE = "title";
	private static final String COLUMN_SINGERS = "singers";
	private static final String COLUMN_YEAR = "year";
	private static final String COLUMN_STARS = "stars";
	private static final String COLUMN_ID = "_id";




	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO CREATE TABLE Note
		String createNoteTableSql = "CREATE TABLE " + TABLE_NOTE + "("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ COLUMN_SINGERS + " TEXT," +
				COLUMN_YEAR + " INTEGER," +
				COLUMN_STARS + " INTEGER," +
				COLUMN_TITLE + " TEXT," +
				COLUMN_SINGERS + " TEXT ) ";
		//db.execSQL(createNoteTableSql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
		onCreate(db);
	}

	public long insertSinger(String noteContent) {
		//TODO insert the data into the database
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_SINGERS, noteContent);
		long result = db.insert(TABLE_NOTE, null, values);
		db.close();
		Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
		return result;
	}
	public long insertSong(String noteContent) {
		//TODO insert the data into the database
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_TITLE, noteContent);
		long result = db.insert(TABLE_NOTE, null, values);
		db.close();
		Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
		return result;
	}
	public long insertYear(String noteContent) {
		//TODO insert the data into the database
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_YEAR, noteContent);
		long result = db.insert(TABLE_NOTE, null, values);
		db.close();
		Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
		return result;
	}

	public ArrayList<String> getAllNotes() {
		//TODO return records in Java objects
		ArrayList<String> notes = new ArrayList<String>();

		String selectQuery = "SELECT " + COLUMN_ID + ","
				+ COLUMN_TITLE
				+ COLUMN_STARS
				+ COLUMN_YEAR
				+ COLUMN_SINGERS
				+ " FROM " + TABLE_NOTE;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				int id = cursor.getInt(0);
				String content = cursor.getString(1);
				notes.add("ID:" + id + ", " + content);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return notes;
	}

    public ArrayList<String> getNoteContent() {
        //TODO return records in Strings

		// Create an ArrayList that holds String objects
        ArrayList<String> notes = new ArrayList<String>();
        // Select all the notes' content
        String selectQuery = "";

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row and returns true;
            // moveToNext() returns false when no more next row to move to
            do {


            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return notes;
    }
}
