import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.example.main.pojo.BaseApi;
import org.example.main.pojo.DiscApi;
import org.example.main.pojo.DiskResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class YandexDiskTest extends BaseApi {
    DiscApi discApi = new DiscApi();
    DiskResponse diskResponse = new DiskResponse();

    @Before
    public void setUp() {
        openUri();
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание новой папки")
    public void createFolderTest() {
        Response status = discApi.createFolder();
        diskResponse.statusCreated(status);
        diskResponse.bodyResponseCreatedFile(status);
    }

    @After
    public void closed() {
        discApi.deleteFolder();
    }
}
