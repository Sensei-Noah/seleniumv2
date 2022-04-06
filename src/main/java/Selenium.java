import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
// Nojus Murauskas ZP20/2v
public class Selenium {
    private static WebDriver browser;

    public static void main(String[] args) {
        // write your code here
        System.out.println("selenium+TestNG");

        setup();

        createDataInput("Witcher");

        editDataInput("huh");

        deleteDataByIDInput("1234");

        getInputResults();

        close();
    }

    public static void setup() {
        System.setProperty("webdriver.chrome.driver",
                "libs/chromedriver99.exe");
        browser = new ChromeDriver();
        browser.get("http://kitm.epizy.com/filmai.php?i=1");
    }

    public static void createDataInput(String keyword) {

        for (int i = 2; i <=5;i++) {
            WebElement inputField = browser.findElement(By.xpath("/html/body/div[1]/form/input["+i+"]"));
            inputField.sendKeys(keyword);
        }

        WebElement inputField5 = browser.findElement(By.xpath("/html/body/div[1]/form/input[6]"));
        inputField5.sendKeys("1234");

        WebElement ele = browser.findElement(By.xpath("/html/body/div[1]/form/p[1]/button[1]"));
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", ele);
    }

    public static void editDataInput(String keyword) {

        WebElement inputFieldID = browser.findElement(By.xpath("/html/body/div/form/input[1]"));
        inputFieldID.sendKeys("1226");

        for (int i = 2; i <=5;i++) {
            WebElement inputField = browser.findElement(By.xpath("/html/body/div[1]/form/input["+i+"]"));
            inputField.sendKeys(keyword);
        }

        WebElement inputField5 = browser.findElement(By.xpath("/html/body/div[1]/form/input[6]"));
        inputField5.sendKeys("12345");

        WebElement ele = browser.findElement(By.xpath("/html/body/div/form/p[1]/button[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", ele);
    }

    public static void deleteDataByIDInput(String keyword){

        WebElement inputFieldID = browser.findElement(By.xpath("/html/body/div/form/input[1]"));
        inputFieldID.sendKeys(keyword);

        WebElement ele = browser.findElement(By.xpath("/html/body/div/form/p[1]/button[4]"));
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", ele);
    }

    public static String getInputResults() {

        WebElement result2 = browser.findElement(By.xpath("/html/body/div[2]"));

        String resultRGB = result2.getCssValue("Color");
        String resultHex = Color.fromString(resultRGB).asHex();

//                .replaceAll("[a-zA-Z]", "")
//                .replaceAll("[ ,]", "");
//
//        int resultInt = Integer.parseInt(resultStr);
        System.out.println(resultRGB);
        System.out.println(resultHex);

        return resultHex;
    }

    public static void close() {
        browser.close();
    }
}
