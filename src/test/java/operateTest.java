import org.junit.Assert;
import org.junit.Test;

public class operateTest {
    @Test
    public void testzsCalculation(){
        Assert.assertEquals(String.valueOf(3),Operate.zsCalculation(1,2,"+"));
        Assert.assertEquals(String.valueOf(5),Operate.zsCalculation(7,2,"-"));
        Assert.assertEquals(String.valueOf(12),Operate.zsCalculation(3,4,"×"));
        System.out.println(Operate.zsCalculation(5,2,"÷"));
    }

    @Test
    public void testfsCalculation(){
        System.out.println(Operate.fsCalculation(1,2,1,4,"+"));
        System.out.println(Operate.fsCalculation(8,3,1,4,"-"));
        System.out.println(Operate.fsCalculation(1,2,7,3,"×"));
        System.out.println(Operate.fsCalculation(1,3,2,9,"÷"));
    }
}
