import java.util.ArrayList;
import java.util.*;

class User {
    private String name;
    private int age;

    // Parameterized Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display User Information
    public void DisplayUser() {
        System.out.println("User Details");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}

// Parent Class
class StudyTask {
    protected String subject;
    protected int hours;

    // Constructor
    public StudyTask(String subject, int hours) {
        this.subject = subject;
        this.hours = hours;
    }

    // Method
    public void showTask() {
        System.out.println("Subject: " + subject);
        System.out.println("Hours: " + hours);
    }
}

// Child Class 1
class ExamTask extends StudyTask {
    private String examdate;

    public ExamTask(String subject, int hours, String examdate) {
        super(subject, hours);
        this.examdate = examdate;
    }

    @Override
    public void showTask() {
        System.out.println("Exam Task");
        System.out.println("Subject: " + subject);
        System.out.println("Hours: " + hours);
        System.out.println("Exam Date: " + examdate);
    }
}

// Child Class 2
class AssignmentTask extends StudyTask {
    private String submissiondate;

    public AssignmentTask(String subject, int hours, String submissiondate) {
        super(subject, hours);
        this.submissiondate = submissiondate;
    }

    @Override
    public void showTask() {
        System.out.println("Assignment Task");
        System.out.println("Subject: " + subject);
        System.out.println("Hours: " + hours);
        System.out.println("Submission Date: " + submissiondate);
    }
}

// Planner Class
class Planner {

    ArrayList<StudyTask> tasks = new ArrayList<>();

    // Add Task
    public void addTask(StudyTask task) {
        tasks.add(task);
        System.out.println("\nTask Added Successfully <3");
    }

    // Display All Tasks
    public void showTask() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo Task Added Yet!");
            return;
        }

        System.out.println("\nAll Tasks");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\nTask " + (i + 1));
            tasks.get(i).showTask();
        }
    }

    // Delete Task
    public void deletetask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("\nTask Deleted Successfully!");
        } else {
            System.out.println("\nInvalid Task Number!");
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        User u = new User(name, age);
        Planner p = new Planner();

        int choice;

        do {

            System.out.println("\n===== SMART STUDY PLANNER =====");
            System.out.println("1. Display User Info");
            System.out.println("2. Add Task for Exam");
            System.out.println("3. Add Task for Assignment");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Delete a Task");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    u.DisplayUser();
                    break;

                case 2:

                    System.out.print("Enter Subject: ");
                    String examsubject = sc.nextLine();

                    System.out.print("Enter Study Hours: ");
                    int examhours = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Exam Date: ");
                    String examdate = sc.nextLine();

                    StudyTask examtask = new ExamTask(examsubject, examhours, examdate);
                    p.addTask(examtask);
                    break;

                case 3:

                    System.out.print("Enter Subject: ");
                    String assignmentsubject = sc.nextLine();

                    System.out.print("Enter Study Hours: ");
                    int assignmenthours = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Submission Date: ");
                    String submissiondate = sc.nextLine();

                    StudyTask assignmenttask = new AssignmentTask(assignmentsubject, assignmenthours, submissiondate);
                    p.addTask(assignmenttask);
                    break;

                case 4:
                    p.showTask();
                    break;

                case 5:

                    p.showTask();

                    System.out.print("Enter Task Number to Delete: ");
                    int deleteno = sc.nextInt();

                    p.deletetask(deleteno - 1);
                    break;

                case 6:
                    System.out.println("\nThank You <3");
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}