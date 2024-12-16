package feature.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4Work {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web
        driver.get("https://www.saucedemo.com/");

        // Tìm và nhập tài khoản mật khẩu

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // tìm và chọn 3 sản phẩm bất kì

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        // check out
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();

        // Nhập thông tin người dùng
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Dũng");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Lương");
        driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("100000");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Finish
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
    }
}
