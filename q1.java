class Student {
    private int studentId;
    private String name;
    private int daysAttend;

    Student() {
        studentId = 0;
        name = null;
        daysAttend = 0;
    }

    Student(int studentId, String name, int daysAttend) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttend = daysAttend;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDaysAttend(int daysAttend) {
        this.daysAttend = daysAttend;
    }

    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getDaysAttend() {
        return daysAttend;
    }

}

class ClassRoom {
    int studentCount = 0;
    Student[] studentArray = new Student[10];

    public void addStudent(Student student) {
        if(studentCount < studentArray.length) {
            studentArray[studentCount++] = student;
        } else {
            System.out.println("Max students reached");
        }
    }

    public void updateAttendance(int studentId, int daysAttend) {
        boolean isFound = false;
        for(Student student : studentArray) {
            if(student != null) {
                if(student.getStudentId() == studentId) {
                    student.setDaysAttend(daysAttend);
                    isFound = true;
                    break;
                }
            }
        }
        if(!isFound) {
            System.out.println("Not found");
        }
    }

    public void displayDetails() {
        for(Student student : studentArray) {
            if(student != null) {
                System.out.println("Name : "+student.getName()+" Student ID : "+student.getStudentId()+" Attendance : "+student.getDaysAttend());
            }
        }
    }

}

class Demo {

    public static void main(String[] args) {

        ClassRoom classRoom = new ClassRoom();
        classRoom.addStudent(new Student(101, "Alice Smith", 12));
        classRoom.addStudent(new Student(102, "Bob Jones", 15));
        classRoom.addStudent(new Student(103, "Carol Lee", 10));

        classRoom.updateAttendance(102, 16);
        classRoom.updateAttendance(104, 5);

        classRoom.displayDetails();

    }
}

