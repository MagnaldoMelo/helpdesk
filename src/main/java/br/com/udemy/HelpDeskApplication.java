package br.com.udemy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.udemy.api.entity.User;
import br.com.udemy.api.enums.ProfileEnum;
import br.com.udemy.api.repository.UserRepository;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder){
		User admin = new User();
		admin.setEmail("magnaldo.melo@gmail.com");
		admin.setPassword(passwordEncoder.encode("123"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);

		User find = userRepository.findByEmail("magnaldo.melo@gmail.com");
		if (find == null){
			userRepository.save(admin);
		}
	}
}
