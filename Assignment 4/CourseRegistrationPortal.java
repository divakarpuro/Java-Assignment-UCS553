
import java.util.*;

class Course {
    String code;
    String name;
    int capacity;
    HashSet<String> students = new HashSet<>();
    ArrayList<String> prerequisites = new ArrayList<>();
    LinkedList<String> waitlist = new LinkedList<>();

    Course(String code, String name, int capacity, ArrayList<String> prerequisites) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
    }
}

public class CourseRegistrationPortal {
    HashMap<String, Course> courses = new HashMap<>();
    HashMap<String, HashSet<String>> completed = new HashMap<>();

    void addCourse(Course c) {
        courses.put(c.code, c);
    }

    void completeCourse(String student, String code) {
        completed.putIfAbsent(student, new HashSet<>());
        completed.get(student).add(code);
    }

    boolean checkPrerequisites(String student, Course c) {
        HashSet<String> done = completed.getOrDefault(student, new HashSet<>());
        return done.containsAll(c.prerequisites);
    }

    void register(String student, String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        if (c.students.contains(student)) {
            System.out.println("Student already registered.");
            return;
        }

        if (c.waitlist.contains(student)) {
            System.out.println("Student is already on the waitlist.");
            return;
        }

        if (!checkPrerequisites(student, c)) {
            System.out.println("Prerequisites not completed.");
            return;
        }

        if (c.students.size() < c.capacity) {
            c.students.add(student);
            System.out.println(student + " registered in " + code);
        } else {
            c.waitlist.addLast(student);
            System.out.println(student + " added to waitlist.");
        }
    }

    void dropCourse(String student, String code) {
        Course c = courses.get(code);

        if (c == null || !c.students.remove(student)) {
            System.out.println("Student is not registered.");
            return;
        }

        System.out.println(student + " dropped " + code);

        if (!c.waitlist.isEmpty()) {
            String next = c.waitlist.peekFirst();

            if (checkPrerequisites(next, c)) {
                c.waitlist.removeFirst();
                c.students.add(next);
                System.out.println(next + " promoted from waitlist.");
            }
        }
    }

    void displayCourse(String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Course: " + c.name);
        System.out.println("Code: " + c.code);
        System.out.println("Capacity: " + c.capacity);
        System.out.println("Prerequisites: " + c.prerequisites);
        System.out.println("Enrolled students: " + c.students);
        System.out.println("Waitlist: " + c.waitlist);
    }

    public static void main(String[] args) {
        CourseRegistrationPortal p = new CourseRegistrationPortal();

        p.addCourse(new Course("CS101", "Java Programming", 2,
                new ArrayList<>()));

        ArrayList<String> prereq = new ArrayList<>();
        prereq.add("CS101");

        p.addCourse(new Course("CS201", "Advanced Java", 2, prereq));

        p.completeCourse("S1", "CS101");
        p.completeCourse("S2", "CS101");
        p.completeCourse("S3", "CS101");

        p.register("S1", "CS201");
        p.register("S2", "CS201");
        p.register("S3", "CS201");

        p.displayCourse("CS201");

        System.out.println("\nDropping a course:");
        p.dropCourse("S1", "CS201");

        p.displayCourse("CS201");
    }
}
