package com.example.cookversity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView rbA;
    private TextView rbB;
    private TextView rbC;
    private TextView rbD;
    private ArrayList<Quiz> list;


//    private OnFragmentInteractionListener mListener;

    public QuizActivity() {
        // Required empty public constructor
    }
    int position= 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        int quizP =  getIntent().getIntExtra("position",0);
        if (quizP==0) {
            list = Quiz.getQuizList();
        }else if (quizP==1) {
            list = Quiz.getQuizList1();
        }if (quizP==2) {
            list = Quiz.getQuizList2();
        }
        tvTitle =findViewById(R.id.tv_title);
        rbA = findViewById(R.id.rb_a);
        rbB =findViewById(R.id.rb_b);
        rbC = findViewById(R.id.rb_c);
        rbD = findViewById(R.id.rb_d);
        initQuestion();
        rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==5){
                    showCorrect();
                    return;
                }
                Quiz quiz = list.get(position);

                quiz.setAnswer("a");
                position++;
                initQuestion();
            }
        });
        rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==5){
                    showCorrect();
                    return;
                }
                Quiz quiz = list.get(position);
                quiz.setAnswer("b");
                position++;
                initQuestion();
            }
        });
        rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==5){
                    showCorrect();
                    return;
                }
                Quiz quiz = list.get(position);
                quiz.setAnswer("c");
                position++;
                initQuestion();
            }
        });
        rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==5){
                    showCorrect();
                    return;
                }
                Quiz quiz = list.get(position);
                quiz.setAnswer("d");
                position++;
                initQuestion();
            }
        });

    }
    private void initQuestion() {
        if (position==5){
            showCorrect();
            return;
        }
        Quiz quiz = list.get(position);
        tvTitle.setText(quiz.getTitle());
        rbA.setText("A:"+quiz.getA());
        rbB.setText("B:"+quiz.getB());
        rbC.setText("C:"+quiz.getC());
        rbD.setText("D:"+quiz.getD());
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        rbA.setAnimation(shake);
        rbB.setAnimation(shake);
        rbC.setAnimation(shake);
        rbD.setAnimation(shake);
    }

    private void showCorrect() {
        new AlertDialog.Builder(this)
                .setTitle("Tips")
                .setMessage("View Results")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        position=0;
                        initQuestion();
                        Intent intent = new Intent(QuizActivity.this,QuestionResultActivity.class);
                        intent.putExtra("data",  list);
                        startActivity(intent);
                    }
                }).create().show();
    }
}
