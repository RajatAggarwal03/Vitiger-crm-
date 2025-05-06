package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropFile 
{
    public static void main(String[] args) throws IOException 
    {
    	
 //     step -1 : Create java representation object of the physical file
    	FileInputStream fis = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\CommonData.properties");
        Properties pObj = new Properties();
       
 //     step-2 : By using load(), load all the keys
    	pObj.load(fis);
    	
  //    step-3 : By using getProperty(), get the values
    	String BROWSER = pObj.getProperty("bro");
    	System.out.println(BROWSER);
    	
        String URL = pObj.getProperty("url");
    	System.out.println(URL);
    	
    	String USERNAME= pObj.getProperty("un");
    	System.out.println(USERNAME);
    	
    	String PASSWORD = pObj.getProperty("pwd");
    	System.out.println(PASSWORD);
    	
    }
}
    	

