package br.com.cursoAppium.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTeste;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.page.SplashPage;

public class SplashTest extends BaseTeste {
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		menu.acessarSplash();
		page.isTelaSplashVisivel();
		page.aguardarSplashSumir();
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}
	

}
