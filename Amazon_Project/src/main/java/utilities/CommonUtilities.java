package utilities;

import org.openqa.selenium.WebDriver;

public class CommonUtilities {
	WebDriver driver ;
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void forceWait(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
