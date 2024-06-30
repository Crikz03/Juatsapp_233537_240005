/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import excepciones.ConexionException;
import excepciones.PersistenciaException;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author eljulls
 */
public class MongoClientFactory {

    private static final CodecRegistry POJO_CODEC_REGISTRY = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    public static MongoClient createMongoClient(String connectionString) {
        try {
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
                    .codecRegistry(POJO_CODEC_REGISTRY).build();

            return MongoClients.create(clientSettings);
        } catch (MongoException e) {
            throw new ConexionException("Error al conectar a la base de datos", e);
        }
    }

    public static ConexionMongoDB createConexionMongoDB(String connectionString, String databaseName) {
        MongoClient mongoClient = createMongoClient(connectionString);
        return new ConexionMongoDB(mongoClient, POJO_CODEC_REGISTRY, databaseName);
    }
}
