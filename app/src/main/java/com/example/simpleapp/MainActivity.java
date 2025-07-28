package com.example.simpleapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topicList;
    private TopicAdapter topicAdapter;
    private List<Topic> topics;
    private Button startQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topicList = findViewById(R.id.topic_list);
        startQuiz = findViewById(R.id.start_quiz);
        topicList.setLayoutManager(new LinearLayoutManager(this));

        topics = new ArrayList<>();
        topics.add(new Topic("Variables", "Variables are containers for storing data values.", "x = 5\ny = \"Hello, World!\""));
        topics.add(new Topic("Data Types", "Data types specify the type of data that a variable can hold.", "x = 5 # int\ny = \"Hello, World!\" # str\nz = 20.5 # float"));
        topics.add(new Topic("Control Flow", "Control flow is the order in which statements are executed.", "a = 200\nb = 33\nif b > a:\n  print(\"b is greater than a\")\nelse:\n  print(\"b is not greater than a\")"));

        topicAdapter = new TopicAdapter(topics, topic -> {
            Intent intent = new Intent(this, TopicDetailActivity.class);
            intent.putExtra("topic_name", topic.getName());
            intent.putExtra("topic_description", topic.getDescription());
            intent.putExtra("code_example", topic.getCodeExample());
            startActivity(intent);
        });

        topicList.setAdapter(topicAdapter);

        startQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });
    }
}
