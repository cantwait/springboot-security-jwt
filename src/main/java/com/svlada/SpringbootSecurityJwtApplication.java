package com.svlada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import com.svlada.entity.Role;
import com.svlada.entity.User;
import com.svlada.entity.UserRole;
import com.svlada.entity.UserRole.Id;
import com.svlada.user.repository.UserRepository;
import com.svlada.user.repository.UserRoleRepository;

/**
 * Sample application for demonstrating security with JWT Tokens
 * 
 * @author vladimir.stankovic
 *
 * Aug 3, 2016
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootSecurityJwtApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJwtApplication.class, args);
	}
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepo;

	@Override
	public void run(String... arg0) throws Exception {
		
		User user1 = new User("demo", encoder.encode("demo"));		
		userRepository.save(user1);
		User pUser = userRepository.findByUsername("demo").get();
		Assert.notNull(pUser);
		
		UserRole ur1 = new UserRole();
		
		ur1.setId(new Id(pUser.getId(), Role.ADMIN));
		ur1.setRole(Role.ADMIN);
		
		UserRole pUr1 = userRoleRepo.save(ur1);
		
		Assert.notNull(pUr1);
		
	}
}
