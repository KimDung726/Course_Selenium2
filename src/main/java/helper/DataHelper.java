package helper;

import com.github.javafaker.Faker;

public class DataHelper {

    public static Faker faker = new Faker();

    public static String getRandomTitle() {
        return faker.letterify("?????? ????");
    }

    public static String getRandomEmail() {
        return faker.bothify("?????##@gmail.com");
    }

    public static String getRandomWebUrl() {
        return faker.internet().url();
    }

}
