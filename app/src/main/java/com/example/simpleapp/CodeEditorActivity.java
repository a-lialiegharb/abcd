package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CodeEditorActivity extends AppCompatActivity {

    private EditText codeInput;
    private Button runCode;
    private TextView codeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_editor);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        codeInput = findViewById(R.id.code_input);
        runCode = findViewById(R.id.run_code);
        codeOutput = findViewById(R.id.code_output);

        runCode.setOnClickListener(v -> {
            String code = codeInput.getText().toString();
            Python py = Python.getInstance();
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            System.setErr(ps);
            try {
                py.getModule("main").callAttr("main", code);
                codeOutput.setText(baos.toString());
            } catch (Exception e) {
                codeOutput.setText(e.getMessage());
            }
        });
    }
}
