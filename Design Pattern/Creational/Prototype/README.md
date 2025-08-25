### Example of Shallow Copy and Deep Copy

java```
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String subjectName;
    private List<String> requiredSubjects;

    public Course(String subjectName) {
        this.subjectName = subjectName;
        this.requiredSubjects = new ArrayList<>();
        // Let's add some default required subjects
        this.requiredSubjects.add("Introduction to " + subjectName);
        this.requiredSubjects.add(subjectName + " Fundamentals");
    }

    public void addSubject(String subject) {
        this.requiredSubjects.add(subject);
    }

    @Override
    public String toString() {
        return "Course[Subject: " + subjectName + ", Requirements: " + requiredSubjects + "]";
    }
}
```


java ```
public class Student implements Cloneable {
    private int studentId;
    private String studentName;
    private Course course; // Reference to a mutable object

    public Student(int studentId, String studentName, Course course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    // Setter for the course
    public void setCourse(Course course) {
        this.course = course;
    }
    
    // Getter for the course to modify it
    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student[ID: " + studentId + ", Name: " + studentName + "]\n" + course;
    }
    
    // --- CLONING IMPLEMENTATIONS ---

    /**
    * Performs a SHALLOW COPY.
    * The default clone() method creates a shallow copy.
    * It copies primitives field-by-field and references by copying the reference address.
    */
    public Object shallowCopyClone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
    * Performs a DEEP COPY.
    * We must manually handle the cloning of mutable objects.
    */
    public Object deepCopyClone() throws CloneNotSupportedException {
        // 1. Start with a shallow copy to get all the primitive fields copied.
        Student clonedStudent = (Student) super.clone();
        
        // 2. Now, manually create a new instance for our mutable 'Course' object.
        Course originalCourse = this.getCourse();
        Course clonedCourse = new Course(originalCourse.getSubjectName()); // Create a new Course object
        
        // Manually copy the list of subjects to the new course object
        for(String subject : originalCourse.getRequiredSubjects()) {
            clonedCourse.addSubject(subject);
        }

        // 3. Assign the newly created deep-copied Course to the cloned Student.
        clonedStudent.setCourse(clonedCourse);
        
        return clonedStudent;
    }
}
```


java```
public class CloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        // Original student record
        Course computerScience = new Course("Computer Science");
        Student originalStudent = new Student(101, "Alice", computerScience);

        System.out.println("--- ORIGINAL STUDENT RECORD ---");
        System.out.println(originalStudent);
        System.out.println("--------------------------------\n");
        
        // --- Scenario 1: Using Shallow Copy ---
        System.out.println("### SCENARIO 1: SHALLOW COPY ###");
        Student clonedStudentShallow = (Student) originalStudent.shallowCopyClone();
        clonedStudentShallow.setStudentId(102); // Change ID for the new record
        clonedStudentShallow.setStudentName("Alice (Provisional)");

        // Now, the provisional student needs an extra subject for their double major.
        // The clerk adds a new required subject to the cloned record's course.
        clonedStudentShallow.getCourse().addSubject("Advanced Algorithms");

        System.out.println("--- Cloned Student (Shallow) After Modification ---");
        System.out.println(clonedStudentShallow);
        System.out.println("\n--- Original Student Record AFTER Shallow Clone was Modified ---");
        System.out.println(originalStudent);
        System.out.println("PROBLEM: The original student's course now has 'Advanced Algorithms'!\n");

        // --- Scenario 2: Using Deep Copy ---
        System.out.println("### SCENARIO 2: DEEP COPY ###");
        
        // Reset the original student's course for a clean test
        computerScience = new Course("Computer Science");
        originalStudent = new Student(101, "Alice", computerScience);

        System.out.println("--- Original Student Record (Reset) ---");
        System.out.println(originalStudent);
        System.out.println();

        Student clonedStudentDeep = (Student) originalStudent.deepCopyClone();
        clonedStudentDeep.setStudentId(103);
        clonedStudentDeep.setStudentName("Alice (Second Major)");

        // Add the extra subject to the deep-copied student's course.
        clonedStudentDeep.getCourse().addSubject("Machine Learning");

        System.out.println("--- Cloned Student (Deep) After Modification ---");
        System.out.println(clonedStudentDeep);
        System.out.println("\n--- Original Student Record AFTER Deep Clone was Modified ---");
        System.out.println(originalStudent);
        System.out.println("SUCCESS: The original student's record is unchanged!");
    }
}
```