package butvinm.web.lab2.loader;

import java.net.URL;

import jakarta.faces.application.ViewResource;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/* From Mojarra */
@Getter
@Setter
@RequiredArgsConstructor
public class FaceResource extends ViewResource {
    public static final String COMPONENT_RESOURCE_KEY = "jakarta.faces.application.Resource.ComponentResource";

    @NonNull
    private URL url;

    private String contentType;
    private String libraryName;
    private String resourceName;

    @Override
    public URL getURL() {
        return this.url;
    }

    // public abstract InputStream getInputStream() throws IOException;

    // public abstract Map<String, String> getResponseHeaders();

    // public abstract String getRequestPath();

    // public abstract boolean userAgentNeedsUpdate(FacesContext context);
}
