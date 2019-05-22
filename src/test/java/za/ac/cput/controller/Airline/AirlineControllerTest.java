package za.ac.cput.controller.Airline;

import za.ac.cput.domain.Airline.Airline;
import za.ac.cput.factory.Airline.AirlineFactory;
import za.ac.cput.service.Airline.impl.AirlineServiceImpl;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AirlineControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/student";

    @Test
    public void testGetAllAirline() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }



    @Ignore
    public void testCreateAirline() {
        Airline airline = AirlineFactory.getAirline("John"," Doh",29);

        ResponseEntity<Airline> postResponse = restTemplate.postForEntity(baseURL + "/create", airline, Airline.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAirline() {
        int id = 1;
        Airline airline = restTemplate.getForObject(baseURL + "/Airline/" + id, Airline.class);

        restTemplate.put(baseURL + "/airline/" + id, airline);
        Airline updatedAirline = restTemplate.getForObject(baseURL + "/Airline/" + id, Airline.class);
        assertNotNull(updatedAirline);
    }

    /*@Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Student student = restTemplate.getForObject(baseURL + "/students/" + id, Student.class);
        assertNotNull(student);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            student = restTemplate.getForObject(baseURL + "/students/" + id, Student.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }*/
}