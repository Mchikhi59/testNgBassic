package testNg;

import org.testng.annotations.Test;

public class anableDisable {

    @Test(enabled = false)
    public void BeforeMethod(){
        System.out.println("this is beforeMethod");
    }

    @Test
    public void AtestCase(){
        System.out.println("this is test case A");
    }
}
