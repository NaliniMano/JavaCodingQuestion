package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConverStrintToInt_no_inbuild {

    @Test
    public void example()
    {
        String num="1234";
        Assert.assertEquals(convertStrtoInt(num),1234);
    }

    @Test
    public void example2()
    {
        String num="-1234";
        Assert.assertEquals(convertStrtoInt(num),-1234);
    }

    private int convertStrtoInt(String num) {
        boolean isNegative=false;
        int i=0;
        int result=0;
        if(num.length()<1)
        {
            return 0;
        }
        if(num.startsWith("-"))
        {
             isNegative=true;
             i=1;

        }
        for(;i<num.length();i++)
        {
            char ch=num.charAt(i);
            if(ch < '0'  || ch >'9')
            {
                throw new NumberFormatException("Invalid Character :"+ch);
            }

           result=result*10+(ch-'0');

        }
        return isNegative ? -result:result;
    }
}
