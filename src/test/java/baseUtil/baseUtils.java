package baseUtil;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class baseUtils {

    public static WebDriver driver;
    int invalidImageCount;


    @BeforeScenario
    public void beforeScenario(){
        initBrowser("CHROME");
    }

    public void initBrowser(String browserName) {
        switch (browserName) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
                driver = getChrome();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "./drivers/firefox/geckodriver");
                driver = getFirefox();
                break;
                case "SAFARI":
                System.setProperty("webdriver.safari.driver", "./drivers/firefox/safaridriver");
                driver = new SafariDriver();
                break;
        }

        driver.get("https://www.trendyol.com");
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }


    public ChromeDriver getChrome(){
        DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.merge(capabilities);
        return new ChromeDriver(chromeOptions);
    }

    public FirefoxDriver getFirefox(){
        DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("test-type");
        firefoxOptions.addArguments("disable-popup-blocking");
        firefoxOptions.addArguments("ignore-certificate-errors");
        firefoxOptions.addArguments("disable-translate");
        firefoxOptions.addArguments("disable-infobars");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("disable-plugins");
        firefoxOptions.merge(capabilities);
        return new FirefoxDriver(firefoxOptions);
    }


    public void clickElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean isElementVisible(WebElement element){
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void hoverElement(WebElement element) {
        Actions hoverAction  = new Actions(driver);
        hoverAction.moveToElement(element).perform();
    }

    public void sendText(String text,WebElement element) {
        isElementVisible(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        isElementVisible(element);
        return element.getText();
    }


    public void checkBrokenImginTab2(){
        WebElement image=driver.findElement(By.cssSelector(""));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<WebElement> broken_images = (List<WebElement>) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);

    }

    public void checkBrokenImgTab4() {
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
        for (WebElement imgElement : imagesList) {
            if (imgElement != null && isElementVisible(imgElement)) {
                if (imgElement.getAttribute("naturalWidth").equals("0")) {
                    System.out.println("Broken image"+imgElement.getAttribute("outerHTML"));
                }
            }
        }
        System.out.println(imagesList.size());
    }

    public void checkBrokenImgs(){
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
        for (WebElement imgElement : imagesList) {
            if (imgElement != null) {
                try {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(imgElement.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    if (response.getStatusLine().getStatusCode() !=200) {
                        invalidImageCount++;
                        System.out.println("Broken image" + imgElement.getAttribute("outerHTML"));
                    }
                }
                    catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Total number of images in the page"+imagesList.size());
        System.out.println("Total number of broken images in the page"+invalidImageCount);
    }

    public void waitBySeconds(long seconds) throws InterruptedException { Thread.sleep(seconds*1000);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getAttribute(WebElement element,String att){
        return element.getAttribute(att);
    }

    public boolean containsText(String text1,String text2){
        return text1.contains(text2);

    }

    @AfterScenario
    public void afterScenario(){
        driver.quit();
    }

}
