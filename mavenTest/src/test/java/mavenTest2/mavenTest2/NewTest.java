package mavenTest2.mavenTest2;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  public void test1() throws InterruptedException {
	  System.out.println("测试1");
	  driver.get("https://www.baidu.com");
	  System.out.println(driver.getTitle());
	  driver.findElement(By.id("kw")).sendKeys("软件测试");
	  driver.findElement(By.id("su")).click();
	  Thread.sleep(1000);
	  String s = driver.findElement(By.linkText("软件测试_百度百科")).getText();
	  System.out.println(s);
	  assertEquals(s, "软件测试_百度百科");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("模块A开始");
	  
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("模块A结束");
	  driver.quit();
  }

}
