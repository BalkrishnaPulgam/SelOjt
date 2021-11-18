package seleniumListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class ListenerExSel implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("user navigating to new url :"+url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("user navigated to new url :"+url);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("user navigating to backward");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("user navigated to backward");

		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("user navigating to forward");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println("user navigated to forward");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("user finding an element");

		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println(" found an element");

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("user clicked on element");
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("user refreshing ");
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("user clicking on an element");
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("user refreshing window");
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("exception occured as "+throwable.getMessage());
		
	}

}
