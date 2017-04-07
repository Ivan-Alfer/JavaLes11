package test.by.home.les11.dbdaotest;




import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.dbdao.DBStudentDao;
import by.home.les11.dbdao.DBSubjectDao;
import by.home.les11.domain.Student;
import by.home.les11.domain.Subject;


@Test(groups = "checkStudentFunction")
public class DBStudentDaoTestNg extends DBBaseDaoTestNg{

	@Override
	protected String getPath() {
		return "test/datasetStudent.xml";
	}

	@Test
	public void testUpdateStudent() throws DaoException, SQLException{
		try(DBStudentDao studentDao = new DBStudentDao(dbConn.getConnection())){
			
			List<Student> beforeUpdateStudent = studentDao.getItems();
			Student updateStudent = beforeUpdateStudent.get(2);
			updateStudent.setFirstName("updateFirstName");
			updateStudent.setLastName("updateLastName");
			
			studentDao.updateItem(updateStudent);
			List<Student> actualStudent = studentDao.getItems();
			Student afterUpadteStudent = actualStudent.get(2);
		
			assertEquals(afterUpadteStudent.getId(), updateStudent.getId());
			assertEquals(afterUpadteStudent.getFirstName(), updateStudent.getFirstName());
			assertEquals(afterUpadteStudent.getLastName(), updateStudent.getLastName());
		}
	}
	
	@Test
	public void testDeleteStudent() throws DaoException, SQLException{
		try(DBStudentDao studentDao = new DBStudentDao(dbConn.getConnection())){
			
			List<Student> beforeDeleteStudents = studentDao.getItems();
			Student deleteStudent = beforeDeleteStudents.get(3);
			
			studentDao.deleteItem(deleteStudent.getId());
			List<Student> actualSubjects = studentDao.getItems();
			
			assertTrue(actualSubjects.size()==3);
		}
	}
	
	@Test
	public void testGetAll() throws SQLException, Exception {

		try (DBStudentDao studentDao = new DBStudentDao(dbConn.getConnection())) {
			List<Student> students = studentDao.getItems();
			
			IDataSet databaseDataSet = dbConn.createDataSet();
			ITable actualTable = databaseDataSet.getTable("student");

			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("test/datasetStudent.xml"));
			ITable expectedTable = expectedDataSet.getTable("student");

			Assert.assertEquals(expectedTable.getRowCount(), students.size());

			String[] ignore = { "ID" };
			Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, ignore);
		}

	}
}
