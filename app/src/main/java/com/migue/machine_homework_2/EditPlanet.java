package com.migue.machine_homework_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditPlanet extends AppCompatActivity implements View.OnClickListener{

    TextView tv_name;
    Button btn_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_planet);
        Intent intent = getIntent();

        tv_name = findViewById(R.id.tv_pname);
        btn_edit = findViewById(R.id.btn_edit);

        tv_name.setText(intent.getStringExtra("planetName"));
        btn_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("newName", tv_name.getText());
        setResult(Activity.RESULT_OK, intent);
    }
}
