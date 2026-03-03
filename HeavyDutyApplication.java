import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"."})
public class HeavyDutyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeavyDutyApplication.class, args);
    }
}
