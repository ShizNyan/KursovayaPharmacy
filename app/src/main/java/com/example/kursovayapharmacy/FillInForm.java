package com.example.kursovayapharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileOutputStream;
import java.io.IOException;

public class FillInForm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_in_form);

        EditText FIO = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText address = (EditText)findViewById(R.id.editTextTextPostalAddress);
        EditText phone = (EditText)findViewById(R.id.editTextPhone);

        ImageButton back_button4 = (ImageButton)findViewById(R.id.button_back4);
        Button finish = (Button)findViewById(R.id.finish_button);

        back_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillInForm.this, BasketActivity.class);
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = FIO.getText().toString()+" "+address.getText().toString()+" "+phone.getText().toString()+"\n";
                try{
                FileOutputStream out = openFileOutput("UsersBase.txt", MODE_APPEND);
                out.write(data.getBytes());
                out.close();
                }catch(IOException e){
                    e.getMessage();
                }

                Intent intent = new Intent(FillInForm.this, ThankingActivity.class);
                startActivity(intent);
            }
        });

    }
}
