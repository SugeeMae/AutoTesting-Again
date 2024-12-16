package feature.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RIghtClickExampleTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        // Tìm phẩn tử nút cần CLick
        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        // Tạo đối tượng Actions để thực hiện double-click
        Actions actions = new Actions(driver);

        // Thực hiện right click vào button
        actions.contextClick(button).perform();

        // Tìm phần tử nút cần click sau khi Right click "Right click me"
        WebElement buttonEdit = driver.findElement(By.xpath("//span[text()='Edit']"));

        // Thực hiện click vào Edit
        actions.contextClick(buttonEdit).perform();

        // Đóng Alert
        driver.switchTo().alert().accept();

    }
}
