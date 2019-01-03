package fr.tse.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    private Button saveNameButton;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        nameEditText = findViewById(R.id.activity_form_name_edit_text);
        saveNameButton = findViewById(R.id.activity_form_save_name_button);
        saveNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
            }
        });
    }


    private void saveName() {
        String name = nameEditText.getText().toString();
        Intent responseIntent = new Intent();
        responseIntent.putExtra(MainActivity.USERNAME_EXTRA, name);
        setResult(RESULT_OK, responseIntent);
        finish();
    }
}