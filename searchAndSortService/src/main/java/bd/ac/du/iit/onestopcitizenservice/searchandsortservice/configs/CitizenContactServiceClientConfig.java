package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.configs;

import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients.CitizenContactServiceClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CitizenContactServiceClientConfig {
    @Bean
    public Jaxb2Marshaller contactMarshaller() {
        Jaxb2Marshaller contactMarshaller = new Jaxb2Marshaller();

        contactMarshaller.setPackagesToScan("bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces",
                "bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces");
        return contactMarshaller;
    }

    @Bean
    public CitizenContactServiceClient createCitizenContactServiceClient(Jaxb2Marshaller contactMarshaller) {
        CitizenContactServiceClient client = new CitizenContactServiceClient();
        client.setDefaultUri("http://localhost:8083/oscs/citizenContactServices");
        client.setMarshaller(contactMarshaller);
        client.setUnmarshaller(contactMarshaller);
        return client;
    }
}
