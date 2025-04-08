package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);
    Car car1 = new Car("BMW", 7);
    User user1 = new User("Ivan", "Ivanov", "user1@mail.ru");
    user1.setCar(car1);
    car1.setOwner(user1);
    userService.add(user1);

    Car car2 = new Car("Mazda", 6);
    User user2 = new User("Serofim", "Morkva", "user2@mail.ru");
    user2.setCar(car2);
    car2.setOwner(user2);
    userService.add(user2);

    Car car3 = new Car("Mercedes", 68);
    User user3 = new User("Nick", "Maers", "user3@mail.ru");
    user3.setCar(car3);
    car3.setOwner(user3);
    userService.add(user3);

    Car car4 = new Car("Vaz", 14);
    User user4 = new User("Izy", "Kamushkin", "user4@mail.ru");
    user3.setCar(car4);
    car3.setOwner(user4);
    userService.add(user4);

    List<User> users = userService.listUsers();
    for (User user : users) {
      if (user.getCar() != null) {
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());
        System.out.println("Car Model = " + user.getCar().getModel());
        System.out.println("Car Series = " + user.getCar().getSeries());
      }
    }
  }
}
