package top.pengcheng789.java.springblog.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Spring Security 配置
 *
 * CreateDate:2017-08-10
 *
 * @author pen
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    private static final String USER_SQL =
            "SELECT id, password, is_active FROM user WHERE mail = ?";
    private static final String AUTHORITY_SQL =
            "SELECT u.id, r.role_name FROM user u, role r, user_role ur"
            + " WHERE u.id = ? and ur.user_id = u.id and r.role_id = ur.role_id";

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(USER_SQL)
                .authoritiesByUsernameQuery(AUTHORITY_SQL)
                .passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/user/login")
                .and().logout().logoutSuccessUrl("/").logoutUrl("/user/logout")
                .and().authorizeRequests()
                .antMatchers("/user/profile", "user/update/**").authenticated()
                .antMatchers("/user/list", "/user/delete/**").hasRole("ADMIN")
                .anyRequest().permitAll();
    }
}
