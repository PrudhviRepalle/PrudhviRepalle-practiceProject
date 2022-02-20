package wrappers;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Default;

public class GenericWrappers implements Wrappers {
	RemoteWebDriver driver;

	@Override
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "./drivers/iedriver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();

			System.out.println("The browser launched successfully");
		} catch (TimeoutException e) {
			System.err.println("The application is taking more time to load");
		} catch (NoSuchSessionException e) {
			System.err.println("No session  created, Check your browser versions");
		} catch (WebDriverException e) {
			System.err.println("The browser not launched due to webdriver exception");
		} finally {
			takeSnap();
		}

	}

	@Override
	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("staleelement error ,the element no longer appears on DOM");
		}finally {
			takeSnap();
		}

	}

	@Override
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("staleelement error ,the element no longer appears on DOM");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			System.err.println("The element is not present");
			// TODO Auto-generated catch block

		} catch (StaleElementReferenceException e) {
			System.err.println("staleelement error ,the element no longer appears on DOM");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String tit = driver.getTitle();
			if (tit.equals(title)) {
				System.out.println("Title is matching");
			} else {
				System.out.println("Title is mismatched");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			takeSnap();
		}

	}

	@Override
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementById(id).getText();
			if (tex.equals(text)) {
				System.out.println("Text is matching");
			} else {
				System.out.println("Text is mismatched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementByXPath(xpath).getText();
			if (tex.equals(text)) {
				System.out.println("Text is matching");
			} else {
				System.out.println("Text is mismatched");
			}

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String tex = driver.findElementByXPath(xpath).getText();
			if (tex.contains(text)) {
				System.out.println("Text is present");
			} else {
				System.out.println("Text is not present");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}

	}

	@Override
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}

	}

	@Override
	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(classVal).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}
	}

	

	@Override
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}

	}

	@Override
	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
		}
	}

	@Override
	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		try {
			String data = driver.findElementById(idVal).getText();
			return data;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
	}
		return idVal;

	}

	@Override
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String data = driver.findElementByXPath(xpathVal).getText();
			return data;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
	}
		return xpathVal;
	}

	@Override
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementById(id);
			Select sel = new Select(test);
			sel.selectByVisibleText(value);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		} finally {
			takeSnap();
	}

	}
	public void selectValueByXpath(String Xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByValue(value);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		} finally {
			takeSnap();
	}

	}

	public void selectVisibileTextByXpath(String Xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByVisibleText(value);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
	}

	}

	@Override
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementById(id);
			Select sel = new Select(test);
			sel.selectByIndex(value);
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		} catch (StaleElementReferenceException e) {
			System.err.println("stale element exception");
		} catch (WebDriverException e) {
			System.err.println("WebDriver exception");
		}finally {
			takeSnap();
	}

	}

	public void selectIndexByXpath(String Xpath, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement test = driver.findElementByXPath(Xpath);
			Select sel = new Select(test);
			sel.selectByIndex(value);
		}  catch ( ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		}catch ( ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		}catch ( NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Element is not present to get text");
		}catch(StaleElementReferenceException e) {
			System.err.println("stale element exception");
		}catch(WebDriverException e) {
			System.err.println("WebDriver exception");
		} finally {
			takeSnap();
	}
	}
	@Override
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> window = driver.getWindowHandles();
			for (String windows : window) {
				driver.switchTo().window(windows);
				break;
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");

		}catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
		} finally {
			takeSnap();
	}

	}

	@Override
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			
			Set<String> window = driver.getWindowHandles();
			for (String windows : window) {
				driver.switchTo().window(windows);
			     }
			
		    } catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");

		    }catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
		    } finally {
			takeSnap();
	        }

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to accept alert");
		}

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to dismiss");

		}finally {
			takeSnap();
		}

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		String text = null ;
		try {
			text = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present to get tesxt");
			
		}finally {
			takeSnap();
		}
		return text;
	}

	@Override
	public void takeSnap() {
		// TODO Auto-generated method stub
		try {
			long name = Math.round((Math.random() * 1000000l));
			File screen = driver.getScreenshotAs(OutputType.FILE);

			File dest = new File("./screenshots/" + name + ".jpeg");

			FileUtils.copyFile(screen, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();

	}

	public void threadWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
		} finally {
			takeSnap();
	}
	}

	public void switchtoWondowIndex(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> window = driver.getWindowHandles();
			ArrayList<String> windows = new ArrayList<String>(window);
			driver.switchTo().window(windows.get(index));
		} catch ( NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window is not present");
		}catch (WebDriverException e) {
			System.err.println("Window cant switch webdriver exception");
		} finally {
			takeSnap();
	}
	}

 public void sendFile(String path)  {
		try {
			StringSelection fi = new StringSelection(path);//path of the file to be selected to be given here
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fi, null);
					Robot robo = new Robot();
					robo.keyPress(KeyEvent.VK_CONTROL);
					robo.keyPress(KeyEvent.VK_V);
					robo.keyRelease(KeyEvent.VK_V);
					robo.keyRelease(KeyEvent.VK_CONTROL);
					robo.keyPress(KeyEvent.VK_ENTER);
					robo.keyRelease(KeyEvent.VK_ENTER);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			takeSnap();
	}		
				
	}
 
 public void moveToElementByXpath(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementByXPath(value);
		 act.moveToElement(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
}	
			
 }
 public void moveToElementByID(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementById(value);
		 act.moveToElement(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void contextClickByID(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementById(value);
		 act.contextClick(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void contextClickByXpath(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementByXPath(value);
		 act.contextClick(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void doubleClickByXpath(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementByXPath(value);
		 act.doubleClick(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void doubleClickById(String value) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementById(value);
		 act.doubleClick(a).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void dragAndDropByXpath(String source, String dest) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementByXPath(source);
		 WebElement b = driver.findElementByXPath(dest);
		 act.dragAndDrop(a, b).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
 public void dragAndDropById(String source, String dest) {
	 try {
		Actions act = new Actions(driver);
		 WebElement a = driver.findElementById(source);
		 WebElement b = driver.findElementById(dest);
		 act.dragAndDrop(a, b).perform();
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("Window is not present");
	}finally {
		takeSnap();
	}
 }
}

