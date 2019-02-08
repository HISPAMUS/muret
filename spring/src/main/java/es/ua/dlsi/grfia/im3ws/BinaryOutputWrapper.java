package es.ua.dlsi.grfia.im3ws;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

// See https://stackoverflow.com/questions/27952949/spring-rest-create-zip-file-and-send-it-to-the-client
public class BinaryOutputWrapper {
    private HttpHeaders headers;
    private byte[] data;

    public BinaryOutputWrapper(String contentType) {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    }

    public void setFilename(String filename) {
        headers.setContentDispositionFormData(filename, filename);
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
