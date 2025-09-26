import enities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Main {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student1 = context.getBean("student", Student.class);
//        System.out.println(student1);

//        Student student2 = context.getBean("student2", Student.class);
//        System.out.println(student2);
//
//        Student student3 = context.getBean("student3", Student.class);
//        System.out.println(student3);


//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);

//        Class_ class_ = context.getBean("class2", Class_.class);
//        System.out.println(class_);

//        Department department = context.getBean("dept3", Department.class);
//        System.out.println(department);

//        User user = context.getBean(User.class);
//        Group group = context.getBean(Group.class);
//
//        System.out.println(user);

        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
