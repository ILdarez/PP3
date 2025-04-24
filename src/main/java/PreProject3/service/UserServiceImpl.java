package PreProject3.service;

import PreProject3.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final String BASE_URL = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private String sessionId;

    public UserServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<User[]> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, User[].class);

        List<String> cookies = response.getHeaders().get("Set-Cookie");
        if (cookies != null && !cookies.isEmpty()) {
            this.sessionId = cookies.get(0).split(";")[0];
        }

        return List.of(response.getBody());
    }

    @Override
    public String addUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", sessionId);

        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    @Override
    public String updateUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", sessionId);

        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.PUT, entity, String.class);

        return response.getBody();
    }

    @Override
    public String deleteUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionId);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.DELETE, entity, String.class);

        return response.getBody();
    }
}
