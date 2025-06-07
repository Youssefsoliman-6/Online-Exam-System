package OnlineExam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class User implements Serializable {

   private int userId;
   private String userName;
   private String password;
   private UserType userType;

   public void setUserId(int userId) {this.userId = userId;}
   public void setUserName(String userName) {this.userName = userName;}
   public void setPassword(String password) {this.password = password;}
   public void setUserType(UserType userType) {this.userType = userType;}
   public int getUserId() {return userId;}
   public String getUserName() {return userName;}
   public String getPassword() {return password;}
   public UserType getUserType() {return userType;}

   public abstract void displayMenu();

   public static User logIn(String userName, String Password, UserType userType) {

      if (userType == UserType.Student) {
         for (Student s : Admin.getStudentsList()) {
            if (s.getUserName().equals(userName) && s.getPassword().equals(Password)) {
               System.out.println("Login successful");
               return s;
            }else {
               System.out.println("Login failed");
               return null;
            }
         }
      } else if (userType == UserType.Instructor) {
         for (Instructor i : Admin.getInstructorsList()) {
            if (i.getUserName().equals(userName) && i.getPassword().equals(Password)) {
               System.out.println("Login successful");
               return i;
            }else {
               System.out.println("Login failed");
               return null;
            }
         }
      } else if (userType == UserType.Admin) {
         for (Admin a : Admin.admins) {
            if (a.getUserName().equals(userName) && a.getPassword().equals(Password)) {
               System.out.println("Login successful");
               return a;
            }else {
               System.out.println("Login failed");
               return null;
            }
         }
      }
      return null;
   }
   public static <T> File saveToFile(File file, ArrayList<T> list) {
      try {
         FileOutputStream fo = new FileOutputStream(file);
         ObjectOutputStream o = new ObjectOutputStream(fo);

         o.writeObject(list);
         o.close();
         fo.close();
      } catch (FileNotFoundException fnf) {
         System.out.println("File Not Found!!!");
      } catch (IOException ioe) {
         System.out.println("Error Initializing stream");
      }
      return file;
   }

   public static <T,K> File saveToFile(File file, HashMap<T,K> map) {
      try {
         FileOutputStream fo = new FileOutputStream(file);
         ObjectOutputStream o = new ObjectOutputStream(fo);

         o.writeObject(map);
         o.close();
         fo.close();
      } catch (FileNotFoundException fnf) {
         System.out.println("File Not Found!!!");
      } catch (IOException ioe) {
         System.out.println("Error Initializing stream");
      }
      return file;
   }


   public static <T> ArrayList<T> loadFromFile(File file, ArrayList<T> list){
      try {
         FileInputStream fi = new FileInputStream(file);
         ObjectInputStream i = new ObjectInputStream(fi);

         list= (ArrayList<T>) i.readObject();
         i.close();
         fi.close();
      } catch (ClassNotFoundException cnf) {
         System.out.println("Class Not Found!!!");
      } catch (IOException ioe) {
         System.out.println("Error Initializing stream");
      }
      return list;
   }

   public static <T,K> HashMap<T,K> loadFromFile(File file, HashMap<T,K> map){
      try {
         FileInputStream fi = new FileInputStream(file);
         ObjectInputStream i = new ObjectInputStream(fi);

         map = (HashMap<T, K>) i.readObject();
         i.close();
         fi.close();
      } catch (ClassNotFoundException cnf) {
         System.out.println("Class Not Found!!!");
      } catch (IOException ioe) {
         System.out.println("Error Initializing stream");
      }
      return map;
   }

}
