package com.estiam.filmquiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.estiam.filmquiz.projos.Question;

import java.util.ArrayList;
import java.util.List;

public class CheatActivity extends AppCompatActivity {


    private TextView tvReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        //recupère les éléments
        tvReponse=findViewById(R.id.tvReponse);

        //Recupérer l'intent qui a recupéré cette activity
        Intent intent= getIntent();

        //recupérer la question qui est dans l'intent
        //Question question = (Question)intent.getSerializableExtra(MainActivity.KEY_QUESTION);
        //tvReponse.setText(String.format("%s : %s", question.getText(),question.isAnswer()));

        /*ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);*/
    }

   /* @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }*/
}