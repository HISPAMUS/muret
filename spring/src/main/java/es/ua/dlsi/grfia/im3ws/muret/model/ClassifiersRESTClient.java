package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible of handling the REST API calls to servers
 */
public class ClassifiersRESTClient {
    private static final String SLASH = "/";
    String restServerURL;

    /**
     */
    public ClassifiersRESTClient(String restServerURL) {
        if (!restServerURL.endsWith(SLASH)) {
            this.restServerURL = restServerURL + SLASH;
        } else {
            this.restServerURL = restServerURL;
        }

    }

    private String getURL(String endpoint) {
        if (endpoint.startsWith(SLASH)) {
            return this.restServerURL + endpoint.substring(1);
        } else {
            return this.restServerURL + endpoint;
        }
    }
    /**
     *
     * @param responseType
     * @param <T>
     */
    public <T> T get(String endpoint, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        String url = getURL(endpoint);

        T result = restTemplate.getForObject(url, responseType);
        Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Result of GET {0}={1}", new Object[]{url, result});
        return result;
    }

    /**
     *
     * @param responseType
     * @param <T>
     */
    public <T> T post(String endpoint, Class<T> responseType, Map<String, Object> postContent) throws IM3WSException {
        RestTemplate restTemplate = new RestTemplate();
        String url = getURL(endpoint);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        if (postContent != null) {
            postContent.forEach((k, v) -> body.add(k, v));
        }

        try {
            T result = restTemplate.postForObject(url, body, responseType);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Result of POST {0}={1}", new Object[]{url, result});
            return result;
        } catch (Throwable t) {
            throw new IM3WSException(t);
        }
    }

    /**
     *
     * @param endpoint It must not start with slash
     * @return
     */
    public ResponseEntity<String> uploadFileWithPOST(String endpoint, String imageFieldName, Path filePath, Map<String, Object> otherParameters) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        String url = getURL(endpoint);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add(imageFieldName, new FileSystemResource(filePath));
        if (otherParameters != null) {
            otherParameters.forEach((k, v) -> body.add(k, v));
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response;
    }

}
