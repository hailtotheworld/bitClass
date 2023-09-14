package hello.springmvc.basic;

import lombok.Data;

@Data
public class HelloData {

    private String username;
    private int age;

    public HelloData() {
    }

    public HelloData(String username, int age) {
        this.username = username;
        this.age = age;
    }


}
