//Colby king module 11 assignment//

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonpaperExample {
    public static void main(String[] args) throws Exception {
        User user = new User("Colby", 25);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        System.out.println(json);
    }
}

class User {
    public String name;
    public int age;

    public User() {} // Default constructor needed for Jackson

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

