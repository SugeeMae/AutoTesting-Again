package feature.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectExampleTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Truy cập vào trang web
        driver.get("https://saucelabs.com/request-demo");

        // Tìm phần tử dropdown(Interest)
        WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));

        // Sử dụng Select để tương tác với dropdown
        Select select = new Select(interestDropdown);

        // Chọn một tùy chọn bằng giá trị (value)
//        select.selectByValue("Mobile Application Testing"); // Giá trị tùy chọn

        // Chọn một tùy chọn bằng văn bản hiển thị
        // select.selectByVisibleText("Scalable Test Automation ");

//        select.selectByIndex(6);
//        select.selectByVisibleText("Test Analytics");
    }
}
