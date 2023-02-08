package top.yonyong.spring.cloud.netflix.eureka.patch.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yonyong
 * @version 1.0
 * @date 2023/2/8 15:51
 */
@Configuration
@PropertySource(name = "default", value = "classpath:default.properties")
public class EurekaPatchDefaultConfiguration {

}
