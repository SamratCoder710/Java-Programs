package com.coder.sanam.ClassRelationships;




    //Association: Association represents a "uses-a" or "works-with" relationship between classes.
    //Example: A Teacher works in a School.

    class School {
        private String name;
        public School(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public String associatedTeacher(Teacher teacher) {
            return teacher.getName() + " works in " + this.name;
        }
        public String toString() {
            return name;
        }
    }

    class Teacher {
        private String name;
        public Teacher(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

public class AssociationRelationship {
    public static void main(String[] args) {
        School school = new School("Sausar");
        Teacher teacher = new Teacher("Shraddha");
        System.out.println(school.associatedTeacher(teacher));
    }
}
