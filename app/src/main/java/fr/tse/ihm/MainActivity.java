package fr.tse.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_NAME8REQUEST_CODE = 1;
    public static final String USERNAME_EXTRA = "USERNAME";
    private RecyclerView recyclerView;
    private Button addNameButton;
    private ListItemViewAdapter listItemViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNameButton = findViewById(R.id.activity_main_add_name_button);
        listItemViewAdapter = new ListItemViewAdapter(DataManager.getInstance().getStringList());

        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

        recyclerView = findViewById(R.id.activity_main_recycler_view);
        recyclerView.setAdapter(listItemViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void addName() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivityForResult(intent, ADD_NAME8REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NAME8REQUEST_CODE && data != null) {
            if (resultCode == RESULT_OK && data.getExtras() != null) {
                String name = data.getStringExtra(USERNAME_EXTRA);
                DataManager.getInstance().addString(name);
                listItemViewAdapter.notifyItemInserted(DataManager.getInstance().getStringList().size() - 1);
            }
        }
    }
}
