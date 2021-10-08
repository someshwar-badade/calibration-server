package com.examserver;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.examserver.model.Role;
import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner,WebMvcConfigurer   {

	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//	    registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
//	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//	}
	
//	@Configuration
//    public class WebConfig implements WebMvcConfigurer {      
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/**")
//            .addResourceLocations("classpath:/static/","classpath:/images/")
//            .setCachePeriod(0);
//        }
//    }
//	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    // Register resource handler for images
	    registry.addResourceHandler("/company-images/**").addResourceLocations("/WEB-INF/images/company-images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Code running................");
		
//		User user = new User();
//		
//		user.setFirstName("Someshwar");
//		user.setLastName("Badade");
//		user.setUsername("someshwar.badade");
//		user.setEmail("someshbadade@gmail.com");
//		user.setPassword("somesh123");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role(); 
//		role1.setId(11L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoles = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		
//		userRoles.add(userRole);
//		
//		User user1 = this.userService.createUser(user,userRoles);
	}

}
