package fr.tse.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_NAME8REQUEST_CODE = 1;
    public static final String USERNAME_EXTRA = "USERNAME";
    private ArrayAdapter<String> stringArrayAdapter;
    private RecyclerView recyclerView;
    private Button addNameButton;
    private ListView namesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNameButton = findViewById(R.id.activity_main_add_name_button);
        namesListView = findViewById(R.id.activity_main_names_list_view);

        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

//        recyclerView = findViewById(R.id.activity_main_recycler_view);
//        recyclerView.setAdapter(new ViewAdapter(DataManager.getInstance().getStringList()));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                DataManager.getInstance().getStringList());
        namesListView.setAdapter(stringArrayAdapter);

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
                stringArrayAdapter.add(data.getStringExtra(USERNAME_EXTRA));
            }
        }
    }
}
