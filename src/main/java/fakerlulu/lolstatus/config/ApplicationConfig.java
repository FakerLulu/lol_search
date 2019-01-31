package fakerlulu.lolstatus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "fakerlulu.lolstatus.dao", "fakerlulu.lolstatus.service" })
//@Import({DBConfig.class})
public class ApplicationConfig {

}