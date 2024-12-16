package feature.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickExampleTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        // Tìm phẩn tử nút cần double- click
        WebElement button = driver.findElement(By.xpath("//button"));

        // Tạo đối tượng Actions để thực hiện double-click
        Actions actions = new Actions(driver);

        // Thực hiện double-click vào button
        actions.doubleClick(button).perform();

        // Xừ lý cảnh báo (alert) xuất hiện sau double-click
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after double click: " + alertText);

        // Đóng Alert
        driver.switchTo().alert().accept();
    }
}
