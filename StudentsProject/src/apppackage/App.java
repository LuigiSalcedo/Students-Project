package apppackage;

import java.io.IOException;
import java.util.ArrayList;
import studentspackage.StudentsManager;
import studentspackage.Student;

public class App 
{
    public static void main(String[] args) throws IOException 
    {
        float promedio = 0;
        float varianza = 0;
        ArrayList<Student> students = StudentsManager.getStudentsFromFile("data\\Taller_Estudiantes.csv");
        System.out.println("Número estudiantes de nivel tecnológico: " + StudentsManager.getNumberOfStudents(students, 1));
        System.out.println("Número estudiantes de nivel pregrado: " + StudentsManager.getNumberOfStudents(students, 2));
        System.out.println("Número estudiantes de nivel posgrado: " + StudentsManager.getNumberOfStudents(students, 3));
        System.out.println("\n-------------------------------\n");
        float [] arr = StudentsManager.getGenderPercentage(StudentsManager.filterStudents(students, 1));
        
        System.out.println("Número de estudiantes Hombres tecnológico: " + arr[0] + "%");
        System.out.println("Número de estudiantes Mujeres tecnológico: " + arr[1] + "%");
        
        System.out.println("\n");
        
        arr = StudentsManager.getGenderPercentage(StudentsManager.filterStudents(students, 2));
        
        System.out.println("Número de estudiantes Hombres pregrado: " + arr[0] + "%");
        System.out.println("Número de estudiantes Mujeres pregrado: " + arr[1] + "%");   
        
        System.out.println("\n");
        
        arr = StudentsManager.getGenderPercentage(StudentsManager.filterStudents(students, 3));
        
        System.out.println("Número de estudiantes Hombres posgrado: " + arr[0] + "%");
        System.out.println("Número de estudiantes Mujeres posgrado: " + arr[1] + "%");
        
        System.out.println("\n");
        
        System.out.println("\n-------------------------------\n");
        
        System.out.println("Porcentaje de estudiantes aprobados en tecnológico: " +
                           StudentsManager.getApproved(StudentsManager.filterStudents(students, 1), 1) + "%");
        System.out.println("Porcentaje de estudiantes aprobados en pregrado: " +
                           StudentsManager.getApproved(StudentsManager.filterStudents(students, 2), 2) + "%");
        System.out.println("Porcentaje de estudiantes aprobados en tecnológico: " +
                           StudentsManager.getApproved(StudentsManager.filterStudents(students, 3), 3) + "%");
        
        System.out.println("\n-------------------------------\n");
        for(int a = 1; a <= 3; a++)
        {
            promedio = 0;
            varianza = 0;
            for(int i = 0; i < StudentsManager.filterStudents(students, a).size(); i++)
            {
                promedio += StudentsManager.filterStudents(students, a).get(i).getGrade();
            }
            promedio /= StudentsManager.filterStudents(students, a).size();
            for(int i = 0; i < StudentsManager.filterStudents(students, a).size(); i++)
            {
                varianza += Math.pow(StudentsManager.filterStudents(students, a).get(i).getGrade() - promedio, 2);
            }
            varianza /= StudentsManager.filterStudents(students, a).size()-1;
            switch(a)
            {
                case 1:
                    System.out.println("Datos estudiantes tecnológico: "); break;
                case 2:
                    System.out.println("Datos estudiantes pregrado: "); break;
                case 3:
                    System.out.println("Datos estudiantes posgrado: "); break;
            }
            System.out.println("\nPromedio = " + promedio);
            System.out.println("Varianza = " + varianza);
            System.out.println("Desviación estándar = " + Math.sqrt(varianza));
            System.out.println("\n-------------------------------\n");
        }

    } 
}
