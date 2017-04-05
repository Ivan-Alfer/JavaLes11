package by.home.les11.dbdao;

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
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class DBBaseDaoTest {
	
	protected IDataSet beforeData;
	
	private static Properties prop;
	
	protected static IDatabaseTester tester;
	
	protected IDatabaseConnection dbConn;

	protected abstract String getPath();
	
	@BeforeClass
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
	
	@Before
	public void setUp() throws Exception {		
		dbConn = getDbConnection();

		beforeData = new FlatXmlDataSetBuilder().build(new File(getPath()));
		tester.setDataSet(beforeData);

		DatabaseOperation.CLEAN_INSERT.execute(dbConn, beforeData);
	}
	
	@After
	public void closeConnection() throws SQLException{
		dbConn.close();
	}
}
