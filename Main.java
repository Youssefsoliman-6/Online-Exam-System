
package OnlineExam;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void saveAllData() {
        Question q1 = new Question(1, "What is the capital city of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris", Subject.GEOGRAPHY, 1.5);

        Question q2 = new Question(2, "What is 5 + 7?",
                new String[]{"10", "11", "12", "13"}, "12", Subject.MATH, 2.0);

        Question q3 = new Question(3, "What planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Mars", Subject.SCIENCE, 2.5);

        Question q4 = new Question(4, "What is the largest desert in the world?",
                new String[]{"Sahara", "Gobi", "Kalahari", "Antarctic"}, "Antarctic", Subject.GEOGRAPHY, 1.0);

        Question q5 = new Question(5, "What is the square root of 64?",
                new String[]{"6", "7", "8", "9"}, "8", Subject.MATH, 1.5);

        Question q6 = new Question(6, "What gas do plants primarily use for photosynthesis?",
                new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"}, "Carbon Dioxide", Subject.SCIENCE, 2.0);

        Question q7 = new Question(7, "Which continent has the most countries?",
                new String[]{"Africa", "Asia", "Europe", "South America"}, "Africa", Subject.GEOGRAPHY, 2.5);

        Question q8 = new Question(8, "What is the value of pi to 2 decimal places?",
                new String[]{"3.12", "3.14", "3.15", "3.16"}, "3.14", Subject.MATH, 1.0);

        Question q9 = new Question(9, "What is the chemical symbol for gold?",
                new String[]{"Au", "Ag", "Fe", "Pb"}, "Au", Subject.SCIENCE, 1.5);

        Question q10 = new Question(10, "What is the longest river in the world?",
                new String[]{"Amazon", "Nile", "Yangtze", "Mississippi"}, "Nile", Subject.GEOGRAPHY, 2.0);

        Question q11 = new Question(11, "What is 9 x 8?",
                new String[]{"72", "81", "64", "69"}, "72", Subject.MATH, 2.5);

        Question q12 = new Question(12, "What is the main gas in the Earth's atmosphere?",
                new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Helium"}, "Nitrogen", Subject.SCIENCE, 1.0);

        Question q13 = new Question(13, "Which ocean is the largest?",
                new String[]{"Atlantic", "Pacific", "Indian", "Arctic"}, "Pacific", Subject.GEOGRAPHY, 1.5);

        Question q14 = new Question(14, "What is the factorial of 5?",
                new String[]{"20", "60", "120", "24"}, "120", Subject.MATH, 2.0);

        Question q15 = new Question(15, "What organ is responsible for pumping blood?",
                new String[]{"Brain", "Heart", "Lungs", "Liver"}, "Heart", Subject.SCIENCE, 2.5);

        Question q16 = new Question(16, "What is the smallest country in the world?",
                new String[]{"Monaco", "Malta", "Vatican City", "Liechtenstein"}, "Vatican City", Subject.GEOGRAPHY, 1.0);

        Question q17 = new Question(17, "What is the derivative of x^2?",
                new String[]{"x", "2x", "x^2", "2"}, "2x", Subject.MATH, 1.5);

        Question q18 = new Question(18, "What is the chemical formula for water?",
                new String[]{"H2O", "CO2", "O2", "HO2"}, "H2O", Subject.SCIENCE, 2.0);

        Question q19 = new Question(19, "What is the highest mountain in the world?",
                new String[]{"K2", "Everest", "Kilimanjaro", "Denali"}, "Everest", Subject.GEOGRAPHY, 2.5);

        Question q20 = new Question(20, "What is 15% of 200?",
                new String[]{"25", "30", "35", "40"}, "30", Subject.MATH, 1.0);

        Question q21 = new Question(21, "What is the powerhouse of the cell?",
                new String[]{"Nucleus", "Ribosome", "Mitochondria", "Cytoplasm"}, "Mitochondria", Subject.SCIENCE, 1.5);

        Question q22 = new Question(22, "Which country is known as the Land of the Rising Sun?",
                new String[]{"India", "China", "Japan", "Thailand"}, "Japan", Subject.GEOGRAPHY, 2.0);

        Question q23 = new Question(23, "What is 2 to the power of 5?",
                new String[]{"16", "32", "64", "128"}, "32", Subject.MATH, 2.5);

        Question q24 = new Question(24, "What is the chemical symbol for sodium?",
                new String[]{"Na", "S", "N", "Sa"}, "Na", Subject.SCIENCE, 1.0);

        Question q25 = new Question(25, "Which continent is the Sahara Desert located on?",
                new String[]{"Asia", "Africa", "South America", "Australia"}, "Africa", Subject.GEOGRAPHY, 1.5);

        Question q26 = new Question(26, "What is the perimeter of a rectangle with length 5 and width 3?",
                new String[]{"15", "16", "18", "20"}, "16", Subject.MATH, 2.0);

        Question q27 = new Question(27, "What is the primary element found in the sun?",
                new String[]{"Oxygen", "Carbon", "Hydrogen", "Helium"}, "Hydrogen", Subject.SCIENCE, 2.5);

        Question q28 = new Question(28, "What is the largest island in the world?",
                new String[]{"Greenland", "Australia", "Madagascar", "Borneo"}, "Greenland", Subject.GEOGRAPHY, 1.0);

        Question q29 = new Question(29, "What is the result of 7 mod 3?",
                new String[]{"1", "2", "3", "0"}, "1", Subject.MATH, 1.5);

        Question q30 = new Question(30, "What is the boiling point of water in Celsius?",
                new String[]{"50", "100", "150", "200"}, "100", Subject.SCIENCE, 2.0);


        Student student1 = new Student(2221, "Student1", "student1Pass");
        Student student2 = new Student(2222, "Student2", "student2Pass");
        Student student3 = new Student(2223, "Student3", "student3Pass");
        Student student4 = new Student(2224, "Student4", "student4Pass");
        Student student5 = new Student(2225, "Student5", "student5Pass");


        Instructor instructor1 = new Instructor(3331, "Instructor1", "instructor1Pass");
        Instructor instructor2 = new Instructor(3332, "Instructor2", "instructor2Pass");


    }

    public static void main(String[] args) {

        Admin admin1 = new Admin(1111, "Admin1", "admin1Pass");
        Admin admin2 = new Admin(1112, "Admin2", "admin2Pass");
        Admin.admins[0] = admin1;
        Admin.admins[1] = admin2;


        String userName;
        String password;


        System.out.println("Choose User Type: ");
        System.out.println("1. Admin");
        System.out.println("2. Instructor");
        System.out.println("3. Student");

        Scanner in = new Scanner(System.in);
        UserType type = null;
        int choice = in.nextInt();
        do {
            try {
                switch (choice) {
                    case 1:
                        type = UserType.Admin;
                        break;
                    case 2:
                        type = UserType.Instructor;
                        break;
                    case 3:
                        type = UserType.Student;
                        break;
                    default:
                        type = null;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a valid user type (Number From 1-3): ");
            }
        } while (type == null);


        type = UserType.Instructor;
        System.out.println("Enter User Name: ");
        userName = in.next();
        //userName = "Instructor1";

        System.out.println("Enter Password: ");
        password = in.next();
        //password = "instructor1Pass";


        User user = User.logIn(userName, password, type);

        try {
            if (user != null) {
                user.displayMenu();
            }
        } catch (NullPointerException npe) {
            System.out.println("User not found");
        }
    }
}

