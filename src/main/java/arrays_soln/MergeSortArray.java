package arrays_soln;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeSortArray {

    @Test
    public void example1()
    {
        int[] arr1={1,3,6};
        int[] arr2={2,4,5};
        Assert.assertEquals(mergeSort(arr1,arr2),new int[]{1,2,3,4,5,6});
    }

    private int[] mergeSort(int[] arr1, int[] arr2) {

        int left = 0,right=0;
        List<Integer> list = new ArrayList<>();
        while(left < arr1.length && right < arr2.length)
        {
          if(arr1[left] < arr2[right])
          {
              list.add(arr1[left++]);
          } else if (arr2[right] < arr1[left]) {
              list.add(arr2[right++]);

          }else {
              list.add(right++);
              left++;
          }
        }
        while(right < arr2.length)
        {
            list.add(arr2[right++]);
        }

        while(left < arr1.length)
        {
            list.add(arr1[left++]);
        }

        System.out.println(list);
        int[] output = new int[list.size()];
        int index=0;
        for(int i : list)
        {
            output[index++]=i;
        }
        return  output;
    }
}
