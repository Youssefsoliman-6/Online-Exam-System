package OnlineExam;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Exam implements Serializable {
    private int examId;
    private ArrayList<Question> questions= new ArrayList<>();
    private Subject subject;
    private int timeLimit;
    private double fullMark;
    private Date examDate = new Date(2024,Calendar.DECEMBER,25,8,30);
    private double grade;



    public Exam(){Instructor.getExamList().add(this);}

    public Exam(int examId, Subject subject, double fullMark, int timeLimit, Date examDate, int questionCount) {
        this.examId = examId;
        this.subject = subject;
        this.timeLimit = timeLimit;
        this.fullMark = fullMark;
        this.examDate = examDate;


        ArrayList<Question> subjectQuestions = new ArrayList<>();
        for (Question q : Instructor.getQuestionBank()) {
            if (q.getSubject()==subject) {
                subjectQuestions.add(q);
            }
        }
        Collections.shuffle(subjectQuestions);
        for (int i = 0; i < Math.min(questionCount, subjectQuestions.size()); i++) {
            this.questions.add(subjectQuestions.get(i));
        }

        Instructor.getExamList().add(this);
    }

    public int getExamId(){
        return this.examId;
    }
    public void setExamId(int examId){
        this.examId=examId;
    }
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    public void setQuestions(ArrayList<Question> questions){
        this.questions=questions;
    }
    public Subject getSubject(){
        return subject;
    }
    public void setSubject(Subject subject){
        this.subject=subject;
    }
    public int getTimeLimit(){
        return timeLimit;
    }
    public void setTimeLimit(int timeLimit){
        this.timeLimit=timeLimit;
    }
    public double getFullMark(){
        return fullMark;
    }
    public void setFullMark(double fullMark){
        this.fullMark=fullMark;
    }
    public double getGrade(){
        return grade;
    }
    public void setGrade(double grade){
        this.grade=grade;
    }



    public void displayQuestions(){
        for(Question question:questions){
            System.out.println(question);
        }
    }



    public String toString(){
        return examId+"\n"+subject+"\n"+timeLimit+"\n"+fullMark+"\n"+grade+"\n";
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
