package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto beerDto = CustomerDto.builder().name("New Customer").build();
        URI uri = client.saveNewCustomer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto beerDto = CustomerDto.builder().name("New Customer").build();
        client.updateCustomer(UUID.randomUUID(), beerDto);
        //assert missing? not a test!
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}