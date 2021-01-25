/*
 * package com.student.config;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration public class SpringSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth.inMemoryAuthentication()
 * .withUser("user").password("password").roles("USER") .and()
 * .withUser("admin").password("password").roles("ADMIN");
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http //HTTP Basic authentication .httpBasic() .and() .authorizeRequests()
 * .antMatchers(HttpMethod.GET, "/readAllRecords").hasRole("USER")
 * .antMatchers(HttpMethod.POST, "/addNewStudent").hasRole("ADMIN")
 * .antMatchers(HttpMethod.PUT, "/updateStudentsById").hasRole("ADMIN")
 * 
 * .and() .csrf().disable() .formLogin().disable(); } }
 */