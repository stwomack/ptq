package io.pivotal.bds.mastercard.ess.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Collections;

@SpringBootApplication
public class ProcessedTransactionsQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessedTransactionsQueryApplication.class, args);
	}
}

@Component
class ExampleInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("Property",
				Collections.singletonMap("JAVA_OPTS", System.getenv().get("JAVA_OPTS")));
	}

}