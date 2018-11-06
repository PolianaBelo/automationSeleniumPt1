import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebPage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.trivago.com.br");
		
		WebElement campo = driver.findElement(By.name("sQuery"));
		campo.sendKeys("Natal");
		campo.submit();
		
		WebElement botaoQuartos = driver.findElement(By.className("horus__btn-detail--roomtype"));
		botaoQuartos.click();
		
		List<WebElement> botaoListaQuartos = driver.findElements(By.className("df_label"));
		botaoListaQuartos.get(0).click();
		
		Select dropDown = new Select(driver.findElement(By.name("mf-select-sortby")));
		dropDown.selectByValue("distance"); 
		
	    WebElement listaHoteis = driver.findElement(By.id("js_itemlist"));
	    List<WebElement> opcoes = listaHoteis.findElements(By.className("js_co_item"));
	    
	    int contador = 0;
	    for(WebElement opcao : opcoes) {
	    	
	    	contador++;
	    	
	    	if(contador == 2) {

	    		WebElement secao = opcao.findElement(By.tagName("h3"));
	    		System.out.println("Nome: "+secao.getText());
	    		List<WebElement> estrelas = opcao.findElements(By.className("item__stars-badges"));
	    		int totalEstrelas = estrelas.size();
	    		System.out.println("Estrelas: " +totalEstrelas);   	

	    		WebElement ofertas = opcao.findElement(By.className("deal-other__more--iela"));
	    		System.out.println(ofertas.getText());
	    	}	    	
	    }	
	}

}
