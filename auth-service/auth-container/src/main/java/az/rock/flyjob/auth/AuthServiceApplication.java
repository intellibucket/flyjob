package az.rock.flyjob.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {},
        scanBasePackageClasses = {
                az.rock.flyjob.auth.config.PresentationBeanConfig.class
        }, scanBasePackages = {
        "az.rock.flyjob.auth.dataAccess.entity",
})
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
