/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class ConexionMongoDB implements AutoCloseable {

    private static MongoClient mongoClient = null;

    private static final String url = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "Juatsapp";

    private ConexionMongoDB() {
    }

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(url))
                    .codecRegistry(pojoCodecRegistry).build();

            mongoClient = MongoClients.create(clientSettings);
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    @Override
    public void close() {
        mongoClient.close();
    }
}
