package test.by.home.les11.dbdaotest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class DBBaseDaoTestNg {
protected IDataSet beforeData;
	
	private static Properties prop;
	
	protected static IDatabaseTester tester;
	
	protected IDatabaseConnection dbConn;

	protected abstract String getPath();
	
	@BeforeSuite
	public static void takeConnection() throws Exception {
		prop = new Properties();
		try {
			prop.load(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/dbtest.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		tester = new JdbcDatabaseTester(prop.getProperty("db.driver"), prop.getProperty("db.url"),
				prop.getProperty("db.user"), prop.getProperty("db.password"));

		
	}
	
	protected static IDatabaseConnection getDbConnection() throws Exception{
		IDatabaseConnection dbConn = tester.getConnection();
		DatabaseConfig config = dbConn.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
		
		return dbConn;
	} 
	
	@BeforeMethod
	public void setUp() throws Exception {		
		dbConn = getDbConnection();

		beforeData = new FlatXmlDataSetBuilder().build(new File(getPath()));
		tester.setDataSet(beforeData);

		DatabaseOperation.CLEAN_INSERT.execute(dbConn, beforeData);
	}
	
	@AfterMethod
	public void closeConnection() throws SQLException{
		dbConn.close();
	}
}
