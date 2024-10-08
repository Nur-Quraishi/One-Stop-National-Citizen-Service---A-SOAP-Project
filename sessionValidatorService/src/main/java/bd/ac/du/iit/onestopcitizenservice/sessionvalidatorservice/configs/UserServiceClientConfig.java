package bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.configs;

import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.clients.UserServiceClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UserServiceClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //marshaller.setContextPath("bd.ac.du.iit.onestopcitizenservice.userservice.interfaces");
        marshaller.setPackagesToScan("bd.ac.du.iit.onestopcitizenservice.userservice.interfaces", "bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces");
        return marshaller;
    }

    @Bean
    public UserServiceClient createUserServiceClient(Jaxb2Marshaller marshaller) {
        UserServiceClient client = new UserServiceClient();
        client.setDefaultUri("http://localhost:8082/oscs/userServices");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
