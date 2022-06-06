package zensar.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class projectUtils {

	public static void jsonToMap() {
		
		// create instance of the ObjectMapper class to map JSON data  
        ObjectMapper mapper = new ObjectMapper();  
        // create instance of the File class   
        File fileObj = new File("D:\\eclipse_api_workspace\\zensar.restapi\\src\\main\\java\\zensar\\utils\\Sample.json");  
        // use try-catch block to convert JSON data into Map  
        try {  
            // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes  
            Map<String, Object> userData = mapper.readValue(  
                    fileObj, new TypeReference<Map<String, Object>>(){});   
            // print all key-value pairs   
            System.out.println("Name : " + userData.get("Name"));  
            System.out.println("Mobile : " + userData.get("Mobile"));  
            System.out.println("Designation : " + userData.get("Designation"));  
            System.out.println("Pet : " + userData.get("Pet"));  
            System.out.println("Address : " + userData.get("Address"));   
            
            //mapper.readva
        } catch (Exception e) {  
            // show error message  
            e.printStackTrace();  
        }   
	}

	public static void readNode() {
		ObjectMapper mapper = new ObjectMapper();
        try {
            // reading json input from the file and mapping to object
            File jsonInputFile = new File("D:\\eclipse_api_workspace\\zensar.restapi\\src\\main\\java\\zensar\\utils\\Sample2.json");
             
           JsonNode rootNode = mapper.readTree(jsonInputFile);
           String dataJson  = rootNode.path("data1").toString();
           System.out.println(dataJson);
           
           File fileObj = new File("D:\\eclipse_api_workspace\\zensar.restapi\\src\\main\\java\\zensar\\utils\\Sample.json");  
           
           Map<String, Object> userData = mapper.readValue(dataJson, new TypeReference<Map<String, Object>>(){}); 
           
           System.out.println(userData.get("Name"));
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public static void main(String args[]) {
		//jsonToMap();
		readNode();
	}

	
	
}
