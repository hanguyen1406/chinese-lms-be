package lms;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import lms.model.ERole;
import lms.model.Role;
import lms.model.User;
import lms.repository.RoleRepository;
import lms.repository.UserRepository;
import lms.service.RoleService;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserRepository ob;
	@Autowired
	RoleService rs;
	@Autowired
	RoleRepository ry;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (!ob.findByUsername("admin").isEmpty() && !ry.findByName(ERole.ROLE_USER).isEmpty()
				&& !ry.findByName(ERole.ROLE_ADMINISTRATOR).isEmpty()) {
			System.out.println("Default values already exist");
		} else {
			ry.save(new Role(null, ERole.ROLE_USER));
			ry.save(new Role(null, ERole.ROLE_ADMINISTRATOR));

			Set<Role> roles = new HashSet<>();
			Role userRole = rs.findByName(ERole.ROLE_ADMINISTRATOR).orElseThrow();
			roles.add(userRole);

			User u = new User(null, "admin", "admin", "admin", "admin@gmail.com", encoder.encode("123"));
			u.setRoles(roles);
			ob.save(u);

		}

	}
}
