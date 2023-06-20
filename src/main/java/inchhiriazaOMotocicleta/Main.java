package inchhiriazaOMotocicleta;

import inchhiriazaOMotocicleta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void initUsers() {
        userService.createUser("admin", "admin", "ROLE_ADMIN", "Rolando", "Baran", "Rolphoe@gmail.com", "Piata Victoriei 2");
        userService.createUser("client", "client", "ROLE_USER", "Stefan", "Barbu", "BaStefan@gmail.com", "Universitate 23");
    }
}