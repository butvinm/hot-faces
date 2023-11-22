package butvinm.web.lab2;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@ApplicationScoped
@Named
@Getter
@Setter
public class FacesBean {
    @Inject
    private FacesStorage storage;

    private String newFaceName;

    private String newFaceContent = "AAAAAAAAAAAAAAA";

    public void addFace() {
        newFaceName = FacesStorage.normalizeFaceName(newFaceName);
        storage.setFaceContent(newFaceName, newFaceContent);
    }

    public List<String> getFaces() {
        return storage.getFaces();
    }

    public void selectFace(String faceName) {
        val faceContent = storage.getFaceContent(faceName);
        if (faceContent.isPresent()) {
            newFaceName = faceName;
            newFaceContent = faceContent.get();
        }
    }
}
