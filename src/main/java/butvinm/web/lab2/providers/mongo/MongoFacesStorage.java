package butvinm.web.lab2.providers.mongo;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;

import butvinm.web.lab2.FacesStorage;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.val;

@ApplicationScoped
public class MongoFacesStorage implements FacesStorage, Closeable {
    private final static String COLLECTION_NAME = "collisions";

    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<Face> collection;

    @NonNull
    public MongoFacesStorage(MongoClient client, String database) {
        this.client = client;
        this.database = this.client.getDatabase(database);
        this.collection = this.database.getCollection(
            COLLECTION_NAME,
            Face.class
        );
    }

    @Override
    public List<String> getFaces() {
        val list = new ArrayList<String>();
        for (var item : this.collection.find()) {
            list.add(item.name());
        }
        return list;
    }

    @Override
    public Optional<String> getFaceContent(String faceName) {
        val query = Filters.eq("name", faceName);
        val result = this.collection.find(query).first();
        return Optional.ofNullable(result).map(Face::content);
    }

    @Override
    public void setFaceContent(String faceName, String content) {
        val filter = Filters.eq("name", faceName);
        val update = Updates.set("content", content);
        this.collection.updateOne(filter, update,
            new UpdateOptions().upsert(true));
    }

    @Override
    public void close() throws IOException {
        this.client.close();
    }
}
