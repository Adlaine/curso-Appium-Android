package br.com.cursoAppium.page;

import br.com.cursoAppium.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}

	public void acessarSplash() {
		clicarPorTexto("Splash");
		
	}

}
