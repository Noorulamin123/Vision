package com.google.firebase.codelab.mlkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import static com.google.firebase.codelab.mlkit.SendTextActivity.send;

public class OutputActivity extends AppCompatActivity{

    public static TextView tvOutput;
    public static String output;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        tvOutput = (TextView) findViewById(R.id.tvOutput);

        output = getIntent().getExtras().getString("output");

        tvOutput.setText(output);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_output, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                editText();
                return true;
            case R.id.send:
                sendText();
                return true;
            case R.id.cancel:
                cancelSend();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cancelSend() {
        Toast.makeText(OutputActivity.this, "Sending Cancelled", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void sendText() {
        send();
        Toast.makeText(OutputActivity.this,"Text Sent",Toast.LENGTH_SHORT).show();
        finish();
    }

    private void editText() {
        Intent editTextIntent = new Intent(OutputActivity.this,EditTextActivity.class);
        startActivity(editTextIntent);
    }
}
