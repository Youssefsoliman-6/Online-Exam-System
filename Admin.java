package OnlineExam;

import java.lang.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
public class Admin extends User {
    protected static Admin[] admins= new Admin[2];
    private static ArrayList<Student> studentsList= new ArrayList<>();
    protected static File studentsFile =new File("studentsFile.bin");
    private static ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();
    protected static File instructorsFile = new File("instructorsFile.bin");
    private static HashMap<Exam,Date> examSchedule=new HashMap<>();
    protected static File examScheduleFile = new File("examScheduleFile.bin");

    public Admin() {
        this.setUserType(UserType.Admin);
    }
    public Admin(int userId, String userName,String password) {
        this.setUserType(UserType.Admin) ;
        this.setUserId(userId) ;
        this.setUserName(userName);
        this.setPassword(password);
    }

    public static ArrayList<Student> getStudentsList() {return studentsList;}
    public static void setStudentsList(ArrayList<Student> studentsList) {Admin.studentsList = studentsList;}
    public static ArrayList<Instructor> getInstructorsList() {return instructorsList;}
    public static void setInstructorsList(ArrayList<Instructor> instructorsList) {Admin.instructorsList = instructorsList;}
    public static HashMap<Exam, Date> getExamSchedule() {return examSchedule;}
    public static void setExamSchedule(HashMap<Exam, Date> examSchedule) {Admin.examSchedule = examSchedule;}

    public static void listExams(){
        for(Exam exam:Instructor.getExamList()){
            System.out.println(exam);
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void viewExamSchedule(){
        for(Map.Entry<Exam,Date> entry: Admin.getExamSchedule().entrySet()){
            System.out.println(entry.getKey()+"   "+entry.getValue());
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println();

        }
    }

    public void listStudents(){
        for(Student s: Admin.getStudentsList()){
            System.out.println(s);
        }
    }

    public void removeStudent(int Id){
        boolean exists = false;
        for(Student s: Admin.getStudentsList()){
            if(s.getUserId() == Id){
                exists = true;
                Admin.getStudentsList().remove(s);
                break;
            }
        }
        if(exists)
            System.out.println("Student removed successfully");
        else System.out.println("Student not found");
    }

    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        int Id;
        boolean exists = false;
        do{
            System.out.println("Enter Student Id: ");
            Id = sc.nextInt();
            for(Student s: Admin.getStudentsList()){
                if(s.getUserId() == Id){
                exists = true;
                System.out.println("Student ID already exists ");
                }else exists = false;
            }
        }while(exists);
        System.out.println("Enter Student Name: ");
        String Name = sc.next();
        System.out.println("Enter Student Password: ");
        String Password = sc.next();
        Student student = new Student(Id,Name,Password);
        Admin.getStudentsList().add(student);
        System.out.println("Student added successfully");
    }

    public String toString() {
        return this.getUserType()+": "+this.getUserId()+"\t"+this.getUserName()+"\t";
    }

    public void editUser(int userId, UserType userType, String fieldToEdit, Object newValue) {
        switch (userType) {
            case Admin:
                for (Admin admin : admins) {
                    if (admin.getUserId() == userId) {
                        editField(admin, fieldToEdit, newValue);
                        System.out.println("Admin user updated successfully.");
                        return;
                    }
                }
                System.out.println("Admin with ID " + userId + " not found.");
                break;

            case Instructor:
                for (Instructor instructor : instructorsList) {
                    if (instructor.getUserId() == userId) {
                        editField(instructor, fieldToEdit, newValue);
                        System.out.println("Instructor user updated successfully.");
                        return;
                    }
                }
                System.out.println("Instructor with ID " + userId + " not found.");
                break;

            case Student:
                for (Student student : studentsList) {
                    if (student.getUserId() == userId) {
                        editField(student, fieldToEdit, newValue);
                        System.out.println("Student user updated successfully.");
                        return;
                    }
                }
                System.out.println("Student with ID " + userId + " not found.");
                break;

            default:
                System.out.println("Invalid user type.");
        }
    }

    private void editField(User user, String fieldToEdit, Object newValue) {
        try {
            // Get the field dynamically using reflection
            Field field = user.getClass().getDeclaredField(fieldToEdit);
            field.setAccessible(true); // Allow access to private fields

            // Check if the new value type matches the field type
            if (!field.getType().isAssignableFrom(newValue.getClass())) {
                System.out.println("Type mismatch: The field '" + fieldToEdit + "' expects a "
                        + field.getType().getSimpleName() + ", but received a "
                        + newValue.getClass().getSimpleName() + ".");
                return;
            }

            // Set the new value for the field
            field.set(user, newValue);
            System.out.println("Field '" + fieldToEdit + "' updated successfully.");

        } catch (NoSuchFieldException e) {
            System.out.println("Field " + fieldToEdit + " does not exist in the user class.");
        } catch (IllegalAccessException e) {
            System.out.println("Failed to access field " + fieldToEdit + " in the user class.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument passed for field " + fieldToEdit + ": " + e.getMessage());
        }
    }


    @Override
    public void displayMenu() {
        System.out.println("1. List Students");
        System.out.println("2. Add Student");
        System.out.println("3. Remove Student");
        System.out.println("4. List Exams");
        System.out.println("5. View Exam Schedule");
        System.out.println("6. Exit");
         Scanner sc = new Scanner(System.in);
        boolean validCh= false;
         do{
             System.out.println("Enter your choice: ");
             int choice = sc.nextInt();

         switch (choice) {
             case 1:{
                 validCh = true;
                 listStudents();
                 break;
             }
             case 2:{
                 validCh = true;
                 addStudent();
                 break;
             }
             case 3:{
                 validCh = true;
                 System.out.println("Enter Student Id: ");
                 int Id = sc.nextInt();
                 removeStudent(Id);
                 break;
             }
             case 4:{
                 validCh = true;
                 listExams();
                 break;
             }
             case 5:{
                 validCh = true;
                 viewExamSchedule();
                 break;
             }
             case 6:{
                 validCh = true;
                 System.exit(0);
             }
             default:
                 System.out.println("Invalid choice");
         }

    }while(!validCh);
    }

    public static void saveAd(){
        Admin.studentsFile=Admin.saveToFile(studentsFile,studentsList);
        Admin.instructorsFile=Admin.saveToFile(instructorsFile,instructorsList);
        Admin.examScheduleFile=Admin.saveToFile(examScheduleFile,examSchedule);
    }

    public static void loadAd(){
        Admin.studentsList=Admin.loadFromFile(studentsFile,studentsList);
        Admin.instructorsList=Admin.loadFromFile(instructorsFile,instructorsList);
        Admin.examSchedule=Admin.loadFromFile(examScheduleFile,examSchedule);
    }
}
