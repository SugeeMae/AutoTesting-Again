package feature.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class Day5Work {
    public static void main(String[] args) {
        // Đường dẫn file Excel
        String excelFilePath = "dataBookYourDemo.xlsx";
        String sheetName = "Sheet1"; // Hoặc thay bằng tên sheet bất kỳ trong file

        // Đọc dữ liệu từ file Excel
        List<Map<String, String>> excelData = utils.ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Thiết lập WebDriver (trình duyệt Chrome) và login web
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        try {
            // Duyệt qua từng bản ghi trong dữ liệu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Dữ liệu hàng: " + rowData);
                String businessEmail = rowData.get("Business Email"); // Lấy giá trị cột "Business Email"
                String company = rowData.get("Company"); // Lấy gía trị cột "Company"
                String interest = rowData.get("Interest"); // Lấy giá trị cột "Interest"
                String comments = rowData.get("Comments"); // Lấy giá trị cột "Comments"

                WebElement businessEmailInput = driver.findElement(By.xpath("//input[@id='Email']"));
                businessEmailInput.sendKeys(businessEmail);
                WebElement companyInput = driver.findElement(By.xpath("//input[@id='Company']"));
                companyInput.sendKeys(company);
                WebElement interestInput = driver.findElement(By.xpath("//input[@id='Solution_Interest__c']"));
                interestInput.sendKeys(interest);
                WebElement commentsInput = driver.findElement(By.xpath("//input[@id='Sales_Contact_Comments__c']"));
                commentsInput.sendKeys(comments);
                driver.findElement(By.xpath("//label[@id='LblmktoCheckbox_44280_0']")).click();
                driver.findElement(By.xpath("//button[contains(text(),'Talk')]")).click();
            }
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
