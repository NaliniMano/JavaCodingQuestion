package day7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedJson_Validation {

    @Test
    public void example1() throws JsonProcessingException {
        String inputJson="{\n" +
                "  \"assets\": [\n" +
                "    { \"symbol\": \"AAPL\", \"price\": 150, \"quantity\": 10 },\n" +
                "    { \"symbol\": \"GOOG\", \"price\": 2800, \"quantity\": 2 }\n" +
                "  ]\n" +
                "}";
        Assert.assertEquals(calculateNAV(inputJson),7100.0);
    }

    private double calculateNAV(String inputJson) throws JsonProcessingException {
       double total_price=0.0;
        ObjectMapper obj= new ObjectMapper();
        JsonNode jnode=obj.readTree(inputJson);

        JsonNode getAsset=jnode.get("assets");
        if (getAsset == null || !getAsset.isArray())
        {
            return 0.0;
        }
        for(JsonNode asset : getAsset)
        {
            String symbol = asset.get("symbol").asText();
            double price =asset.get("price").asDouble();
            double quantity=asset.get("quantity").asInt();
            total_price+=price*quantity;
        }
return  total_price;
    }

}
