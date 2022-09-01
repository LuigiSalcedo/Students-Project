package studentspackage;

public class Student 
{
    // Atributos
    private int ID;
    private String lastName;
    private String firstName;
    private String gender;
    private float grade;
    private int type;
    
    // Construtor
    public Student()
    {
        // Constructo nulo
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setType(int type) {
        this.type = type;
    }

    // Getters
    public int getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public float getGrade() {
        return grade;
    }

    public int getType() {
        return type;
    }
}
