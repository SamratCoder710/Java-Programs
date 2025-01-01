package com.coder.sanam.ClassRelationships;

    //Aggregation
    //Aggregation is a special form of association. It is a relationship between two classes like association,
    // however its a directional association, which means it is strictly a one way association.
    //It represents a whole-part relationship. In Aggregation, both the entries can survive individually which means ending one entity will not effect the other entity. For example, Department and Teacher, delete the department and teachers will not loose their identity.



import java.util.ArrayList;
import java.util.List;

class Employee {
        String name;
        int id;
        Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    class Department {
        String name;
        List<Employee> employees = new ArrayList<>();
        Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public void showEmployees() {
            for (Employee e : employees) {
                System.out.println(e.name + " " + e.id);
            }
        }

    }

public class AggregationRelationship {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sanam", 1);
        Employee e2 = new Employee("Sita", 2);
        Employee e3 = new Employee("Gita", 3);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        Department department = new Department("IT", employees);
        department.showEmployees();
    }
}
