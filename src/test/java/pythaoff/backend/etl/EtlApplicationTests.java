package pythaoff.backend.etl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import javax.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.Before;
import org.junit.After;
/* import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
/* import pythaoff.backend.etl.Entity.Access;
import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Entity.Permission;
import pythaoff.backend.etl.Entity.Person;
import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.DimAccessRepository;
import pythaoff.backend.etl.Repository.DimPermissionRepository;
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.PermissionRepository;
import pythaoff.backend.etl.Repository.PersonRepository;
 */

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
@Transactional
@Rollback
class EtlApplicationTests {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Test
	void contextLoads() {
	}

	@Before
	public void setUp() {
	  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	  driver = new ChromeDriver();
	  js = (JavascriptExecutor) driver;
	  vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
	  driver.quit();
	}
	
	@Test
	public void TestConclusao() {
	  driver.get("https://login.microsoftonline.com/cf72e2bd-7a2b-4783-bdeb-39d57b07f76f/oauth2/authorize?client_id=871c010f-5e61-4fb1-83ac-98610a7e9110&response_type=code%20id_token&scope=openid%20profile%20offline_access&state=OpenIdConnect.AuthenticationProperties%3Dx9LZjNZvU3dpejMfr3XoYYi3ZfOJ9KLMWHKve16Vo0IC8keNxmZTLm2jkKdcGLrRQKjr1mrFWqss7bZrv0jZ2FRS5gPcLeszDnifaBhBzc9JF0bxXmGYZ8f4J4H02AB0lRD5GHtqWSDH10nnD0FscQvAIxyHmk4K3-cwYCDpYfPtw4IPH_tHd63w9eD3VdSstiA-Sb_tR-A4gq1X-xq3OtC_YTYCeput6fHkg0WVA-HxCDqE2GUdV1PDa8P2MBVwzMT0KSvdQEArzRvFAbcjvW-_j_8igPajHe4vZbjuhrXH099lT2UdEr9rKHuDqxTsvaI0VWLiJdptYdKRRdRzoA&response_mode=form_post&nonce=637730221967367395.MjAxM2ZiMDctODFhMC00YzkwLWE0MmEtMTYxZGQyODNlYzMwYjUwMGVjYmMtMWYwYS00MzYyLTk2NDctNGEwOTZiMDhlM2Zj&site_id=500453&redirect_uri=https%3A%2F%2Fapp.powerbi.com%2Flinks%2FaghgMkbRgr%3Fctid%3Dcf72e2bd-7a2b-4783-bdeb-39d57b07f76f%26pbi_source%3DlinkShare&post_logout_redirect_uri=https%3A%2F%2Fapp.powerbi.com%2Flinks%2FaghgMkbRgr%3Fctid%3Dcf72e2bd-7a2b-4783-bdeb-39d57b07f76f%26pbi_source%3DlinkShare&resource=https%3A%2F%2Fanalysis.windows.net%2Fpowerbi%2Fapi&nux=1&x-client-SKU=ID_NET461&x-client-ver=5.6.0.0&sso_reload=true");
	  driver.manage().window().setSize(new Dimension(1006, 522));
	  driver.findElement(By.cssSelector(".tile-container:nth-child(2) .text-left > div")).click();
	  driver.findElement(By.id("i0118")).sendKeys("Gu22092012!");
	  driver.findElement(By.id("i0118")).click();
	  driver.findElement(By.cssSelector(".win-scroll")).click();
	  driver.findElement(By.id("idSIButton9")).click();
	  System.out.printf("TESTE_HERE");

	  driver.findElement(By.cssSelector(".visualContent:nth-child(5) tspan")).click();

	  
	}
}
