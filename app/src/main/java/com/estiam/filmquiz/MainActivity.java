package com.estiam.filmquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.estiam.filmquiz.projos.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "QuizActivity";
    public static final String KEY_INDEX = "index";
    public static final String KEY_SCORE = "score";
    public static final String KEY_QUESTION = "question";

    private Button btnTrue;
    private Button btnFalse;

    private ImageButton btnRetry;

    private TextView tvQuestion;
    private TextView tvScore;

    private int score=0;
    private int indexQuestion = 0;

    private final List<Question> questions= new ArrayList<>();

    private String scoreFormat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() called");

        //test si le bundle existe
        if(savedInstanceState != null){
            //recupérer les données
            indexQuestion=savedInstanceState.getInt(KEY_INDEX);
            score=savedInstanceState.getInt(KEY_SCORE);
        }

        //recupère les éléments
        btnTrue=findViewById(R.id.btnTrue);
        btnFalse=findViewById(R.id.btnFalse);
        btnRetry=findViewById(R.id.btnRetry);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvScore=findViewById(R.id.tvScore);

        //créer les questions et les ajouter à la liste
        questions.add(new Question(getResources().getString(R.string.question_ai),true));
        questions.add(new Question(getResources().getString(R.string.question_taxi_driver),true));
        questions.add(new Question(getResources().getString(R.string.question_2001),false));
        questions.add(new Question(getResources().getString(R.string.question_reservoir_dogs),true));
        questions.add(new Question(getResources().getString(R.string.question_citizen_kane),false));

        //modifie le text de tvQuestion avec le texte de la question
        tvQuestion.setText(questions.get(indexQuestion).getText());

        //évènement sur le bouton true
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(questions.get(indexQuestion).isAnswer()){
                        //Toast.makeText(MainActivity.this, "VRAI", Toast.LENGTH_SHORT).show();
                        //cumul du score
                        score++;
                    }
                    //passe à la question suivante
                    indexQuestion++;

                    //modifie le text de tvQuestion avec le texte de la question
                    tvQuestion.setText(questions.get(indexQuestion).getText());
                }
                catch (IndexOutOfBoundsException e){
                    tvQuestion.setText(R.string.endQuiz);

                    //afficher le score final dans tvScore
                    scoreFormat="Score : "+score+"/"+questions.size();
                    tvScore.setText(scoreFormat);

                    //rendre le tvScore visible
                    tvScore.setVisibility(View.VISIBLE);

                    //rendre le btnRetry visible
                    btnRetry.setVisibility(View.VISIBLE);

                }
            }
        });

        //évènement sur le bouton false
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if(!questions.get(indexQuestion).isAnswer()){
                        //Toast.makeText(MainActivity.this, "VRAI", Toast.LENGTH_SHORT).show();
                        //cumul du score
                        score++;
                    }
                    //passe à la question suivante
                    indexQuestion++;

                    //modifie le text de tvQuestion avec le texte de la question
                    tvQuestion.setText(questions.get(indexQuestion).getText());
                }
                catch (IndexOutOfBoundsException e){
                    tvQuestion.setText(R.string.endQuiz);

                    //afficher le score final dans tvScore
                    scoreFormat="Score : "+score+"/"+questions.size();
                    tvScore.setText(scoreFormat);

                    //rendre le tvScore visible
                    tvScore.setVisibility(View.VISIBLE);

                    //rendre le btnRetry visible
                    btnRetry.setVisibility(View.VISIBLE);



                }
            }
        });

        //Refaire une partie
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rendre le tvScore invisible
                tvScore.setVisibility(View.GONE);

                //rendre le btnRetry visible
                btnRetry.setVisibility(View.GONE);

                //renitialiser le score et l'index de la liste
                indexQuestion=0;
                score=0;

                //modifie le text de tvQuestion avec le texte de la question
                tvQuestion.setText(questions.get(indexQuestion).getText());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        //créer menu à partir de la ressource
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //effectuer une action en fonction de l'item sélectionner
        //test avec un switch l'id de l'item
        switch (item.getItemId()){
            case R.id.cheat:
                //créer une intent pour ensuite lancer le cheat_activity
                Intent intent=new Intent(getApplicationContext(), CheatActivity.class);


                //ajouter dans le intent des données
                //intent.putExtra(KEY_QUESTION,questions.get(questions.get(indexQuestion)));

                //démarrer l'activité
                startActivity(intent);
                return true;

            default:  return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState() called");

        outState.putInt(KEY_INDEX,indexQuestion);
        outState.putInt(KEY_SCORE,score);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}