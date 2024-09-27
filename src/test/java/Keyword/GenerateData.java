package Keyword;
import com.github.javafaker.Faker;
import java.util.Random;

public class GenerateData {
    Faker faker = new Faker();

    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String phoneNumber(String prefix) {
        Random random = new Random();
        return prefix + (10000000 + random.nextInt(90000000));
    }

    public String subject(){
        return faker.book().title();
    }
}
