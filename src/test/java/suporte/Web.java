package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChorme(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\IdeaProjects\\Drivers\\chromedriver.exe");
        //comando para resolver o erro Unable to establish web socket connection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver navegador = new ChromeDriver(options);
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("https://frontend-lacrei-pessoa-usuaria.vercel.app/");

        return navegador;
    }
}
