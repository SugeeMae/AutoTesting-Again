package feature.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Day5Work {
    public static void main(String[] args) {
        // Đường dẫn Excel
        String excelFilePath = "dataBookYourDemo.xlsx";
        String sheetName = "Sheet1";

        // Đọc dữ liệu từ file Excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Khởi tạo WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://saucelabs.com/request-demo");
        // Duyệt qua từng bản ghi trong dữ liệu
        for (Map<String, String> rowData : excelData) {
            System.out.println("Dữ liệu hàng: \n " + rowData);

            // Lấy dữ liệu từ Excel
            String email = rowData.get("Email");
            String firstName = rowData.get("First Name");
            String lastName = rowData.get("Last Name");
            String company = rowData.get("Company");
            String phoneNumber = rowData.get("Phone Number");
            String country = rowData.get("Country");
            String interest = rowData.get("Interest");
            String comment = rowData.get("Comment");

            // Nhập dữ liệu vào các trường
            driver.findElement(By.id("Email")).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).sendKeys(firstName);
            driver.findElement(By.id("LastName")).sendKeys(lastName);
            driver.findElement(By.id("Company")).sendKeys(company);
            driver.findElement(By.id("Phone")).sendKeys(phoneNumber);

            driver.findElement(By.xpath("//option[@value='" + country + "']")).click();
            driver.findElement(By.xpath("//option[@value='" + interest + "']")).click();

            driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(comment);
            driver.findElement(By.id("LblmktoCheckbox_44280_0")).click();

            // Gửi yêu cầu
            driver.findElement(By.xpath("//button[contains(text(),'Talk')]")).click();
        }
        // Đảm bảo đóng trình duyệt sau khi thực hiện xong
        driver.quit();
    }
}