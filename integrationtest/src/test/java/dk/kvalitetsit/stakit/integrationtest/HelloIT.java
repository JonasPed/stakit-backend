package dk.kvalitetsit.stakit.integrationtest;

import org.junit.Test;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.StaKitApi;
import org.openapitools.client.model.HelloRequest;

import static org.junit.Assert.*;

public class HelloIT extends AbstractIntegrationTest {

    private final StaKitApi helloApi;

    public HelloIT() {
        var apiClient = new ApiClient();
        apiClient.setBasePath(getApiBasePath());

        helloApi = new StaKitApi(apiClient);
    }

    @Test
    public void testCallService() throws ApiException {
        var input = new HelloRequest();
        input.setName("John Doe");

        var result = helloApi.v1HelloPost(input);

        assertNotNull(result);
        assertEquals(input.getName(), result.getName());
        assertNull(result.getiCanBeNull());
        assertNotNull(result.getNow());
    }
}
