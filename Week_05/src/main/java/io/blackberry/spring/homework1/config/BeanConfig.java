package io.blackberry.spring.homework1.config;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Klass class1() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "张三"));
        return new Klass(students);
    }

    @Bean
    public School school() {
        return new School(class1(), new Student(1, "张三"));
    }
}
