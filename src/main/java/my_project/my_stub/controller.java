package my_project.my_stub;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {

    @PostMapping("/hallow_world")
    public String hallow_world() {
        String response = "privet Chelovek!";
        return response;
    }

    @PostMapping("/string_test")
    public String string_test(@RequestBody String request) {
        String response;
        response = request;
        return response;
    }

    @PostMapping("/golova_headers")
    public String hallow_world(@RequestBody String request, @RequestHeader("name1") String name1) {
        String response;
        String text = request;
        String name = name1;
        response = request + name;
        return response;
    }

    @GetMapping("/hallow_world")
    public String hallowWorld() {
        String response = "privet Chelovek!";
        return response;
    }

    @GetMapping("/string_test")
    public String stringTest(@RequestParam("request") String request) {
        String response = request;
        return response;
    }

    @PostMapping("/person_info")
    public String personInfo(@RequestBody String personJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode personNode = objectMapper.readTree(personJson);

            String firstName = personNode.get("fullName").get("firstName").asText();
            String middleName = personNode.get("fullName").get("middleName").asText();
            String lastName = personNode.get("fullName").get("lastName").asText();
            String country = personNode.get("address").get("country").asText();
            String city = personNode.get("address").get("city").asText();
            String street = personNode.get("address").get("street").asText();
            String houseNumber = personNode.get("address").get("houseNumber").asText();
            String apartmentNumber = personNode.get("address").get("apartmentNumber").asText();
            String phoneNumber = personNode.get("phoneNumber").asText();
            String nationality = personNode.get("nationality").asText();

            return "Гражданин " + firstName + " " + middleName + " " + lastName +
                    " живет по адресу: " + country + ", " + city + ", " + street + " " +
                    houseNumber + ", кв. " + apartmentNumber + ". У него номер телефона: " + phoneNumber +
                    ", национальность: " + nationality + ".";
        } catch (Exception e) {
            return "Ошибка парсинга JSON: " + e.getMessage();
        }
    }

    @GetMapping("/sum_params")
    public String sumParams(@RequestParam("param1") int param1, @RequestParam("param2") int param2) {
        return "Сумма чисел: " + (param1 + param2) + "\n" +
                "Разница чисел: " + (param1 - param2) + "\n" +
                "Произведение чисел: " + (param1 * param2) + "\n" +
                "Целочисленное деление чисел: " + (param1 / param2) + "\n" +
                "Остаток от деления чисел: " + (param1 % param2) + "\n";
    }
}