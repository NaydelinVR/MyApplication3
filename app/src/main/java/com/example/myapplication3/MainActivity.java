package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.checkerframework.common.subtyping.qual.Bottom;

public class MainActivity extends AppCompatActivity {
    private EditText mTitle, mMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        System.out.println("TOKEN " + token);

                    }
                });*/

        mTitle = findViewById(R.id.mTitle);
        mMessage = findViewById(R.id.mMessage);

        findViewById(R.id.mSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitle.getText().toString().trim();
                String message = mMessage.getText().toString().trim();
                if (!title.equals("") && !message.equals("")){
                    FCMSend.pushNotification(
                            MainActivity.this,
                            "didFpaeuSyW-1rvZLcxt3Z:APA91bGVo__B7QIfJ_TJdJxRSV0EEi9QA6tApEwrrNZj4j7UCV_PXDfXWj4TapQuvbLvi-rvFGvRBhj3KaTA5-w79XPlqsJc-rXKzmhFcLjbTH2U1Z-TTAAuNaqb-e71l0QC-DcalSjM",
                            title,
                            message


                    );
                }
            }
        });
    }
}