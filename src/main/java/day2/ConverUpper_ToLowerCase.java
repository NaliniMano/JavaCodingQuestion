package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConverUpper_ToLowerCase {

    @Test
    public void example()
    {
        String input="HELLO WORLD";
        Assert.assertEquals(converUpperToLower(input),"hello world");
    }


    @Test
    public void example2()
    {
        String input="HELLO WORLD";
        Assert.assertEquals(converUpperToLower_noinbuild(input),"hello world");
    }

    @Test
    public void example3_edge()
    {
        String input="HELLO world";
        Assert.assertEquals(converUpperToLower_noinbuild(input),"hello world");
    }

    private String converUpperToLower(String input) {
        return input.toLowerCase();
    }

    private String converUpperToLower_noinbuild(String input) {
         StringBuilder result =new StringBuilder();
        for(char c: input.toCharArray())
        {
           if(c >= 'A' && c<='Z')
           {
               result.append((char)(c+32));
           }else
           {
               result.append(c);
           }
        }
        return result.toString();
    }
}
