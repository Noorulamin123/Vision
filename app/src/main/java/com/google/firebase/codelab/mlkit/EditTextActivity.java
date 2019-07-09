package com.google.firebase.codelab.mlkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.google.firebase.codelab.mlkit.OutputActivity.output;
import static com.google.firebase.codelab.mlkit.OutputActivity.tvOutput;

public class EditTextActivity extends AppCompatActivity {
    public static EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        Button button = (Button) findViewById(R.id.change_text);
        editText = (EditText)findViewById(R.id.editText);
        Intent editTextIntent = getIntent();
        editText.setText(output);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output = editText.getText().toString();
                tvOutput.setText(output);
                finish();
            }
        });
    }
}

