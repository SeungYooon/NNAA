package com.mashup.nnaa.reply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mashup.nnaa.R;
import com.mashup.nnaa.question.QuestionActivity;
import com.mashup.nnaa.util.AccountManager;

public class ReplyActivity extends AppCompatActivity {

    TextView reply_name;
    Button btn_not, btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        reply_name = findViewById(R.id.reply_name);
        btn_not = findViewById(R.id.btn_not);
        btn_start = findViewById(R.id.btn_start);

        Intent intent = getIntent();

        reply_name.setText(intent.getStringExtra("reply_name"));

        String category = intent.getStringExtra("category");

        btn_not.setOnClickListener(view -> {
            finish();
        });
        btn_start.setOnClickListener(view -> {
            Intent start_intent = new Intent(ReplyActivity.this, MultiReplyActivity.class);
            start_intent.putExtra("category", category);
            startActivity(start_intent);
            Toast.makeText(ReplyActivity.this, "답변하러 가실게요!", Toast.LENGTH_SHORT).show();
        });
    }
}
