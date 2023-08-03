package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastroUsuarioTest.csv")

public class CadastroUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp(){
        navegador = Web.createChorme();
    }
    @Test
    public void testAdicionarInformacaoDoUsuario(@Param(name="primeironome")String primeironome,
                                                 @Param(name="sobrenome")String sobrenome,
                                                 @Param(name="email")String email,
                                                 @Param(name="senha")String senha,
                                                 @Param(name="confirmarsenha")String confirmarsenha)
    {
        //Clicar no botão Criar conta
        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/form/div[3]/div[2]/button")).click();

        //Inclusão dos dados do cadastro
        navegador.findElement(By.id("first_name")).sendKeys(primeironome);
        navegador.findElement(By.id("last_name")).sendKeys(sobrenome);
        navegador.findElement(By.id("email")).sendKeys(email);
        navegador.findElement(By.id("password1")).sendKeys(senha);
        navegador.findElement(By.id("password2")).sendKeys(confirmarsenha);
        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/form/div[6]/label/span")).click();
        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/form/div[7]/label/span")).click();

        //Print dos dados informados
        String screenshotArquivo = "C:\\Users\\HP\\IdeaProjects\\test-report\\" + Generator.dataHoraParaArquivo() + "Dados Informados.png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //Clicar no botão Cadastrar
        navegador.findElement((By.xpath("//*[@id=\"__next\"]/div/section/div/form/div[8]/button"))).click();

        // Clicar no botão Ir para início.
        navegador.findElement((By.xpath("//*[@id=\"__next\"]/div/section/div/div[2]/div[2]/div/button"))).click();
    }

    /*@After
    public void tearDown(){
        navegador.close();
    }*/
}
