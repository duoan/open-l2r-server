package io.github.duonao.learn2rank.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Summary: 主入口
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/17
 * Time   : 下午3:12
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
