package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseEachWord {

    @Test
    public void example()
    {
        String input="hello world";
        Assert.assertEquals(reverseword(input),"olleh dlrow");
    }

    @Test
    public void example_negative()
    {
        String input=" ";
        Assert.assertEquals(reverseword(input),"");
    }

    @Test
    public void example_edge()
    {
        String input="ab 234";
        Assert.assertEquals(reverseword(input),"ba 432");
    }

    private String reverseword(String input) {

        String[] modified = input.split(" ");
        String output="";
        for(String s : modified)
        {
         output=output+doReverseStr(s)+" ";
        }
        return  output.trim();
    }
    private String doReverseStr(String input) {
        StringBuilder result= new StringBuilder(input);
        return result.reverse().toString();
    }
}
