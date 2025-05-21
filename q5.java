class Student {
    String name;
    int exam1;
    int exam2;
    int exam3;

    boolean marksValidator(int marks) {
        if(marks > 100 || marks < 0) {
            return false;
        } else {
            return true;
        }
    }

    Student() {

    }
    Student(String name, int exam1, int exam2, int exam3) throws IllegalArgumentException{
        if(marksValidator(exam1) && marksValidator(exam2) && marksValidator(exam3)) {
            this.name = name;
            this.exam1 = exam1;
            this.exam2 = exam2;
            this.exam3 = exam3;
        } else {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100");
        }
    }

    public String getName() {
        return name;
    }
    public int getExam1() {
        return exam1;
    }
    public int getExam2() {
        return exam2;
    }
    public int getExam3() {
        return exam3;
    }

    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / (double)3;
    }
}

class Demo {

    public static void main(String[] args) {
        try {
            Student student = new Student("John", 75, 110, 90);
            System.out.print(student.getName()+" : ");
            System.out.printf("%.2f\n", student.calculateAverage());
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}