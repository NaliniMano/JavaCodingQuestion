package day8_JsonValidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ValidUserProfileJson {

    @Test
    public void example() throws IOException {
        File file =new File("src/main/inputs/UserProfile.json");
        Assert.assertEquals(validateJson(file),"valid user profile");

    }

    private String validateJson(File file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootnode= objectMapper.readTree(file);

        String user_id=rootnode.get("user_id").asText();
        if(user_id.isEmpty())
        {
            return  "User ID should not be empty";
        }

        String email=rootnode.get("email").asText();
        if(email.isEmpty())
          return  "email id should not be empty";

        int age =rootnode.get("age").asInt();
        if(age < 18)
        {
            return  "age should be greater than 18";
        }

        long phone = rootnode.get("phone").asLong();
        if(phone < 1)
        {
            return "phone number should not be empty";
        }
        return  "valid user profile";
    }
}
