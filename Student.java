package OnlineExam;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Student extends User {

    private ArrayList<Exam> studentResults = new ArrayList<>();



    public Student() {this.setUserType(UserType.Student);}
    public Student(int userId, String userName, String password) {
        this.setUserType(UserType.Student);
        this.setUserName(userName);
        this.setPassword(password);
        this.setUserId(userId);
        this.studentResults = new ArrayList<>();
        Admin.getStudentsList().add(this);
    }


    public ArrayList<Exam> getStudentResults() {return studentResults;}
    public void setStudentResults(ArrayList<Exam> studentResults) {this.studentResults = studentResults;}



    public void takeExam(int examId) {
        for(Exam exam: Instructor.getExamList()) {
            if(exam.getExamId() == examId) {
                Scanner in = new Scanner(System.in);
                for(Question question:exam.getQuestions()) {
                    System.out.println(question);
                    int choice = in.nextInt();
                    question.setStudentAnswer(question.getOptions()[choice-1]);
                    if(question.isCorrect()) {
                        exam.setGrade(exam.getGrade()+question.getMark());
                    }
                    studentResults.add(exam);
                }
                this.submitExam(exam);
                break;
            }
        }

    }

    public void submitExam(Exam exam) {
        if (exam == null) {
            System.out.println("Invalid exam. Cannot submit.");
            return;
        }
        else{
           System.out.println("Exam Grade: " + exam.getGrade());
        }
    }



    public void viewResults() {
        System.out.println("Exam Results for Student ID: " + this.getUserId());
        if (studentResults.isEmpty()) {
            System.out.println("No exam results available.");
        } else {
            for (Exam exam : studentResults) {
                System.out.println("Exam Id: " + exam.getExamId()+"\t"+"Subject: " + exam.getSubject()+"\t"+"Grade: " + exam.getGrade());
            }
        }
    }


    public String toString() {
        return this.getUserType()+"\t"+this.getUserName() + "\t" + this.getUserId() + "\t" + this.getStudentResults()+"\n";
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Take Exam");
        System.out.println("2. view Results");
        System.out.println("3. Exit");
        Scanner in = new Scanner(System.in);
        int choice;
        boolean validCh=false;
        do {
            System.out.println("Enter choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:{
                    validCh=true;
                    boolean exists=false;
                    do{
                        System.out.println("Enter exam ID: ");
                        int examId = in.nextInt();
                        for(Exam exam: Instructor.getExamList()) {
                            if(exam.getExamId() == examId) {
                                exists=true;
                                takeExam(examId);
                                break;
                            }
                            System.out.println("Invalid exam ID.");
                        }
                    }while(!exists);
                    break;
                }
                case 2:{
                    validCh=true;
                    this.viewResults();
                    break;
                }
                case 3:{
                    validCh=true;
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice.");
            }

        }while(!validCh);
    }
}
