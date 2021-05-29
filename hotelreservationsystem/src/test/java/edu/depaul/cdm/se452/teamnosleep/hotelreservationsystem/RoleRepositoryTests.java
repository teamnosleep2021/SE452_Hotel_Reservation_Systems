package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Role;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoleRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void testCreateRoles() {
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");
        roleRepository.saveAll(List.of(user, admin));

        List<Role> listRoles = roleRepository.findAll();
        assertThat(listRoles.size()).isEqualTo(2);
    }
}
