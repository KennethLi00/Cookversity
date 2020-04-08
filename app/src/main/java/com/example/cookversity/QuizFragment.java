package com.example.cookversity;

import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;

public class QuizFragment extends Fragment {
    private View view;
    private TextView tvTitle;
    private RadioButton rbA;
    private RadioButton rbB;
    private RadioButton rbC;
    private RadioButton rbD;
    private ArrayList<Quiz> list;
    private RadioGroup rgQuiz;

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
        rgQuiz = view.findViewById(R.id.rg_quiz);
        rbA = view.findViewById(R.id.rb_a);
        rbB = view.findViewById(R.id.rb_b);
        rbC = view.findViewById(R.id.rb_c);
        rbD = view.findViewById(R.id.rb_d);
        initQuestion();
        rgQuiz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (position==5){
                    showCorrect();
                    return;
                }
                Quiz quiz = list.get(position);
                if (checkedId==R.id.rb_a){
                   if (quiz.getOK().equals("a")){
                       correctNu++;
                   }
                }else if (checkedId==R.id.rb_b){
                    if (quiz.getOK().equals("b")){
                        correctNu++;
                    }
                }else if (checkedId==R.id.rb_c){
                    if (quiz.getOK().equals("c")){
                        correctNu++;
                    }
                }else if (checkedId==R.id.rb_d){
                    if (quiz.getOK().equals("d")){
                        correctNu++;
                    }
                }

                position++;
                initQuestion();
            }
        });
    }
    int  correctNu=0;
    private void initQuestion() {
        if (position==5){
            showCorrect();
            return;
        }
        Quiz quiz = list.get(position);
        tvTitle.setText(quiz.getTitle());
        rbA.setText("A."+quiz.getA());
        rbB.setText("B."+quiz.getB());
        rbC.setText("C."+quiz.getC());
        rbD.setText("D."+quiz.getD());
        Animation shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        rbA.setAnimation(shake);
        rbB.setAnimation(shake);
        rbC.setAnimation(shake);
        rbD.setAnimation(shake);
    }

    private void showCorrect() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Tips")
                .setMessage("Answer "+correctNu+" questions correctly")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        position=0;
                        correctNu=0;
                        rbA.setChecked(false);
                        rbB.setChecked(false);
                        rbC.setChecked(false);
                        rbD.setChecked(false);
                        initQuestion();
                    }
                }).create().show();
    }
}
