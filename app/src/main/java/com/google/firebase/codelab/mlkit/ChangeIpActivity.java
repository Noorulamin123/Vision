package com.google.firebase.codelab.mlkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeIpActivity extends AppCompatActivity {
    public static String IpAddr;
    public static int port;
    public static EditText changePort;
    public static EditText changeIP;
    private boolean flag1,flag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ip);

        changeIP = (EditText)findViewById(R.id.changeIP);
        changePort = (EditText)findViewById(R.id.changePort);
        Button saveButton = (Button)findViewById(R.id.saveIP);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IpAddr = changeIP.getText().toString();
                port = Integer.parseInt(changePort.getText().toString());
                finish();
            }
        });
    }
}
