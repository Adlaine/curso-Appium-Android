package cursoAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class FormularioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Cursos\\cursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Selecionar formulário
		List<MobileElement> elementosEncontrado = driver.findElements(By.className("android.widget.TextView"));

		elementosEncontrado.get(1).click();
		// escrever nome
		MobileElement campoName = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoName.sendKeys("Adlaine");
		//checar nome
		String text = campoName.getText();
		Assert.assertEquals("Adlaine", text);
		driver.quit();
	}
}
