package org.Shiv.driver;

import static org.Shiv.driver.SeleniumActions.find;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.Shiv.API.request.GeminiAIRequest;
import org.Shiv.API.response.GeminiAIResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelfHealingManager {
    public static By getSelfHealingManager(By locator, By parentLocator)
        throws IOException, URISyntaxException, InterruptedException {
        String updatedLocator = null;
        int retryCount =4;
        WebElement element = find (parentLocator);
        //System.out.println ("-- "+element.getAttribute ("outerHTML"));
        GeminiAIRequest geminiAIRequest = new GeminiAIRequest ();
        for(int i=0; i< retryCount; i++){
            HttpResponse response = geminiAIRequest.getGeminiAIRequest (
                "Create only single Locator for given web element" + element.getAttribute (
                    "outerHTML") + " existing locator were " + locator.toString () + " and share locator with By. locator type only ignore other values ");

            Gson gson = new GsonBuilder ().disableHtmlEscaping ()
                .create ();
            // parsing response into pojo
            GeminiAIResponse geminiAIResponse = gson.fromJson (response.body ()
                .toString (), GeminiAIResponse.class);
            // extracting only locator part from response
            String jsonString = geminiAIResponse.getCandidates ()
                .get (0)
                .getContent ()
                .getParts ()
                .get (0)
                .getText ();
            jsonString = jsonString.replaceAll ("```json|```|java", "")
                .replaceAll("`", "")
                .replaceAll (" ","")
                .trim ();
            System.out.println ("--- response 1 -- " + jsonString);
            try {
                updatedLocator = jsonString;
               if (updatedLocator != null) {
                    break;
                }
            } catch (Exception e) {
                System.err.println ("Attempt " + (i + 1) + " failed: " + e.getMessage ());
                Thread.sleep (1000); // Add a delay before retrying
            }
        }
        if (updatedLocator == null) {
            throw new RuntimeException("Failed to fetch updated locator after " + retryCount + " attempts.");
        }
        By latestLocator = stringToBy(updatedLocator);
        return latestLocator;
    }
    public static By stringToBy(String locator){
        if (locator.startsWith("By.id")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.id(locator);
        } else if (locator.startsWith("By.name")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.name(locator);
        } else if (locator.startsWith("By.xpath")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.xpath(locator);
        } else if (locator.startsWith("By.cssSelector")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.cssSelector(locator);
        } else if (locator.startsWith("By.linkText")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.linkText(locator);
        } else if (locator.startsWith("By.partialLinkText")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.partialLinkText(locator);
        } else if (locator.startsWith("By.tagName")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.tagName(locator);
        } else if (locator.startsWith("By.className")) {
            locator = locator.substring (locator.indexOf ("(")+2,locator.indexOf (")")-1);
            return By.className(locator);
        }
            else {
            throw new IllegalArgumentException("Unsupported locator format: " + locator);
        }
    }
}
