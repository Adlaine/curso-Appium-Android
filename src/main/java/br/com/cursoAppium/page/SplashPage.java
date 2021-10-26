package br.com.cursoAppium.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cursoAppium.core.BasePage;
import br.com.cursoAppium.core.DriverFactory;

public class SplashPage extends BasePage {
	
	public boolean isTelaSplashVisivel() {
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguardarSplashSumir() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}

}
