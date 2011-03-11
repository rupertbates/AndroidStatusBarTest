package com.example;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String[] LIST_ITEMS = new String[]{"one", "two", "three", "five"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupButton();
        setupListView();

    }

    private void setupListView() {
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LIST_ITEMS));
    }

    private void setupButton() {
        Button button = (Button) findViewById(R.id.notificationButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    private void createNotification() {
        new DownloadTask(getApplicationContext()).execute(0);
    }
}
