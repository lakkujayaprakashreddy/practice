
package testng_features;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndDeleteBorrower {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();

            // Step 1: Open the login page
            driver.get(
                "http://49.249.29.4:8081/TestServer/Build/Loan_Management_System/login.php"
            );

            // Step 2: Enter username
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("username"))).sendKeys("admin");

            // Step 3: Enter password
            driver.findElement(By.id("password"))
                    .sendKeys("admin123");

            // Step 4: Click Login
            driver.findElement(By.xpath(
                    "//button[@class='btn-sm btn-block btn-wave col-md-4 btn-primary']"))
                    .click();

            System.out.println("Login button clicked");

            // Step 5: Verify successful login
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                        "//*[normalize-space()='Welcome back Administrator!']"
                    )));

            System.out.println("Passed: Login successful");

            // Step 6: Open the Borrowers page
            driver.get(
                "http://49.249.29.4:8081/TestServer/Build/Loan_Management_System/index.php?page=borrowers"
            );

            // Step 7: Wait for loading overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("preloader2")));

            // Step 8: Locate the Search box
            By searchLocator = By.cssSelector(
                    "#borrower-list_filter input[type='search']");

            WebElement search = wait.until(
                    ExpectedConditions.elementToBeClickable(searchLocator));

            // Step 9: Search for abc
            search.clear();
            search.sendKeys("abc");

            System.out.println("Entered 'abc' in the Search box");

            // Step 10: Wait for filtered records
            By rowsLocator = By.cssSelector(
                    "#borrower-list tbody tr");

            wait.until(webDriver -> {
                List<WebElement> currentRows =
                        webDriver.findElements(rowsLocator);

                return !currentRows.isEmpty()
                        && !currentRows.get(0).getText()
                                .contains("No data available");
            });

            List<WebElement> rows = driver.findElements(rowsLocator);

            // Step 11: Verify matching records exist
            if (rows.isEmpty()
                    || rows.get(0).getText()
                            .contains("No data available")) {

                System.out.println("Failed: No matching borrower found");
                return;
            }

            // Step 12: Capture the first matching row
            WebElement firstRow = rows.get(0);
            String firstRecordDetails = firstRow.getText();

            System.out.println(
                    "First matching borrower: " + firstRecordDetails);

            // Step 13: Locate the trash icon in the first row
            By deleteLocator = By.xpath(
                    "(//*[@id='borrower-list']/tbody/tr[1]"
                    + "//*[name()='svg' and contains(@class,'fa-trash')])[1]");

            // Wait for preloader to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("preloader2")));

            // Step 14: Click Delete
            WebElement deleteIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(deleteLocator));

            deleteIcon.click();

            System.out.println("Clicked delete for the first matching borrower");

            // Step 15: Wait for the HTML confirmation modal
            By confirmationModal = By.xpath(
                    "//*[normalize-space()='Are you sure to delete this borrower?']");

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    confirmationModal));

            // Step 16: Click Continue in the confirmation modal
            By continueButton = By.xpath(
                    "//button[normalize-space()='Continue']"
                    + " | //a[normalize-space()='Continue']"
                    + " | //input[@value='Continue']");

            WebElement continueElement = wait.until(
                    ExpectedConditions.elementToBeClickable(continueButton));

            continueElement.click();

            System.out.println("Clicked Continue on the confirmation modal");

            // Step 17: Wait for the modal to close
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    confirmationModal));

            // Step 18: Wait for any loading overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("preloader2")));

            // Step 19: Verify that the deleted borrower is no longer listed
            // Uses the Tax ID visible in the supplied screenshot.
            By deletedBorrowerLocator = By.xpath(
                    "//*[@id='borrower-list']/tbody/tr"
                    + "[contains(.,'CCUPA7085S')]");

            wait.until(ExpectedConditions.numberOfElementsToBe(
                    deletedBorrowerLocator, 0));

            System.out.println(
                    "Passed: Borrower record was deleted successfully");

        } catch (org.openqa.selenium.TimeoutException e) {

            System.out.println(
                    "Test failed: An expected element or condition timed out.");

            e.printStackTrace();

        } finally {
            // Step 20: Close the browser
            driver.quit();
        }
    }
}
