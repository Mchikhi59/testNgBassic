package testNg;

import org.testng.annotations.Test;

public class priority {

    public void BeforeMethod(){
        System.out.println("this is beforeMethod");
    }

    @Test(priority = 1,groups = "smoke")
    public void BtestCase(){
        System.out.println("this is test case B");
    }

    @Test(priority = 2)
    public void AtestCase(){
        System.out.println("this is test case A");
    }

    @Test(priority = 3)

    public void CtestCase(){
        System.out.println("this is test case C");
    }
    @Test
    public void FtestCase(){
        System.out.println("this is test case F");
    }
}

