package OnlineExam;

import java.lang.*;
import java.io.*;

public class Question implements Serializable {
    private int questionNum;
    private String questionText;
    private String[] options = new String[4];
    private String correctAnswer;
    private String studentAnswer;
    private double mark;
    private Subject subject;



    public Question (){Instructor.getQuestionBank().add(this);}

    public Question (int questionNum, String questionText, String[] options, String correctAnswer,Subject subject, double mark){
        this.questionNum=questionNum;
        this.questionText=questionText;
        this.options=options;
        this.correctAnswer=correctAnswer;
        this.subject=subject;
        this.mark=mark;
        Instructor.getQuestionBank().add(this);
    }

    public String getQuestionText (){
        return questionText;
    }
    public void setQuestionText(String questionText){
        this.questionText=questionText;
    }
    public String[] getOptions(){return options;}
    public void setOptions(String[] options){this.options=options;}
    public String getCorrectAnswer(){return correctAnswer;}
    public void setCorrectAnswer(String correctAnswer){this.correctAnswer=correctAnswer;}
    public String getStudentAnswer(){return studentAnswer;}
    public void setStudentAnswer(String studentAnswer){this.studentAnswer=studentAnswer;}
    public double getMark(){return mark;}
    public void setMark(double mark){this.mark=mark;}
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public int getQuestionNum() {return questionNum;}
    public void setQuestionNum(int questionNum) {this.questionNum = questionNum;}



    public boolean isCorrect() {return correctAnswer.equals(studentAnswer);}


    public String toString(){
        return  "."+questionText+ "\n" +"\t"+"1."+options[0]+"\n"+"\t"+"2."+options[1]+ "\n" +"\t"+ "3."+options[2]+"\n"+"\t"+"4."+options[3]+"\n";}

}
