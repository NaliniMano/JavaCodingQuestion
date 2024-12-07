package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConverLowerCase_UpperCase {
    @Test
    public void example()
    {
        String input="hello world";
        Assert.assertEquals(convertLowerToUpper(input),"HELLO WORLD");
    }


    @Test
    public void example2()
    {
        String input="hello world";
        Assert.assertEquals(convertLowerToUpper_noinbuild(input),"HELLO WORLD");
    }

    @Test
    public void example3_edge()
    {
        String input="HELLO! world";
        Assert.assertEquals(convertLowerToUpper_noinbuild(input),"HELLO! WORLD");
    }

    private String convertLowerToUpper(String input) {
        return input.toUpperCase();
    }

    private String convertLowerToUpper_noinbuild(String input) {
        StringBuilder result =new StringBuilder();
        for(char c: input.toCharArray())
        {
            if(c >= 'a' && c<='z')
            {
                result.append((char)(c-32));
            }else
            {
                result.append(c);
            }
        }
        return result.toString();
    }
}
