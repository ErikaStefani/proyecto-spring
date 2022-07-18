package edu.curso.java.spring.proyectospring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		return users;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors()
			.and().csrf().disable().authorizeRequests().anyRequest().authenticated()
			.and().httpBasic();
		return http.build();

		/*
		 * http.authorizeHttpRequests() .antMatchers("/api/**").authenticated()
		 * .antMatchers("/productos/**").authenticated()
		 * .antMatchers("/**").permitAll().and() .formLogin(form -> {
		 * form.loginPage("/login"); form.loginProcessingUrl("/validarusuario");
		 * form.failureUrl("/login?error=true"); form.defaultSuccessUrl("/productos");
		 * }).httpBasic().and().csrf().disable()
		 * .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		 * .invalidateHttpSession(true) .deleteCookies("JSESSIONID");
		 * 
		 * return http.build();
		 */
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}
}