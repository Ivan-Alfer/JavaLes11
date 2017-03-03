package by.home.les11.dbresourcemanager;

import java.util.ResourceBundle;

public class DBResourceManager {
	
private static final DBResourceManager INSTANCE = new DBResourceManager();

public static final String DB_DRIVER = "db.driver";
public static final String DB_URL = "db.url";
public static final String DB_USER = "db.user";
public static final String DB_PASSWORD = "db.password";
	
	private ResourceBundle bundle;

	private DBResourceManager() {
		bundle = ResourceBundle.getBundle("resources.db");
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
	
	public static DBResourceManager getInstance(){
		return INSTANCE;
	}
}
