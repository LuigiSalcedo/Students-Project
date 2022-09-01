package studentspackage;

import java.util.ArrayList;
import java.io.*;

public class StudentsManager 
{
    private static Student stringToStudent(String line)
    {
        Student aux = new Student();
        String [] data = line.split(";");
        aux.setID(Integer.parseInt(data[0]));
        aux.setLastName(data[1]);
        aux.setFirstName(data[2]);
        aux.setGender(data[3]);
        aux.setGrade(Float.parseFloat(data[4]));
        aux.setType(Integer.parseInt(data[5]));
        return aux;
    }
    
    public static ArrayList<Student> getStudentsFromFile(String path) throws IOException
    {
        ArrayList<Student> students = new ArrayList();
        try
        {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while((line=br.readLine()) != null)
            {
                students.add(stringToStudent(line));
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: " + e);
        }
        return students;
    }
    
    public static ArrayList<Student> filterStudents(ArrayList<Student> students, int type)
    {
        ArrayList<Student> result = new ArrayList();
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getType() == type)
            {
                result.add(students.get(i));
            }
        }
        return result;
    }
    
    public static int getNumberOfStudents(ArrayList<Student> students, int type)
    {
        ArrayList<Student> aux = filterStudents(students, type);
        return aux.size();
    }
    
    public static float getPercentage(ArrayList<Student> students, int type)
    {
        int num = 0;
        float p;
        for(Student i: students)
        {
            if(i.getType() == type)
            {
                num++;
            }
        }
        return (num/students.size())*100;
    }
    
    public static float [] getGenderPercentage(ArrayList<Student> students)
    {
        float [] result = new float[2];
        for(int i = 0; i < students.size(); i++)
        {
            if("Male".equals(students.get(i).getGender())) result[0]++;
            else result[1]++;
        }
        result[0] /= students.size();
        result[0] *= 100;
        result[1] /= students.size();
        result[1] *= 100;
        return result;
    }
    
    public static float getApproved(ArrayList<Student> students, int x)
    {
        ArrayList<Student> aux = filterStudents(students, x);
        return x == 3 ? getSuperApproved(aux) : getOtherApproved(aux);
    }
    
    private static float getOtherApproved(ArrayList<Student> students)
    {
        float result = 0;
        for(Student i : students)
        {
            if(i.getGrade() >= 3.0f) result++;
        }
        return (result/students.size() * 100);
    }
    
    private static float getSuperApproved(ArrayList<Student> students)
    {
        float result = 0;
        for(Student i : students)
        {
            if(i.getGrade() >= 3.5f) result++;
        }
        return (result/students.size()) * 100;
    }
}
