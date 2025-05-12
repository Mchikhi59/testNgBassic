package testNg;

import org.testng.annotations.Test;

public class dependency {

    @Test
    public void loginTestcase(){

        System.out.println(0/0);

    }

    @Test(dependsOnMethods = {"loginTestcase"})
    public void dashboardTestCase(){
        System.out.println("this is dashboard test case");
    }
}
