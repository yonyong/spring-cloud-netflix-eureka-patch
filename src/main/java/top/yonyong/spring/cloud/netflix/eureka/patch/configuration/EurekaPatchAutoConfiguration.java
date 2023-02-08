package top.yonyong.spring.cloud.netflix.eureka.patch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author yonyong
 * @version 1.0
 * @date 2023/2/8 15:51
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"top.yonyong.spring.cloud.netflix.eureka.patch"})
public class EurekaPatchAutoConfiguration {

    @PostConstruct
    private void load(){
        log.info("The eureka patch has been loaded successfully");
    }
}
