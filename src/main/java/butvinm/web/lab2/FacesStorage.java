package butvinm.web.lab2;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface FacesStorage {
    public Optional<String> getFaceContent(String faceName);

    public void setFaceContent(String faceName, String content);

    public List<String> getFaces();

    public static String normalizeFaceName(String faceName) {
        if (!faceName.endsWith(".xhtml")) {
            faceName = faceName.concat(".xhtml");
        }
        if (faceName.startsWith("/")) {
            faceName = faceName.substring(1);
        }
        return faceName;
    }
}
