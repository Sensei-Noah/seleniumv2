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
    public void checkResultCorrectTest(){
        //When input data is correct
        Selenium.createDataInput("WowMovie");
        Assert.assertEquals(Selenium.getInputResults(),"#3c763d");
        Selenium.getInputResults();
    }
    @Test (priority = 2)
    public void checkResultIncorrectTest(){
        //When input data is Incorrect
        Selenium.createDataInput("E");
        Assert.assertEquals(Selenium.getInputResults(),"#ff0000");
        Selenium.getInputResults();
    }
    @Test (priority = 3)
    public void checkResultEditCorrectTest(){
        Selenium.editDataInput("EPicEDIt");
        Assert.assertEquals(Selenium.getInputResults(),"#3c763d");
        Selenium.getInputResults();
    }
    @Test (priority = 4)
    public void checkResultEditIncorrectTest(){
        Selenium.editDataInput("E");
        Assert.assertEquals(Selenium.getInputResults(),"#ff0000");
        Selenium.getInputResults();
    }
    @Test (priority = 5)
    public void checkResultDeleteTest(){
        Selenium.deleteDataByIDInput("1234");
        Assert.assertEquals(Selenium.getInputResults(),"#3c763d");
        Selenium.getInputResults();
    }
    @AfterTest
    public void close(){
        Selenium.close();
    }
}
