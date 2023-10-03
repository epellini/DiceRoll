package com.enrico.diceroll;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Create button
        btnShare = (Button) findViewById(R.id.btnShare);

        // Get User Name Input
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        // Generate a random 3-digit number and assign it to a TextView
        TextView randomNumberTextView = findViewById(R.id.txtDiceNumber);
        int randomNumber = new Random().nextInt(900) + 100;
        // Convert Int to String:
        String randomNumberString = String.valueOf(randomNumber);
        // Update Text:
        randomNumberTextView.setText(randomNumberString);

        // Button action
       btnShare.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent sendIntent = new Intent();
               sendIntent.setAction(Intent.ACTION_SEND);
               sendIntent.putExtra(Intent.EXTRA_TEXT, name + ", your lucky number is " + randomNumberString);

               sendIntent.setType("text/plain");

               Intent shareIntent = Intent.createChooser(sendIntent, null);
               startActivity(shareIntent);
           }
       });
    }
}
