package com.example.myapplication121;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Uri contentUri =
                    Uri.parse("content://com.example.myapplication12.provider/books");
            ContentResolver resolver = getContentResolver();
            Cursor cursor = resolver.query(contentUri, new String[]{"id", "name"},
                    null, null, null);
            if (cursor != null) {
                try {
                    int idColumn = cursor.getColumnIndex("id");
                    int nameColumn = cursor.getColumnIndex("name");
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(idColumn);
                        String name = cursor.getString(nameColumn);
                        System.out.println("Book ID: " + id);
                        System.out.println("Book Title: " + name);
                    }
                } finally {
                    cursor.close();
                }
            }
    }
}