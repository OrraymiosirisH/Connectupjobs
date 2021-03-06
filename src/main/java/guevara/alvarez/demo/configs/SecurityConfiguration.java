package guevara.alvarez.demo.configs;

import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/signup","/recrureg","/css/**","/js/**","/img/**","/vendor/**","/scss/**").permitAll()
                .antMatchers("/about")
                .access("hasAuthority('RECRU')")
// .antMatchers("/admin").access("hasRole('ADMIN')")
//               .access("hasAuthority('SEEKER')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))// we don't need an extra page for logout this will do the trick
                .logoutSuccessUrl("/login").permitAll().permitAll()// we're telling it to go back to the login page after logout
                .and()
                .httpBasic();// this allows to login using the password and user in the console, it doesn't matter if we take it out
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();

    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsServiceBean());

    }

//-----------------------------------------------------------------------------

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/")
//                .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
////                .anyRequest().authenticated()
//                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication().
//                withUser("user").password("password").roles("USER")
//                .and()
//                        .withUser("dave").password("begreat").roles("ADMIN");
//    }


}
