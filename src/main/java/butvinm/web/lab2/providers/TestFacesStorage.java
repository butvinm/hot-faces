package butvinm.web.lab2.providers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import butvinm.web.lab2.FacesStorage;


public class TestFacesStorage implements FacesStorage {
    private final Map<String, String> faces = new HashMap<>();

    public TestFacesStorage() {
        faces.put("./a.xhtml", "Bad file!");
        faces.put("./b.xhtml", "Bad file!");
    }

    @Override
    public Optional<String> getFaceContent(String faceName) {
        return Optional.ofNullable(faces.get(faceName));
    }

    @Override
    public void setFaceContent(String faceName, String content) {
        faces.put(faceName, content);
    }

    @Override
    public List<String> getFaces() {
        return List.copyOf(faces.keySet());
    }

}
