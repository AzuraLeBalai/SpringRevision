package fr.but3.tp509;

import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain mesautorisations(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(mvc.pattern("/public")).permitAll()
                .requestMatchers(mvc.pattern("/private")).hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin( Customizer.withDefaults() )
                .logout( configurer ->
                        configurer.logoutSuccessUrl("/public")
                )
                .build();
    }
    @Bean
    public UserDetailsService mesutilisateurs() {
        UserDetails user1 = User.withUsername("meksim")
                .password(encoder().encode("moi"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1);
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
