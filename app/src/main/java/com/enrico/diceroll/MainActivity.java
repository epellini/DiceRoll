package com.enrico.diceroll;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private Button btnRollDice;
    public static final String EXTRA_TEXT = "com.enrico.diceroll.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRollDice = (Button) findViewById(R.id.btnDice);

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }
    public void rollDice() {

        EditText txtName = (EditText) findViewById(R.id.txtName);
        String name = txtName.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, name);

        startActivity(intent);
    }
}