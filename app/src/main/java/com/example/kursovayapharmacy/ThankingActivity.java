package com.example.kursovayapharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ThankingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks_for_buying);

        Button return_button = (Button)findViewById(R.id.return_button);

        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
