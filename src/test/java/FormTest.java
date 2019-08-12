import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

class FormTest {

    @Test
    void testPositive () throws InterruptedException {
        System.setProperty("chromedriver",
                "D:\\QA Testing Cours\\QA Automation\\Lessons 6 (19.06)\\Programs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/ru/about-itea/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By callBackBtyn = By.cssSelector(".callback-btn");
        wait.until(ExpectedConditions.elementToBeClickable(callBackBtyn));
        driver.findElement(By.className("callback-btn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("b-contacte-phone-tel")));
        driver.findElement(By.id("b-contacte__full-name")).sendKeys("testDima");
        driver.findElement(By.id("b-contacte-phone-tel")).click();
        driver.findElement(By.id("b-contacte-phone-tel")).sendKeys("0501112233");
        driver.findElement(By.xpath("//input[@value='Отправить']")).click();
        Thread.sleep(2000);
        WebElement el = driver.findElement(By.xpath("//div[@class=\"b-header-contacte-phone-thank\"]"));
        assertTrue(el.isDisplayed());
//
        driver.quit();
    }

    @Test
        void testNegative () {
            System.setProperty("chromedriver",
                    "D:\\QA Testing Cours\\QA Automation\\Lessons 6 (19.06)\\Programs\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://iteaua-develop.demo.gns-it.com/ru/about-itea/");
            WebDriverWait wait = new WebDriverWait(driver, 5);
            By callBackBtyn = By.cssSelector(".callback-btn");
            wait.until(ExpectedConditions.elementToBeClickable(callBackBtyn));
            driver.findElement(By.className("callback-btn")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("b-contacte-phone-tel")));
            driver.findElement(By.xpath("//input[@value='Отправить']")).click();
            String style = driver.findElement(By.id("b-contacte__full-name")).getAttribute("style");
            assertEquals(style, "border-color: red;");
            driver.quit();
        }
    }




