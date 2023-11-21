package butvinm.web.lab2;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface FacesStorage {
    public Optional<String> getFaceContent(String faceName);

    public void setFaceContent(String faceName, String content);
}
