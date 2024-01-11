import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class DynamicTableAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
    	
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open the browser and navigate to the URL
        String url = "https://testpages.herokuapp.com/styled/tag/dynamic-table.html";
        driver.get(url);

        // initialize dataToInsert 
        List<Map<String, Object>> dataToInsert = List.of(
                Map.of("name", "Bob", "age", 20, "gender", "male"),
                Map.of("name", "George", "age", 42, "gender", "male"),
                Map.of("name", "Sara", "age", 42, "gender", "female"),
                Map.of("name", "Conor", "age", 40, "gender", "male"),
                Map.of("name", "Jennifer", "age", 42, "gender", "female")
        );

       
        

        // Click on the "Table Data" button
        WebElement tableDataButton = driver.findElement(By.xpath("//summary[normalize-space()='Table Data']"));
        tableDataButton.click();

        // Insert data into the input text box and click "Refresh Table" button
        WebElement inputTextBox = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
        inputTextBox.clear();
        String jsonData = "[{\"name\": \"Bob\", \"age\": 20, \"gender\": \"male\"}," +
                "{\"name\": \"George\", \"age\": 42, \"gender\": \"male\"}," +
                "{\"name\": \"Sara\", \"age\": 42, \"gender\": \"female\"}," +
                "{\"name\": \"Conor\", \"age\": 40, \"gender\": \"male\"}," +
                "{\"name\": \"Jennifer\", \"age\": 42, \"gender\": \"female\"}]";
        inputTextBox.sendKeys(jsonData);

        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();

        // Adding a sleep to wait for the table to refresh
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the data from the UI table
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));

        // Assert the data
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            String name = row.findElement(By.xpath("td[1]")).getText();
            int age = Integer.parseInt(row.findElement(By.xpath("td[2]")).getText());
            String gender = row.findElement(By.xpath("td[3]")).getText();

            String expectedName = dataToInsert.get(i).get("name").toString();
            int expectedAge = Integer.parseInt(dataToInsert.get(i).get("age").toString());
            String expectedGender = dataToInsert.get(i).get("gender").toString();

            assert name.equals(expectedName) : "Data mismatch in name for row " + (i + 1);
            assert age == expectedAge : "Data mismatch in age for row " + (i + 1);
            assert gender.equals(expectedGender) : "Data mismatch in gender for row " + (i + 1);
        }

        // Close the browser
        driver.quit();
    }
}
