package uz.spring.book_project;

import uz.spring.book_project.entity.User;

public class Main {

    public static void main(String[] args) {

        User user = User.childBuilder()

                .build();

    }
}
