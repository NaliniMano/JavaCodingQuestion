package day8_JsonValidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ValidBulkUserProfile {

    @Test
    public void example() throws IOException {
        File file =new File("src/main/inputs/BulkUserProfile.json");
        validateJson(file);

    }

    private void validateJson(File file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootnode = objectMapper.readTree(file);

        JsonNode usersnode = rootnode.get("users");
        if(!usersnode.isArray()|| usersnode == null)
        {
            System.out.println( " invalid Json");
        }

        String user_id="";
        String email="";
        int age=0;
        long phone=0;
        int count=1;

        for(JsonNode unode : usersnode) {

            System.out.println("Validating User Profile"+count);
            user_id = unode.get("user_id").asText();
            email = unode.get("email").asText();
            age = unode.get("age").asInt();
            phone = unode.get("phone").asLong();

            if (user_id.isEmpty()) {
                System.out.println("User ID should not be empty");
            }
            else if (email.isEmpty()) {
                System.out.println("email id should not be empty");
            }
            else if (age < 18) {
                System.out.println("age should be greater than 18");
            }
            else if (phone < 1) {
                System.out.println("phone number should not be empty");
            }else
            {
                System.out.println("Valid User Profile");
            }
         count++;
        }


    }
}
