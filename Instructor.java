package OnlineExam;

import java.lang.*;
import java.io.*;
import java.util.*;
public class Instructor extends User {

    private static ArrayList<Exam> examList=new ArrayList<>();
    protected static File examFile =new File("examsFile.bin");

    private static ArrayList<Question> questionBank = new ArrayList<>();
    protected static File questionFile =new File("questionBankFile.bin");

    public Instructor() {
        this.setUserType (UserType.Instructor);
    }

    public Instructor(int userId, String userName, String password) {
        this.setUserType (UserType.Instructor);
        this.setUserId (userId);
        this.setUserName (userName);
        this.setPassword(password);
        Admin.getInstructorsList().add(this);
    }

    public static ArrayList<Exam> getExamList() {return examList;}
    public static void setExamList(ArrayList<Exam> examList) {Instructor.examList = examList;}
    public static ArrayList<Question> getQuestionBank() {return questionBank;}
    public static void setQuestionBank(ArrayList<Question> questionBank) {Instructor.questionBank = questionBank;}


    public void addQuestion() {
        Question q = new Question();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Question Text: ");
        String questionText = in.next();
        q.setQuestionText(questionText);

        for (int op = 0; op < q.getOptions().length; op++) {
            System.out.println("Enter option " + (op + 1) + " text: ");
            q.getOptions()[op] = in.nextLine();
        }
        System.out.println("Enter Correct Answer: ");
        String correctAnswer = in.nextLine();
        q.setCorrectAnswer(correctAnswer);

        System.out.println("Enter Mark for This question: ");
        double mark = in.nextDouble();
        q.setMark(mark);

        Instructor.getQuestionBank().add(q);
        System.out.println("Question Added to Question Bank");
    }

    public static void displayExams(){
        for(Exam exam:Instructor.getExamList()){
            System.out.println(exam);
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println();

        }
    }

    public void displayQuestionBank(){
        for(Question question:Instructor.getQuestionBank()){
            System.out.println(question);
        }
    }

    public void removeQuestion(Question q) {
        Instructor.getQuestionBank().remove(q);
    }

    public void addExam() {
        Scanner in = new Scanner(System.in);

        // Prompt for Exam ID
        System.out.println("Enter Exam ID: ");
        int examId = in.nextInt();

        // Prompt for Subject using enum and switch case
        System.out.println("Choose Subject: \n1. GEOGRAPHY \n2. MATH \n3. SCIENCE");
        boolean valid=false;
        Subject subject =Subject.MATH; //initial value to avoid initialization error
        do{
            int subjectChoice = in.nextInt();
        switch (subjectChoice) {
            case 1:
                subject = Subject.GEOGRAPHY;
                valid=true;
                break;
            case 2:
                subject = Subject.MATH;
                valid=true;
                break;
            case 3:
                subject = Subject.SCIENCE;
                valid=true;
                break;
            default:
                System.out.println("Invalid choice. Please Enter a Number between 1-3");
        }}while(!valid);

        Date examDate;
        do {
            System.out.println("Enter Exam Date (Month and Day): ");
            int month = in.nextInt();
            int day = in.nextInt();
            System.out.println("Enter Exam Time (Hour and Minute): ");
            int hr = in.nextInt();
            int min = in.nextInt();
            examDate = new Date(2025 - 1900, (month - 1)%11, day%31, hr, min);
        } while (new Date().after(examDate));

        // Prompt for Number of Questions
        System.out.println("Enter Number Of Questions: ");
        int questionCount = in.nextInt();
        Exam e = new Exam(examId, subject, 0.0, 0, examDate, questionCount);

        double fullMark = 0;
        for (Question q : e.getQuestions()) {
            fullMark += q.getMark();
        }
        e.setFullMark(fullMark);

        Instructor.getExamList().add(e);
    }


    public void removeExam(Exam e) {
        Instructor.getExamList().remove(e);
    }



    public String toString() {
        return this.getUserType() + "\t" + this.getUserName() + "\t" + this.getUserId();
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Add Exam");
        System.out.println("2. List Exams");
        System.out.println("3. Remove Exam");
        System.out.println("4. Add Question");
        System.out.println("5. Remove Question");
        System.out.println("6. Exit");
        Scanner in = new Scanner(System.in);
        int choice;
        boolean validCh = false;
        do {
            System.out.println("Enter Choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    validCh = true;
                    addExam();
                    System.out.println("Exam Added");
                    break;
                case 2:
                    validCh = true;
                    Instructor.displayExams();
                    break;
                case 3: {
                    validCh = true;
                    boolean validId = false;
                    do {
                        System.out.println("Enter Exam ID: ");
                        int examId = in.nextInt();
                        for (Exam e : Instructor.getExamList()) {
                            if (e.getExamId() == examId){
                                validId = true;
                                removeExam(e);
                                System.out.println("Exam Removed");
                                displayMenu();
                                break;
                            } else System.out.println("Invalid Exam ID");
                        }
                    } while (!validId);
                    break;
                }
                case 4: {
                    validCh = true;
                    addQuestion();
                    displayMenu();
                    break;
                }
                case 5: {
                    validCh = true;
                    boolean qExists = false;
                    do {
                        System.out.println("Enter Question Number: ");
                        int qNum = in.nextInt();
                        for (Question q : Instructor.getQuestionBank()) {
                            if (q.getQuestionNum() == qNum) {
                                qExists = true;
                                removeQuestion(q);
                            } else System.out.println("Invalid Question Number");
                        }
                    } while (!qExists);
                    displayMenu();
                    break;
                }
                case 6: {
                    validCh=true;
                    System.exit(0);}
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        } while (!validCh);
    }
    public static void saveIns(){
        Instructor.questionFile=Instructor.saveToFile(questionFile,questionBank);
        Instructor.examFile=Instructor.saveToFile(examFile,examList);
    }

    public static void loadIns(){
        Instructor.questionBank=Instructor.loadFromFile(questionFile,questionBank);
        Instructor.examList=Instructor.loadFromFile(examFile,examList);
    }
}
