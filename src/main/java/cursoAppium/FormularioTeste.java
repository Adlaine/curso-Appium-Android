package cursoAppium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Appium.core.DSL;
import Appium.core.DriverFactory;
import io.appium.java_client.MobileBy;



public class FormularioTeste {
	private DSL dsl = new DSL();
	
	@Before
	public void InicializarAppium() throws MalformedURLException {
		// Selecionar formulário
		dsl.clicarPorTexto("Formulário");
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		// escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Adlaine");
		
		//checar nome
		assertEquals("Adlaine", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		// clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "XBox One");
		
		// verificar a opcao selecionada
		
		String texto = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("XBox One", texto);
	}
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
		//Verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		
		//clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		
		//verificar status alterado
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		// preencher campos
		dsl.escrever(By.className("android.widget.EditText"), "Adlaine");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "XBox One");

		
		// clicar salvar
		dsl.clicarPorTexto("SALVAR");
		
		// validar campos
		Assert.assertEquals("Nome: Adlaine", dsl.obterTexto((By.xpath("//android.widget.TextView[@text='Nome: Adlaine']"))));
		Assert.assertEquals("Console: xone", dsl.obterTexto((By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"))));
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
		
	}
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
}
