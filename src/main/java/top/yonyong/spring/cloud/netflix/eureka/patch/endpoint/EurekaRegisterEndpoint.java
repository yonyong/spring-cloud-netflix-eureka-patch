package top.yonyong.spring.cloud.netflix.eureka.patch.endpoint;

import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaAutoServiceRegistration;
import org.springframework.stereotype.Component;

/**
 * @author yonyong
 * @version 1.0
 * @date 2023/2/8 15:35
 */
@Slf4j
@Component
@Endpoint(id = "eureka-register")
@ConditionalOnClass(Endpoint.class)
public class EurekaRegisterEndpoint {

	@Autowired(required = false)
	private EurekaClient eurekaClient;

	@Autowired(required = false)
	private EurekaAutoServiceRegistration autoRegistration;

	@ReadOperation
	public Boolean reRegistered() {
		// This will force the creation of the EurkaClient bean if not already created
		// to make sure the client will be reregistered after a refresh event
		log.info("eureka re-registered start");
		if (eurekaClient != null) {
			eurekaClient.getApplications();
		}
		if (autoRegistration != null) {
			// register in case meta data changed
			this.autoRegistration.stop();
			this.autoRegistration.start();
		}
		log.info("eureka re-registered end");
		return true;
	}

}