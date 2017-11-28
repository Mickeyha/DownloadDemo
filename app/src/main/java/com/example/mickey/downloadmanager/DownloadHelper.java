package com.example.mickey.downloadmanager;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by Mickey on 2017/11/28.
 */

public class DownloadHelper {
    public static final String TAG = "DownloadHelper";
    private static DownloadHelper ourInstance = new DownloadHelper();
    public static DownloadHelper getInstance() {return ourInstance;}

    private DownloadManager mDownloadManager;
    private Context mContext;

    public void init(Context context) {
        mContext = context;
    }

    public long DownloadData(Uri uri, View v) {
        long downloadRef;   //It is a unique id that we will refer for specific download request.
        DownloadManager.Request request = new DownloadManager.Request(uri);

        // Create request for android download manager
        mDownloadManager = (DownloadManager) mContext.getSystemService(DOWNLOAD_SERVICE);

        //Setting title of request
        request.setTitle("Data Download");
        //Setting description of request
        request.setDescription("Android Data download using DownloadManager.");

        //Set the local destination for the downloaded file to a path within the application's external files directory
        if(v.getId() == R.id.download_music) {
            request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,"Test.mp3");
        } else {
            request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,"Test.jpg");
        }

        //Enqueue download and save into referenceId
        downloadRef = mDownloadManager.enqueue(request);

        return downloadRef;
    }

    public void CheckStatus() {

    }
}
