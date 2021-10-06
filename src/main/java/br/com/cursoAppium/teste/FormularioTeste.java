package br.com.cursoAppium.teste;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTeste;
import br.com.cursoAppium.page.FormularioPage;
import br.com.cursoAppium.page.MenuPage;



public class FormularioTeste extends BaseTeste {
	
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	
	@Before
	public void InicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		formulario.escreverNome("Adlaine");
		assertEquals("Adlaine", formulario.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		formulario.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());
	}
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());
		
		formulario.clicarCheck();
		formulario.clicarSwitch();
		
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		formulario.escreverNome("Adlaine");
		formulario.clicarCheck();
		formulario.clicarSwitch();
		formulario.selecionarCombo("Nintendo Switch");

		formulario.salvar();
		
		Assert.assertEquals("Nome: Adlaine", formulario.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", formulario.obterConsoleCadastrado());
		Assert.assertTrue(formulario.obterCheckCadastrado().endsWith("Marcado"));
		Assert.assertTrue(formulario.obterSwitchCadastrado().endsWith("Off"));
	}
	

	
}
