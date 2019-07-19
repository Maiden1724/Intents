package com.ghost.androidintenceapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button mbtnDial,mbtncall,mbtncamera,mbtnemail,mbtnshare,mbtnMpesa,mbtnHome,mbtnsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mbtnDial = findViewById(R.id.btndial);
        mbtnsms = findViewById(R.id.btncamera);
        mbtncamera = findViewById(R.id.btncamera);
        mbtnemail = findViewById(R.id.btnmail);
        mbtnshare = findViewById(R.id.btnshare);
        mbtnMpesa = findViewById(R.id.btnpesa);
        mbtnHome = findViewById(R.id.btnhome);
        mbtncall= findViewById(R.id.btncall);

        mbtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);

            }
        });
        mbtncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"));
                if (ContextCompat.checkSelfPermission(SecondActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SecondActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(intent);
                }

            }
        });

        mbtnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0700800765");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Ssup");
                startActivity(intent);
            }
        });
        mbtncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 1);
            }
        });

        mbtnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "hello sir.....");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mbtnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app!");
                startActivity(shareIntent);

            }
        });

        mbtnMpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if(simToolKitLaunchIntent != null) {
                    startActivity(simToolKitLaunchIntent);
                }
            }
        });
        mbtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(gohome);
            }
        });
    }
}
