package com.example.mickey.downloadmanager;

import android.app.DownloadManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*******
 *
 *
 * https://www.androidtutorialpoint.com/networking/android-download-manager-tutorial-download-file-using-download-manager-internet/
 *
 *
 * *********/

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();
    public static final String IMAGE_URI = "https://www.androidtutorialpoint.com/wp-content/uploads/2016/09/Beauty.jpg";
    public static final String MUSIC_URI = "https://www.androidtutorialpoint.com/wp-content/uploads/2016/09/AndroidDownloadManager.mp3";


    private Button mDownloadImageBtn;
    private Button mDownloadMusicBtn;
    private Button mCheckStatusBtn;
    private Button mCancelAllDownloadsBtn;

    private Uri mImageUri;
    private Uri mMusicUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        setListener();

        mImageUri = Uri.parse(IMAGE_URI);
        mMusicUri = Uri.parse(MUSIC_URI);

        DownloadHelper.getInstance().init(MainActivity.this);
    }

    private void initLayout() {
        mDownloadImageBtn = findViewById(R.id.download_image);
        mDownloadMusicBtn = findViewById(R.id.download_music);
        mCheckStatusBtn = findViewById(R.id.check_status);
        mCancelAllDownloadsBtn = findViewById(R.id.cancel_all_downloads);
    }

    private void setListener() {
        mDownloadImageBtn.setOnClickListener(mDownloadImgListener);
        mDownloadMusicBtn.setOnClickListener(mDownloadImgListener);
        mCheckStatusBtn.setOnClickListener(mDownloadImgListener);
        mCancelAllDownloadsBtn.setOnClickListener(mDownloadImgListener);
    }

    View.OnClickListener mDownloadImgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Download Image!");
            DownloadHelper.getInstance().DownloadData(mImageUri, v);

            mCheckStatusBtn.setEnabled(true);
            mCancelAllDownloadsBtn.setEnabled(true);
        }
    };
    View.OnClickListener mDownloadMscListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Download Music!");
            DownloadHelper.getInstance().DownloadData(mMusicUri, v);

            mCheckStatusBtn.setEnabled(true);
            mCancelAllDownloadsBtn.setEnabled(true);
        }
    };
    View.OnClickListener mCheckStatusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Check Status!");
        }
    };
    View.OnClickListener mCancelDownloadListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Cancel All");
        }
    };
}
