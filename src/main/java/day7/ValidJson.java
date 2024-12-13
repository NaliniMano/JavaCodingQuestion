package day7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidJson {

    @Test
    public void example() throws JsonProcessingException {
        String jsonInput="{\n" +
                "  \"transaction_id\": \"abc123\",\n" +
                "  \"amount\": 150.00,\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"timestamp\": \"2023-12-11T10:00:00Z\"\n" +
                "}\n";
        Assert.assertEquals(validateJson(jsonInput),"Valid Json");
    }

    @Test
    public void example2() throws JsonProcessingException {
        String jsonInput="{\n" +
                "  \"transaction_id\": \"abc123\",\n" +
                "  \"amount\": -150.00,\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"timestamp\": \"2023-12-11T10:00:00Z\"\n" +
                "}\n";
        Assert.assertEquals(validateJson(jsonInput),"Invalid Amount");
    }

    @Test
    public void example3() throws JsonProcessingException {
        String jsonInput="{\n" +
                "  \"transaction_id\": \"\",\n" +
                "  \"amount\": -150.00,\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"timestamp\": \"2023-12-11T10:00:00Z\"\n" +
                "}\n";
        Assert.assertEquals(validateJson(jsonInput),"Empty Transaction");
    }

    private String validateJson(String jsonInput) throws JsonProcessingException {

        ObjectMapper obj = new ObjectMapper();
        JsonNode jnode =obj.readTree(jsonInput);

        if(!jnode.has("transaction_id")||
           !jnode.has("amount")||
           !jnode.has("currency")||
           !jnode.has("timestamp"))
        {
            return  "inValid json";
        }

        String transaction_id = jnode.get("transaction_id").asText();
        if(transaction_id.isEmpty())
        {
            return "Empty Transaction";
        }

        double amount = jnode.get("amount").asDouble();
        if(amount <=0)
        {
            return "Invalid Amount";
        }

        String currency = jnode.get("currency").asText();
        if(currency.isEmpty())
        {
            return "not valida currency";
        }

        String timestamp = jnode.get("timestamp").asText();
        if(timestamp.isEmpty())
        {
            return "not valid timestamp";
        }
        return  "Valid Json";
    }
}
