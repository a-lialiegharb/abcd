package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TopicDetailActivity extends AppCompatActivity {

    private TextView topicName;
    private TextView topicDescription;
    private TextView codeExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        topicName = findViewById(R.id.topic_name);
        topicDescription = findViewById(R.id.topic_description);
        codeExample = findViewById(R.id.code_example);

        String name = getIntent().getStringExtra("topic_name");
        String description = getIntent().getStringExtra("topic_description");
        String code = getIntent().getStringExtra("code_example");

        topicName.setText(name);
        topicDescription.setText(description);
        codeExample.setText(code);
    }
}
