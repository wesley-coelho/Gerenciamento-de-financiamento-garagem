/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongoDB;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class CrudMongoDB { 
    private static final String DATABASE_NAME = "garagem7curvas";
    
    
    public static InsertOneResult add(String collectionName, Document doc){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).insertOne(doc);
        }
         
    }
    
    public static InsertManyResult addMany(String collectionName, List<Document> docs){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).insertMany(docs);
        }
         
    }
    
    public static DeleteResult delete( String collectionName, Document doc){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).deleteOne(doc);
        }
         
    }
    
    public static Document search(String collectionName, Bson customFilter){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).find().filter(customFilter).first();
        }
         
    }
    
    
     public static List<Document> searchAll(String collectionName){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            FindIterable<Document> iterator = database.getCollection(collectionName).find();
            List<Document> lista =  new ArrayList<>();
            return iterator.into(lista);
        }
         
    }
     
      public static List<Document> searchAll(String collectionName, Bson customFilter, String field){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            FindIterable<Document> iterator = database.getCollection(collectionName).find().filter(customFilter).sort(Sorts.ascending(field));
            List<Document> lista =  new ArrayList<>();
            return iterator.into(lista);
        }
         
    }
      
      public static List<Document> searchAll(String collectionName, Bson customFilter){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            FindIterable<Document> iterator = database.getCollection(collectionName).find().filter(customFilter);
            List<Document> lista =  new ArrayList<>();
            return iterator.into(lista);
        }
         
    }
     
         
    public static Document searchById(String collectionName, ObjectId id){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).find().filter(Filters.eq("_id", id)).first();
        }
         
    }
    
    public static UpdateResult replaceDocument(String collectionName, ObjectId id, Document doc){
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).replaceOne(Filters.eq(id), doc);
        }   
    
    }
    
    public static UpdateResult SearchAndUpdateOne(String collectionName, ObjectId id, Bson fieldToUpdate) {
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            Bson doc =  database.getCollection(collectionName).find().filter(Filters.eq("_id", id)).first();
            if ( doc != null ){
                return database.getCollection(collectionName).updateOne(doc, new Document("$set",fieldToUpdate));                
            } 
            return null;
        }         
    }
    
    public static Document searchByFieldValue(String collectionName, String field, Object value) {
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).find().filter(Filters.eq(field, value)).first();
        }
         
    }
    
    public static Document autenticaUsuario(String collectionName, String user, String password) {
        try (MongoClient client = ConnectionFactory.getMongoClient()) {
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database.getCollection(collectionName).find().filter(Filters.and(Filters.eq("usuario", user), Filters.eq("senha", password))).first();
        }        
         
    }
    
    public static MongoDatabase getDatabase(){
        try {
            MongoClient client = ConnectionFactory.getMongoClient();
            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            return database;
        }catch( MongoException ex){
        ex.printStackTrace();
        }
         return null;
    }
       
}
