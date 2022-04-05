import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class Selenium {
    public static final String SEARCH_BUTTON_BY_XPATH = "//*[@id=\"search_icon\"]";
    private static WebDriver browser;

    public static void main(String[] args) {
        // write your code here
        System.out.println("selenium+JUnit");

        setup();

        input("Witcher");

        getCompareResults();

        close();
    }

    public static void setup() {
        System.setProperty("webdriver.chrome.driver",
                "libs/chromedriver99.exe");
        browser = new ChromeDriver();
        browser.get("http://kitm.epizy.com/filmai.php?i=1");
    }

    public static void input(String keyword) {
        for (int i = 2; i <=5;i++) {
            WebElement inputField = browser.findElement(By.xpath("/html/body/div[1]/form/input["+i+"]"));
            inputField.sendKeys(keyword);
        }
        // WebElement inputField1 = browser.findElement(By.xpath("/html/body/div[1]/form/input[2]"));
        // inputField1.sendKeys(keyword);
        // WebElement inputField2 = browser.findElement(By.xpath("/html/body/div[1]/form/input[3]"));
        // inputField2.sendKeys(keyword);
        // WebElement inputField3 = browser.findElement(By.xpath("/html/body/div[1]/form/input[4]"));
        // inputField3.sendKeys(keyword);
        // WebElement inputField4 = browser.findElement(By.xpath("/html/body/div[1]/form/input[5]"));
        // inputField4.sendKeys(keyword);
        WebElement inputField5 = browser.findElement(By.xpath("/html/body/div[1]/form/input[6]"));
        inputField5.sendKeys("1234");

        // Pirmas variantas kai puslapis sukurtas su JS
        WebElement ele = browser.findElement(By.xpath("/html/body/div[1]/form/p[1]/button[1]"));
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].click();", ele);
    }

    public static String getCompareResults() {
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
