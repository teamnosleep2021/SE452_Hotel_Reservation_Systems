package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Role;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoleRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UsersRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Users user = new Users();
        user.setUsername("jamesbond");
        user.setEmail("james@bond.uk");
        user.setFname("James");
        user.setLname("Bond");
        user.setPasswordHash("password");
        Users savedUser = repo.save(user);
        
        Users existUser = entityManager.find(Users.class, savedUser.getId());

        assertThat(existUser.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    public void testFindUserByUsername() {
        String username = "LeoD";
        Users user = repo.getUserByUsername(username);
        assertThat(user).isNotNull();
    }

    @Test
    public void testAddRoleToNewUser() {
        Users user = new Users();
        user.setUsername("jamesbond");
        user.setEmail("james@bond.uk");
        user.setFname("James");
        user.setLname("Bond");
        user.setPasswordHash("password");

        Role roleUser = roleRepo.findByRoleName("USER");
        user.addRole(roleUser);

        Users savedUser = repo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void testAddRolesToExistingUser() {
        Users user = repo.findById(1).get();
        
        Role roleUser = roleRepo.findByRoleName("USER");
        user.addRole(roleUser);

        Role roleAdmin = new Role(2);
        user.addRole(roleAdmin);

        Users savedUser = repo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);
    }
}


