import java.util.ArrayList;

public class Q1_20200808058 {
    public static void main(String[] args){
        ArrayList<String> lecturersCourse = new ArrayList<>();
        lecturersCourse.add("Television Programming");
        Lecturers lecturers =new Lecturers("Berkecan","Ercükler","RA",lecturersCourse);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Integer> notes = new ArrayList<>();
        Course course = new Course("Television Programming",lecturers,students,notes);
        for(int i = 0; i < notes.size();i++ ){
            notes.add((int)(Math.random()));
        }
        for(int i = 0; i < notes.size();i++ ){
            notes.add();
        }
    }
}
class Course{
    private String name;
    private Lecturers lecturers;
    private ArrayList<Student> student;
    private ArrayList<Integer> studentNotes;
    Course(){
    }
    Course(String name,Lecturers lecturers,ArrayList<Student> student,ArrayList<Integer> studentNotes){
        this.name = name;
        this.lecturers = lecturers;
        this.student=student;
        this.studentNotes=studentNotes;
    }

    public String getName() {
        return name;
    }

    public Lecturers getLecturers() {
        return lecturers;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLecturers(Lecturers lecturers) {
        this.lecturers = lecturers;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }
}
class Lecturers extends  Course{
    private String name;
    private String surname;
    private String title;
    private ArrayList<String> course;
    Lecturers(String name,String surname,String title,ArrayList<String> course){
        super();
        this.name=name;
        this.surname=surname;
        this.title=title;
        this.course=course;
    }
    public ArrayList<String> addCourse(ArrayList<String> course,String newCourse){
        course.add(newCourse);
        return course;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Lecturers getLecturers() {
        return super.getLecturers();
    }

    @Override
    public ArrayList<Student> getStudent() {
        return super.getStudent();
    }

    public ArrayList<String> getCourse() {
        return course;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLecturers(Lecturers lecturers) {
        super.setLecturers(lecturers);
    }

    @Override
    public void setStudent(ArrayList<Student> student) {
        super.setStudent(student);
    }

    public void setCourse(ArrayList<String> course) {
        this.course = course;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
class Student extends Course{
    private String name;
    private String surname;
    private ArrayList<String> course;
    double midtermNote;
    double finalNote;
    double averageNote;
    int studentNumber;
    Student(String name, String surname, ArrayList<String> course,double midtermNote,double finalNote){
        super();
        this.name=name;
        this.surname=surname;
        this.course=course;
        this.midtermNote=midtermNote;
        this.finalNote = finalNote;
        this.studentNumber =  (int)(Math.random());
    }
    public double getAverageNote(double midtermNote,double finalNote){
        this.averageNote = (midtermNote + finalNote) / 2;
        return this.averageNote;
    }
    public String passedFailed(double midtermNote,double finalNote){
        if(this.averageNote >= 60)
            return "Passed";
        else
            return "Failed";
    }
    public ArrayList<String> addCourse(ArrayList<String> course,String newCourse){

        course.add(newCourse);
        return course;
    }

}
