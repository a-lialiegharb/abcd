package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView question;
    private RadioGroup options;
    private RadioButton option1, option2, option3, option4;
    private Button submit;

    private List<Question> questions;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = findViewById(R.id.question);
        options = findViewById(R.id.options);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        submit = findViewById(R.id.submit);

        loadQuestions();
        displayQuestion();

        submit.setOnClickListener(v -> {
            int selectedOption = options.getCheckedRadioButtonId();
            if (selectedOption != -1) {
                RadioButton selectedRadioButton = findViewById(selectedOption);
                int selectedAnswer = options.indexOfChild(selectedRadioButton);
                if (selectedAnswer == questions.get(currentQuestionIndex).getAnswer()) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    displayQuestion();
                } else {
                    Toast.makeText(this, "Quiz finished!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        List<String> q1Options = new ArrayList<>();
        q1Options.add("A");
        q1Options.add("B");
        q1Options.add("C");
        q1Options.add("D");
        questions.add(new Question("What is the output of the following code?\n\nx = 5\ny = 2\nprint(x % y)", q1Options, 2));

        List<String> q2Options = new ArrayList<>();
        q2Options.add("int");
        q2Options.add("float");
        q2Options.add("str");
        q2Options.add("bool");
        questions.add(new Question("What is the data type of the following variable?\n\nx = \"Hello, World!\"", q2Options, 2));
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        question.setText(currentQuestion.getQuestion());
        List<String> currentOptions = currentQuestion.getOptions();
        option1.setText(currentOptions.get(0));
        option2.setText(currentOptions.get(1));
        option3.setText(currentOptions.get(2));
        option4.setText(currentOptions.get(3));
        options.clearCheck();
    }
}
