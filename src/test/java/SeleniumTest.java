import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void setup(){
        Selenium.setup();
    }
    @Test (priority = 1)
    public void searchTest(){
        Selenium.input("Weee");
    }
    @Test (priority = 2)
    public void compareResultTest(){
        //Selenium.input("Baranauskas");
        Assert.assertEquals(Selenium.getCompareResults(),"#3c763d");
        Selenium.getCompareResults();
    }
    @AfterTest
    public void close(){
        Selenium.close();
    }
}
