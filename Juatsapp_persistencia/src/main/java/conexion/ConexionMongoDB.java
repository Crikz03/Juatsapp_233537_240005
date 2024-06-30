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
import excepciones.PersistenciaException;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class ConexionMongoDB implements AutoCloseable {

    private final MongoClient mongoClient;
    private final CodecRegistry codecRegistry;
    private final String databaseName;

    public ConexionMongoDB(MongoClient mongoClient, CodecRegistry codecRegistry, String databaseName) {
        this.mongoClient = mongoClient;
        this.codecRegistry = codecRegistry;
        this.databaseName = databaseName;
    }

    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(databaseName).withCodecRegistry(codecRegistry);
<<<<<<< HEAD
=======
    }

    @Override
    public void close() {
        mongoClient.close();
>>>>>>> parent of bd69515 (Revert "Merge branch 'Carlos' into Chris")
    }
}
