package autowried;

import enities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("autowried")
public class AppConfig {
    private static ApplicationContext context;

    public static void main(String[] args) {
//        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = context.getBean("user", User.class);
//        System.out.println(user);

        context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyNumberFormatterService service = context.getBean(MyNumberFormatterService.class
        );
        service.printFormat(1000d);
    }
}
