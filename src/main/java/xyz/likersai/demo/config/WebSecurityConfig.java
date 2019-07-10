package xyz.likersai.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description Spring Security 的配置
 * @author: MSI PC
 * @create: 2019-05-13 16:59
 */
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 设置SpringSecurity对/和/login路径不拦截
     * 设置SpringSecurity的登录页面访问路径为/login
     * 设置登录成功后转向/chat路径
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 除了“/”,”/home”(首页),”/login”(登录),”/logout”(注销),之外，其他路径都需要认证。
         * 指定“/login”该路径为登录页面，当未认证的用户尝试访问任何受保护的资源时，都会跳转到“/login”。
         * 指定“/error”为错误页面，当有异常抛出时，跳转到“/error”。
         * 默认指定“/logout”为注销页面。
         * 配置一个内存中的用户认证器，使用admin/admin作为用户名和密码，具有USER角色。
         */
        http
                .authorizeRequests()
                    .antMatchers("/","/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main",true)
//                    .successForwardUrl("/main")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    /**
     * 在内存中分别配置两个用户
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("likersai").password(new BCryptPasswordEncoder().encode("likersai")).roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("likeryui").password(new BCryptPasswordEncoder().encode("likeryui")).roles("USER");
    }

    /**
     * /resources/static/下为静态资源目录，SpringSecurity不拦截
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/**/*.js", "/lang/*.json", "/**/*.css", "/**/*.js", "/**/*.map", "/**/*.html","/**/*.png");
    }
}