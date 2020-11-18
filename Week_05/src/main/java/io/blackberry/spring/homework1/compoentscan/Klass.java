package io.blackberry.spring.homework1.compoentscan;

import java.util.List;

public class Klass {

    private List<Student> students;

    public Klass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
