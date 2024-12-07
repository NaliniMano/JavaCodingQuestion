package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ReverseString {

    @Test
    public void example1()
    {
        String input="hello";
        Assert.assertEquals(doReverseStr(input),"olleh");


    }

    @Test
    public void example1_no_inbuild()
    {
        String input="hello";
        Assert.assertEquals(doReverseStr_no_inBuild(input),"olleh");


    }

    private String doReverseStr(String input) {
        StringBuilder result= new StringBuilder(input);
        return result.reverse().toString();
    }

    private String doReverseStr_no_inBuild(String input) {
        char[] chars=input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1;i>=0;i--)
        {
         sb.append(chars[i]);
        }

        return  sb.toString();
    }
}
