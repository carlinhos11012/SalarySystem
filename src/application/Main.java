package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static List<Employee> createList(int lenght){
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        for(int i = 0; i < lenght; i++){
            System.out.println("Employee #"+(i+1));
            System.out.println("Id: ");
            int id = sc.nextInt();
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();
            list.add(new Employee(id,name,salary));
            System.out.println();
        }
        return list;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("How many employees will be registered?");
        int lenght = sc.nextInt();
        System.out.println();
        List<Employee> list = createList(lenght);

        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Employee increasedEmployee = list.stream().filter(x -> x.getId()==id).findAny().orElse(null);
        if(increasedEmployee == null){
            System.out.println("This id does not exist\n");
        }else{
            System.out.println("Enter the percentage: ");
            double percentage = sc.nextDouble();
            increasedEmployee.increaseSalary(percentage);
            System.out.println();
        }

        System.out.println("List of Employees:");
        for(Employee e : list){
            System.out.printf("%d, %s, %.2f%n",e.getId(), e.getName(), e.getSalary());
        }
    }
}