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
    public static ArrayList<Quiz> getQuizList1(){
        ArrayList<Quiz> list = new ArrayList<>();

        list.add(new Quiz("What is the correct temperature that frozen food should be kept at?  ","0 degrees","15 degrees or lower","-18 degrees or lower","20 degrees or lower","c"));
        list.add(new Quiz("Where should raw meat be stored in a refrigerator? ","At the top.","In the middle.","At the bottom, below all other food.","Put it on the ground","c"));
        list.add(new Quiz("Which one of the following jewellery is acceptable for a food handler to wear?   ","Plain wedding band.","Arm ring","Bracelet ."," A ring that is a symbol of religious faith.","a"));
        list.add(new Quiz("What is the ideal temperature for Pathogens to flourish?  ","10 degrees","37 degrees.","55 degrees.","90 degrees.","b"));
        list.add(new Quiz("How many times can you reheat leftovers?  ","As many times as you like."," Twice. ","  Four times. "," You should only reheat leftovers once.","d"));
        return list;
    }




    public static ArrayList<Quiz> getQuizList2(){
        ArrayList<Quiz> list = new ArrayList<>();

        list.add(new Quiz("Which of the following meats are safe to eat when they are pink or raw?","Chicken","Pork","Minced meat","Lamb","d"));
        list.add(new Quiz("What are the basic steps for washing hands?","Wash thoroughly with water and dry.","It delays the process of water boiling.","Apply soap, wash thoroughly, rinse and use paper towels.","","b"));
        list.add(new Quiz(" What is the reason for drying your hands after washing them?","Because germs and bacteria are more easily spread with wet hands.","Your hands are slippery when wet, and you will not be able to hold kitchen utensils properly.","If it feels warm when you handle it.","","b"));
        list.add(new Quiz(" Which of the following is true about bacteria;"," Bacteria multiplies and grows faster in warm environments.","Bacteria needs air to survive.","Every type of bacteria can give people food poisoning..","By freezing food you can kill bacteria.","a"));
        list.add(new Quiz("The ideal temperature in your fridge should be?","4 – 10 degrees","1 and 4 degrees.","0 to 4 degrees."," -2 to 0 degrees.","b"));
        return list;
    }


}
