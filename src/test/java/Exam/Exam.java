package Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class Exam {
    private WebDriver driver;
    private static WebDriverWait wait;
    Random rand = new Random();
    @Test
    public void Test()
    {
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://staff.am/");

        By Category= By.id("jobsfilter-category");
        WebElement CatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Category));
        By Job=By.xpath("//*[contains(text(), 'Finance Management')]");
        WebElement JobElement=wait.until(ExpectedConditions.elementToBeClickable(Job));

        By searchButton=By.xpath("//*[@data-url='/en/site/search']");
        WebElement ButtonElement=wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        ButtonElement.click();


       By FilteredElem = By.xpath("//*[contains(@class, 'web_item_card ')]");


        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FilteredElem));
        for (WebElement Elements : products) ;
        int totalCount = products.size();

        System.out.println("Total size is : " + totalCount);
        int actual=50;

      By checkBox=By.cssSelector("#jobsfilter-category label input[type=checkbox]" );

       WebElement checkBoxElement=wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        System.out.println(checkBoxElement.getText());
        Assert.assertEquals(actual,totalCount,"Failed");
        driver.quit();


    }

}
