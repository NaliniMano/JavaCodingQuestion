package day8_JsonValidation;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateUserProfile_JsonArray {

    @Test
    public void example()
    {
        String userprofile_jsonarray="   [\n" +
                "                    {\n" +
                "                        \"user_id\": \"u12345\",\n" +
                "                        \"email\": \"user1@example.com\",\n" +
                "                        \"age\": 25,\n" +
                "                        \"phone\": \"9876543210\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"user_id\": \"\",\n" +
                "                        \"email\": \"invalid_email\",\n" +
                "                        \"age\": 15,\n" +
                "                        \"phone\": \"12345\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"user_id\": \"u67890\",\n" +
                "                        \"email\": \"user2@example.com\",\n" +
                "                        \"age\": 30,\n" +
                "                        \"phone\": \"1234567890\"\n" +
                "                    }\n" +
                "                ]";
        JSONArray userprofile=new JSONArray(userprofile_jsonarray);
        validateUserProfiles(userprofile);
    }

    // Validate a single user profile
    public static List<String> validateUserProfile(JSONObject userProfile) {
        List<String> errors = new ArrayList<>();

        // Validate user_id
        if (!userProfile.has("user_id") || userProfile.getString("user_id").isEmpty()) {
            errors.add("user_id is missing or empty.");
        }

        // Validate email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!userProfile.has("email") || userProfile.getString("email").isEmpty()) {
            errors.add("Invalid email format.");
        }

        // Validate age
        if (!userProfile.has("age") || userProfile.getInt("age") <= 18) {
            errors.add("Age must be greater than 18.");
        }

        // Validate phone
        String phoneRegex = "\\d{10}";
        if (!userProfile.has("phone") || userProfile.getLong("phone")==0) {
            errors.add("Phone number must be exactly 10 digits.");
        }

        return errors;
    }
    // Bulk validation for a list of user profiles
    public static void validateUserProfiles(JSONArray userProfiles) {
        for (int i = 0; i < userProfiles.length(); i++) {
            JSONObject userProfile = userProfiles.getJSONObject(i);
            List<String> errors = validateUserProfile(userProfile);

            System.out.println("Validating user profile #" + (i + 1) + ":");
            if (errors.isEmpty()) {
                System.out.println("Valid user profile.");
            } else {
                System.out.println("Errors:");
                errors.forEach(System.out::println);
            }
            System.out.println();
        }
    }





}
