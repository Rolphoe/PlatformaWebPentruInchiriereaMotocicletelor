package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.mapper.UserMapper;
import inchhiriazaOMotocicleta.model.user.*;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateColorVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateMileageVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdatePriceVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateStatusVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public boolean createUser(String username, String password, String role, String firstName, String lastName, String email, String address) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            System.out.println("User with username: " + username + " already exists.");
            return false;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAddress(address);

            userRepository.save(user);
            return true;
        }
    }

    public List<UserDetails> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public User editUser(int id, String username, String password, String role, String firstName, String lastName, String email, String address) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAddress(address);

            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("Nu a fost găsit niciun utilizator cu acest ID!");
        }
    }
    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nu a fost găsit niciun utilizator!"));
    }

    public void updateUsername(Integer id, RequestUpdateUsernameUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setUsername(request.getUsername());
        userRepository.save(user);
    }

    public void updateFirstName(Integer id, RequestUpdateFirstNameUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setFirstName(request.getFirstName());
        userRepository.save(user);
    }

    public void updateRole(Integer id, RequestUpdateRoleUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setRole(request.getRole());
        userRepository.save(user);
    }

    public void updateLastName(Integer id, RequestUpdateLastNameUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setLastName(request.getLastName());
        userRepository.save(user);
    }

    public void updateEmail(Integer id, RequestUpdateEmailUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }

    public void updateAddress(Integer id, RequestUpdateAddressUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        user.setAddress(request.getAddress());
        userRepository.save(user);
    }

    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Utilizatorul cu id-ul: %s nu a fost gasit!", id)));
        userRepository.deleteById(user.getId());
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }
    public void save(User user) {
        userRepository.save(user);
    }

}