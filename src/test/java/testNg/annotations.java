package testNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class annotations {


    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("this is beforeMethod");
    }

    @Test(groups = "smoke")
    public void AtestCase(){
        System.out.println("this is test case A");
    }

    @Test
    public void BtestCase(){
        System.out.println("this is test case B");
    }

    @Test

    public void CtestCase(){
        System.out.println("this is test case C");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("this is After Method");
    }

}
