package com.example.cookversity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizFragment extends Fragment {
    private View view;
    private TextView tvTitle;
    private TextView rbA;
    private TextView rbB;
    private TextView rbC;
    private TextView rbD;
    private ArrayList<Quiz> list;


//    private OnFragmentInteractionListener mListener;

    public QuizFragment() {
        // Required empty public constructor
    }
    int position= 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = Quiz.getQuizList();
        tvTitle = view.findViewById(R.id.tv_title);
        rbA = view.findViewById(R.id.rb_a);
        rbB = view.findViewById(R.id.rb_b);
        rbC = view.findViewById(R.id.rb_c);
        rbD = view.findViewById(R.id.rb_d);
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
        rbA.setText(quiz.getA());
        rbB.setText(quiz.getB());
        rbC.setText(quiz.getC());
        rbD.setText(quiz.getD());
        Animation shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        rbA.setAnimation(shake);
        rbB.setAnimation(shake);
        rbC.setAnimation(shake);
        rbD.setAnimation(shake);
    }

    private void showCorrect() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Tips")
                .setMessage("View Results")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        position=0;
                        initQuestion();
                        Intent intent = new Intent(getActivity(),QuestionResultActivity.class);
                        intent.putExtra("data",  list);
                        startActivity(intent);
                    }
                }).create().show();
    }
}
