
Dynamic Table Automation with Selenium WebDriver

This Java program demonstrates automation of a dynamic table using Selenium WebDriver. The program interacts with a web page that contains a dynamic table and performs the following actions:

    Opens a web browser and navigates to the specified URL.
    Clicks on the "Table Data" button to reveal an input text box.
    Inserts predefined data into the input text box and clicks the "Refresh Table" button.
    Waits for the table to refresh.
    Retrieves data from the dynamically updated table.
    Asserts that the data in the table matches the predefined data.

Prerequisites

    Java installed
    ChromeDriver executable available

How to Run

    Clone or download the repository.

bash

git clone https://github.com/yourusername/DynamicTableAutomation.git

    Open the project in your preferred Java IDE.

    Set the path to the ChromeDriver executable in the System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); line.

    Run the DynamicTableAutomation class.

Dependencies

    Selenium WebDriver - Selenium is a powerful tool for controlling web browsers through programs and is functional for all major browsers.

Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, feel free to open an issue or create a pull request.
