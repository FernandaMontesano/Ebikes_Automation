package util;



import java.io.*;
import java.util.Properties;


public class PropertiesFileReader {
	private Properties properties;
	private final String systemPropertyFilePath= "src/test/resources/system/system.configuration.properties";
	
	public PropertiesFileReader(){
		BufferedReader reader;
		BufferedReader commonReader;
		try {
			reader = new BufferedReader(new FileReader(getEnvironmentPropertiesFilePath()));
			commonReader = new BufferedReader(new FileReader(systemPropertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				properties.load(commonReader);
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("system.properties not found at " + getEnvironmentPropertiesFilePath());
		}		
	}

	private String getEnvironmentPropertiesFilePath(){
		String env = "QA";

		//String env = properties.getProperty("env");

		if (env.equalsIgnoreCase("QA")) {
			return "src/test/resources/qa/qa.configuration.properties";
		}
		else if(env.equalsIgnoreCase("SIT")) {
			return "src/test/resources/sit/sit.configuration.properties";
		}
		else if(env.equalsIgnoreCase("UAT")){
			return "src/test/resources/uat/uat.configuration.properties";
		}
		else{
			return "src/test/resources/qa/qa.configuration.properties";		}
	}
		
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the system.properties file.");
	}
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if(browser != null) return browser;
		else throw new RuntimeException("Browser definition not found");
	}
	
	//Users
	public String getUserName() {
		String username = properties.getProperty("userName");
		if(username != null) return username;
		else throw new RuntimeException("username not specified in the properties file.");
	}

	public String getUserPassword() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the properties file.");
	}

}
