package feature.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web đầu tiên
        driver.get("https://saucelabs.com/request-demo");

        // Lấy phần tử droplist (interest)  bằng cách dùng Xpath
        WebElement interestDropdown = driver.findElement(By.id("Solution_interest__c"));

        // Tạo đối tượng JavascriptExecutor. Chuyển đổi driver thành JavaScriptExecutor để thực hiện
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Thực thi đoạn mã JavaScript và thay đổi giá trị của dropdown
        // Thực hiện thay đổi giá trị (giả sử chúng ta chọn một option có giá trị là "Visual Test"
        js.executeScript("arguments[0].value='Visual Testing'", interestDropdown);

    }
}
