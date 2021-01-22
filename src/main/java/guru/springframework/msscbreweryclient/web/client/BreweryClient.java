package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private final RestTemplate restTemplate;
    private String apihost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(), beerDto);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apihost + BEER_PATH_V1 + uuid);
    }


    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public void updateCustomer(UUID uuid, CustomerDto CustomerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto);
    }

    public URI saveNewCustomer(CustomerDto CustomerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, CustomerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid);
    }

}
