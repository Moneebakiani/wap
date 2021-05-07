package com.example.lab12;

import java.util.ArrayList;
import java.util.List;

public class Question {
    String element;
    int answer;

     public Question(String ele,int answers ){
         this.answer=answers;
         this.element=ele;
     }


     public static List<Question> creatQuestions(){

         List<Question> list=new ArrayList<Question>();
         list.add(new Question("3, 1, 4, 1, 5",6));
         list.add(new Question("1, 1, 2, 3, 5",8));
         list.add(new Question("1, 4, 9, 16, 25",36));

         return list;
     }


}
