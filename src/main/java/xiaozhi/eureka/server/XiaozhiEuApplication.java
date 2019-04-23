package xiaozhi.eureka.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaServer
@SpringBootApplication
public class XiaozhiEuApplication extends WebSecurityConfigurerAdapter {
  @Autowired
  public void securityAuto(AuthenticationManagerBuilder builder) throws Exception {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    builder.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("USERS");
  }


  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            //开启默认登录页面
            .formLogin()
            //默认登录成功跳转页面
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            //设置注销
            .logout()
            .permitAll();
  }

  /**
   * spring boot 启动
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(XiaozhiEuApplication.class, args);
  }
}
