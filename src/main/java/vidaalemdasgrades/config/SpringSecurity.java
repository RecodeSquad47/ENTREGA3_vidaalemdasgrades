package vidaalemdasgrades.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
//import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Lazy
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/assets/**").permitAll()
						.requestMatchers("/contato/**").permitAll()
						.requestMatchers("/cursos/**").permitAll()
						.requestMatchers("/empresas/**").hasRole("ADMIN")
						.requestMatchers("/vagas/**").permitAll()
						.requestMatchers("/projetos/**").permitAll()
						.requestMatchers("/quemsomos/**").permitAll()
						.requestMatchers("/register/**").permitAll()
						.requestMatchers("/register/save").permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/login").permitAll()
						.requestMatchers("/users").hasRole("ADMIN")
						.anyRequest().authenticated()
						)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/home")
						.permitAll())
				.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll());
		
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
