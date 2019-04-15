package xiaozhi.eu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XiaozhiEuApplication {
  /**
   * spring boot 启动
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(XiaozhiEuApplication.class, args);
  }
}
