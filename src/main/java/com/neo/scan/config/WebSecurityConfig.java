package com.neo.scan.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.neo.scan.authentication.UserLoginAuthenticationService;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserLoginAuthenticationService userLoginAuthenticationService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Các User trong bộ nhớ (MEMORY).
		auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
		auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("USER, ADMIN");
		
		
		// Các User trong Database
		// set password md5 encrypt
		auth.userDetailsService(userLoginAuthenticationService).passwordEncoder(passwordEncoder());
	}

	// bean for md5 encryption
	@Bean
	public Md5PasswordEncoder passwordEncoder() throws Exception {
		return new Md5PasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		 
		// To enable the scenario which allows multiple concurrent sessions for
		// the same user the <session-management> element should be used in the
		// XML
		http.sessionManagement().maximumSessions(2);
		http.sessionManagement().sessionFixation().migrateSession();

		
		http.csrf().disable();
		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/login", "/logout","/assests").permitAll();
		// Trang /userInfo yêu cầu phải login với vai trò USER hoặc ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.
		
		//trang index se duyet tu day sau khi login thanh cong
		//menu se hien thi theo quyen duoc phan 
		http.authorizeRequests().antMatchers("/*").authenticated();

		//cac trang tiep theo de truy nhap ngoai lay danh sach menu can cap quyen truy nhap
		// Trang chỉ dành cho ADMIN
		//String[] array = { "/admin", "/welcome", "/" };
		//http.authorizeRequests().antMatchers(array).access("hasRole('ROLE_ADMIN')");
		
		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password")
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
	}
}