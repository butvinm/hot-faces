package butvinm.web.lab2.loader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import butvinm.web.lab2.FacesStorage;
import jakarta.faces.application.ResourceHandler;
import jakarta.faces.application.ResourceHandlerWrapper;
import jakarta.faces.application.ViewResource;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import lombok.val;

public class FacesLoader extends ResourceHandlerWrapper {
    @Inject
    private FacesStorage storage;

    public FacesLoader(ResourceHandler wrapped) {
        super(wrapped);
    }

    @Override
    public ViewResource createViewResource(FacesContext context,
        String resourceName) {

        val resource = getWrapped().createViewResource(context, resourceName);
        if (resource != null) {
            return resource;
        }
        val face = loadFaceResource(resourceName);
        return face;
    }

    private FaceResource loadFaceResource(String resourceName) {
        resourceName = FacesStorage.normalizeFaceName(resourceName);
        val content = storage.getFaceContent(resourceName);
        if (content.isEmpty()) {
            return null;
        }
        val resourceUrl = createTempFile(resourceName, content.get());
        if (resourceUrl == null) {
            return null;
        }
        return new FaceResource(resourceUrl);
    }

    public URL createTempFile(String fileName, String content) {
        String tempDir = System.getProperty("java.io.tmpdir");
        File tempFile = new File(tempDir, fileName);
        try {
            tempFile.createNewFile();
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(content);
            }
            return tempFile.toURI().toURL();
        } catch (IOException e) {
            return null;
        }
    }
}
