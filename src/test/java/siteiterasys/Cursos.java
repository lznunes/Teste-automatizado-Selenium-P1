// 1. Pacotes
package siteiterasys;




//2. Bibliotecas
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// 3 - Classes
public class Cursos {
	// 3.1 Atributos / caracteristicas
	String url; //endereço site alvo
	WebDriver driver; // objeto do Selenium WebDriver
	
	// 3.2 Métodos ou Funções
	@Before
	public void iniciar() {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\nunesnel\\aula\\iterasys-workspace\\Site\\drives\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS); //tempo de espera
		driver.manage().window().maximize(); // maximizar janela
		
	}
	
	
	@After
	public void finalizar() {
		driver.quit(); //destruir selenium
	}
	
	@Test
	public void consultarCurso() {
		//Pagina inicial
		driver.get(url); //abrir o navegador na pagina indicada na url
		driver.findElement(By.id("searchtext")).clear(); //traz o elemento e limpa a caixa
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis")); //digita palava letra por letra
		// tirar o screenshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER); //pressiona a  tecla ENTER
		
		//Pagina que lista os curso
		driver.findElement(By.cssSelector("span.comprar")).click(); //clica no botao
		
		//Pagina do Carrinho de Compra
		//Resultado Esperado
		String  titulo = "Mantis";
		String  preco = "R$ 22,90";
		
		//assertEquals(ResultadoEsperado, resultadoAtual)
		assertEquals(titulo,driver.findElement(By.cssSelector("span.item-title")).getText()); //localizar valor e comparar
		assertEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());
	}
}
