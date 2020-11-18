package io.blackberry.spring.homework2;

import io.blackberry.spring.homework1.xml.Klass;
import io.blackberry.spring.homework1.xml.School;
import io.blackberry.spring.homework1.xml.Student;

@Configuration
@ConditionalOnClass(School.class)
public class AutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    School school() {
        return new School();
    }

    @Bean
    @ConditionalOnMissingBean
    Student student() {
        return new Student();
    }

    @Bean
    @ConditionalOnMissingBean
    Klass class1() {
        return new Klass();
    }
}