import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SubExpertAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shafq\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the SubExpert website
            driver.get("https://subexpert.com/");

            // Print the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            // Wait for the login button to be clickable and click it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hLogin.w3-bar-item.w3-button.w3-hover-yellow.w3-round")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

            // Wait for the registration input field to be visible and enter the registration number
            WebElement registrationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserName")));
            registrationInput.sendKeys("FA20-BSE-079");

            // Find the password input field and enter the password
            WebElement passwordInput = driver.findElement(By.id("Password"));
            passwordInput.sendKeys("Hashir@yt2");

            // Wait for at least 5 seconds to ensure the reCAPTCHA box appears
            Thread.sleep(5000);

            // Switch to the correct reCAPTCHA iframe
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[title='reCAPTCHA']")));
            driver.switchTo().frame(iframe);

            // Find the reCAPTCHA checkbox and click it
            WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.className("recaptcha-checkbox-checkmark")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", captchaCheckbox);

            // Switch back to the main content
            driver.switchTo().defaultContent();

            // Wait for a few seconds to ensure reCAPTCHA processing completes
            Thread.sleep(5000);

            // Wait for the submit button to be clickable and click it
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.w3-btn.w3-padding.w3-theme-d5.w3-round-large")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            System.out.println("Submit button clicked");

            // Wait for the "Skip Now" button to be clickable and click it
            WebElement skipNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.w3-btn.w3-padding.w3-theme-d5.w3-round-large[onclick='skipNow();']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", skipNowButton);
            System.out.println("Skip Now button clicked");

            // Wait for the search input field to be visible and enter text
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSearch")));
            searchInput.sendKeys("software testing");
            System.out.println("Search text entered");

            // Wait for the search button to be clickable and click it
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.w3-bar-item.w3-input.w3-border.w3-white.w3-border-gray[title='Search']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
            System.out.println("Search button clicked");

            // Wait for the "View Details" link to be visible
            WebElement viewDetailsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.w3-tag.w3-round.w3-theme-d5[href='/Subjects/ViewSubject/Software-Testing']")));
            
            // Scroll to the "View Details" link
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewDetailsLink);
            System.out.println("Scrolled to View Details link");

            // Click the "View Details" link
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewDetailsLink);
            System.out.println("View Details link clicked");

            // Navigate to the specified URL after clicking "View Details"
            driver.get("https://subexpert.com/CourseLectures/OnTopic/Software-Testing/Introduction");
            System.out.println("Navigated to Software Testing Introduction page");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
