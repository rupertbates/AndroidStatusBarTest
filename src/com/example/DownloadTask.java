package com.example;

import android.*;
import android.content.Context;
import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<Integer, Integer, Void>{
    private Context mContext;
    private NotificationHelper mNotificationHelper;
    public DownloadTask(Context context){
        mContext = context;
        mNotificationHelper = new NotificationHelper(mContext);
    }

    protected void onPreExecute(){
        //Create the notification in the statusbar
        mNotificationHelper.createNotification();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        //This is where we would do the actual download stuff
        //for now I'm just going to loop for 10 seconds
        // publishing progress every second
        for (int i=10;i<=100;i += 10)
            {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        return null;
    }
    protected void onProgressUpdate(Integer... progress) {
             mNotificationHelper.progressUpdate(progress[0]);
         }
    protected void onPostExecute(Void result)    {
        mNotificationHelper.completed();
    }
}
