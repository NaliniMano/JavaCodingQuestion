package day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringCompress {

    @Test
    public void example()
    {
        String input="aaabbbccdfwwww";
        Assert.assertEquals(strCompress(input),"a3b3c2dfw4");
    }

    @Test
    public void example_negative()
    {
        String input="";
        Assert.assertEquals(strCompress(input),"not valid input");
    }



    @Test
    public void example_edge()
    {
        String input="aaaaaaaaab";
        Assert.assertEquals(strCompress(input),"a9b");
    }

    private String strCompress(String input) {
        if(input.length() <=1)
        {
            return "not valid input";
        }
        StringBuilder compress = new StringBuilder();
        int count=1;
        for(int i=1;i<input.length();i++)
        {
           if(input.charAt(i)==input.charAt(i-1))
           {
               count++;
           }else
           {
               compress.append(input.charAt(i-1));
               if(count>1)
                   compress.append(count);
               count=1;
           }
        }
        compress.append(input.charAt(input.length()-1));
        if(count >1 )
            compress.append(count);

       // System.out.println(compress.toString());
        return compress.toString();
    }
}
