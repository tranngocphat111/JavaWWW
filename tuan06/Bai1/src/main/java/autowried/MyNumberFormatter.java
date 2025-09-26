package autowried;

import org.springframework.stereotype.Component;

@Component
public class MyNumberFormatter {
    public String format(double number){
        return "Number format: " + number;
    }
}
