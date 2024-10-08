package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.configs;

import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients.SessionValidatorServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SessionValidatorServiceClientConfig {
    @Bean
    public Jaxb2Marshaller sessionMarshaller() {
        Jaxb2Marshaller sessionMarshaller = new Jaxb2Marshaller();

        sessionMarshaller.setPackagesToScan("bd.ac.du.iit.onestopcitizenservice.userservice.interfaces",
                "bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces",
                "bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces");
        return sessionMarshaller;
    }

    @Bean
    public SessionValidatorServiceClient createSessionValidatorServiceClient(Jaxb2Marshaller sessionMarshaller) {
        SessionValidatorServiceClient client = new SessionValidatorServiceClient();
        client.setDefaultUri("http://localhost:8084/oscs/sessionValidatorServices");
        client.setMarshaller(sessionMarshaller);
        client.setUnmarshaller(sessionMarshaller);
        return client;
    }
}
