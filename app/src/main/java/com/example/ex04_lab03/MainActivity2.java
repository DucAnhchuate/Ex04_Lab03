package com.example.ex04_lab03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    EditText  name1, job, phone, add, email, link;

    TextView name;

    Button save, camera;

    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        camera = findViewById(R.id.Ecamera);

        name1 = findViewById(R.id.Ename1);

        job = findViewById(R.id.Ejob);

        phone = findViewById(R.id.Ephone);

        add = findViewById(R.id.Eadd);

        email = findViewById(R.id.Eemail);

        name = findViewById(R.id.Ename);

        link = findViewById(R.id.Elink);

        save = findViewById(R.id.save);

        camera = findViewById(R.id.Ecamera);

        im = findViewById(R.id.imageView);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));

        name1.setText(intent.getStringExtra("name"));

        job.setText(intent.getStringExtra("job"));

        phone.setText(intent.getStringExtra("phone"));

        email.setText(intent.getStringExtra("email"));

        add.setText(intent.getStringExtra("add"));

        link.setText(intent.getStringExtra("link"));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("name", MainActivity2.this.name.getText().toString());

                intent.putExtra("phone", MainActivity2.this.phone.getText().toString());

                intent.putExtra("add", MainActivity2.this.add.getText().toString());

                intent.putExtra("link", MainActivity2.this.link.getText().toString());

                intent.putExtra("email", MainActivity2.this.email.getText().toString());

                intent.putExtra("job", MainActivity2.this.job.getText().toString());

                setResult(RESULT_OK, intent);

                finish();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent,1337);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1337) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.imageView); //sets imageview as the bitmap
            imageview.setImageBitmap(image);
        }
    }
}