package com.example.cookversity;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {
    private String title;
    private String A;
    private String B;
    private String C;
    private String D;
    private String OK;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Quiz(String title, String a, String b, String c, String d, String ok) {
        this.title = title;
        A = a;
        B = b;
        C = c;
        D = d;
        OK = ok;
    }

    public String getOK() {
        return OK;
    }

    public void setOK(String OK) {
        this.OK = OK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public static ArrayList<Quiz> getQuizList(){
        ArrayList<Quiz> list = new ArrayList<>();

        list.add(new Quiz("Which of these cutting boards is the most sanitary?","Wood","Bamboo","Plastic","All three are the same.","c"));
        list.add(new Quiz("How does adding salt to boiling water affect it?","Speeds up the process of boiling water.","It delays the process of water boiling.","Softens the water.","Stops the water from boiling at all.","b"));
        list.add(new Quiz("How can you determine if an egg has gone bad?","If it sinks to the bottom in a bowl of water and lays flat on its side.","If it floats to the surface in a bowl full of water.","Shake it to see if it rattles.","If it feels warm when you handle it.","b"));
        list.add(new Quiz("What is a measure of the energy you get from food?","Carbohydrates.","Fat.","Fiber.","Calorie.","d"));
        list.add(new Quiz("Which vitamin is important for eyesight?","Vitamin A."," Vitamin B."," Vitamin C."," Vitamin D.","a"));
        return list;
    }





}
