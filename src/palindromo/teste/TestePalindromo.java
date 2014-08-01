package palindromo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import palindromo.Palindromo;

public class TestePalindromo {

	@Test
	public void verificaPalindromoTest(){
		
		String frase = "Anotaram a data da maratona";
		
		Palindromo palindromo = new Palindromo();
		Boolean resultado = palindromo.ehPalindromo(frase);
		
		assertEquals(true, resultado);
	}
	
}
