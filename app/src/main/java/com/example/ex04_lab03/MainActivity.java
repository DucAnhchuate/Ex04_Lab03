package com.example.ex04_lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name, name1, phone, email, add, link, job;
    Button edit;

    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);

        name1 = findViewById(R.id.name1);

        phone = findViewById(R.id.phone);

        email = findViewById(R.id.email);

        add = findViewById(R.id.add);

        link = findViewById(R.id.link);

        job = findViewById(R.id.job);

        edit = findViewById(R.id.edit);

        im = findViewById(R.id.imageView2);

        //start
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("name",MainActivity.this.name.getText().toString());

                intent.putExtra("phone",MainActivity.this.phone.getText().toString());

                intent.putExtra("email",MainActivity.this.email.getText().toString());

                intent.putExtra("add",MainActivity.this.add.getText().toString());

                intent.putExtra("link",MainActivity.this.link.getText().toString());

                intent.putExtra("job",MainActivity.this.job.getText().toString());

                startActivityForResult(intent,1234);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1234) {
            MainActivity.this.job.setText(data.getStringExtra("job").toString());

            MainActivity.this.name.setText(data.getStringExtra("name").toString());

            MainActivity.this.name1.setText(data.getStringExtra("name").toString());

            MainActivity.this.add.setText(data.getStringExtra("add").toString());

            MainActivity.this.link.setText(data.getStringExtra("link").toString());

            MainActivity.this.phone.setText(data.getStringExtra("phone").toString());

            MainActivity.this.email.setText(data.getStringExtra("email").toString());

            MainActivity.this.im.setImageBitmap(data.getParcelableExtra("im"));
        }
    }
}