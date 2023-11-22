package butvinm.web.lab2;

import com.mongodb.client.MongoClients;

import butvinm.web.lab2.providers.TestFacesStorage;
import butvinm.web.lab2.providers.mongo.MongoFacesStorage;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import lombok.val;

@Dependent
public class FacesStorageProvider {
    @Produces
    public FacesStorage getMongoStorage() {
        // val client = MongoClients.create(Config.MONGODB_URL);
        // return new MongoFacesStorage(client, Config.MONGODB_DATABASE);
        return new TestFacesStorage();
    }
}
