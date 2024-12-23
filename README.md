<h1>Self-Healing Locators for Selenium with Java 🚀</h1>

This project provides a robust self-healing locator system for Selenium, powered by Gemini AI. It automatically generates and updates web element locators when they become invalid, reducing test failures and maintenance efforts.

<h2>Features 🌟</h2>
<ol>
<li><h4>Self-Healing Locators:</h4> Automatically detects invalid locators and updates them. </li>
<li><h4>Gemini AI Integration:</h4> Uses AI to intelligently suggest new locators based on the parent element. </li>
<li><h4>Dynamic Locator Management:</h4> Updates locators in the same class using getter and setter methods. </li>
<li><h4>Effortless Maintenance:</h4> Ensures consistent test execution even when locators change. </li>
</ol>
<h2>How It Works 🛠️</h2>
<ol>
<li><h4>Validation:</h4> The system first checks if the locator is valid.</li> 
<li><h4>AI Assistance:</h4> If the locator fails, Gemini AI is called, passing the parent element (or "super element") under which the locator resides (e.g., <div> for a <span>).</li> 
<li><h4>Locator Update:</h4> Gemini AI returns a new, valid locator, which is updated in the class dynamically.</li>
</ol>

<h2>Project Structure 📂</h2>

|-- src 

    |-- main 
    
        |-- java 
        
            |-- com.selfhealing
            
                |-- LocatorManager.java  // Core class for locator handling 
                
                |-- GeminiAIHelper.java // Handles integration with Gemini AI 
                
                |-- TestBase.java      // Base class for Selenium test setup 
                
    |-- test 
    
        |-- java 
        
            |-- com.selfhealing.tests 
            
                |-- ExampleTest.java // Sample test demonstrating self-healing                 
|-- resources  

    |-- config.properties // Configuration file for Selenium and Gemini AI setup     
|-- README.md 


<h2>Prerequisites ✅</h2>
<ul>
<li type = radio> Java 11 or higher</li>
<li type = radio> Maven for dependency management </li>
<li type = radio> Gemini AI API Key (Configure in config.properties) </li>
<li type = radio> Selenium WebDriver</li>
</ul>
<h2>Setup & Installation ⚙️</h2>

- Clone the repository:
   git clone https://github.com/kshiv9842/SelfHealingLocator.git
   cd SelfHealingLocator

- Configure config.properties:
  selenium.driver.path=/path/to/driver
  gemini.api.key=your_gemini_api_key
  gemini.api.url=https://api.gemini.com/locator

- Install dependencies:
  mvn clean install

- Run sample test cases:
  mvn test

<h2>Usage 💻</h2>
<h3>Implementing Self-Healing Locators</h3>
 <ol><li><h4>Create Locators with Parent Elements:</h4>
  Use the LocatorManager class to define locators.</li>
  <li><h4>Handle Failures:</h4> 
  If a locator fails, GeminiAIHelper is invoked to fetch a new locator.</li>
  <li><h4>Dynamic Updates:</h4>
  Updated locators are set using getter and setter methods.</li>
 </ol>
<h2>Example Code ✨</h2>
LocatorManager locatorManager = new LocatorManager(driver);

// Validate and fetch the element
WebElement element = locatorManager.getElement("invalidLocator");

// Perform actions
element.click();
Contributing 🤝

**We welcome contributions! Feel free to open issues, fork the repository, and submit pull requests.**

Start automating with confidence, knowing your locators will heal themselves! 😎
