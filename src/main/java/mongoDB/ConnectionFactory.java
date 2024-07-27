/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 *
 * @author Wesley
 */
public class ConnectionFactory {   
    
    public static MongoClient getMongoClient(){
        Properties props = loadProperties();
        String uri = props.getProperty("mongouri");        
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)                
                .build();
        // Create a new client and connect to the server
        MongoClient mongoClient = MongoClients.create(settings);       
        return mongoClient; 
    }
    
    private static Properties loadProperties(){
        //try (FileInputStream fs = new FileInputStream("C:\\Program Files\\JavaApplicationGaragem\\properties\\db.properties")){
        try (FileInputStream fs = new FileInputStream("C:\\Users\\Wesley\\Documents\\NetBeansProjects\\properties\\db.properties")){ 
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
}
