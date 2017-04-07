package by.home.les11.dbdao;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Test;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Subject;

public class DBSubjectDaoTest extends DBBaseDaoTest {

	@Test
	public void testGetAll() throws SQLException, Exception {

		try (DBSubjectDao subjectDao = new DBSubjectDao(dbConn.getConnection());) {
			List<Subject> subjects = subjectDao.getItems();
			
			IDataSet databaseDataSet = dbConn.createDataSet();
			ITable actualTable = databaseDataSet.getTable("subject");

			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("test/datasetSubject.xml"));
			ITable expectedTable = expectedDataSet.getTable("subject");

			Assert.assertEquals(expectedTable.getRowCount(), subjects.size());

			String[] ignore = { "ID" };
			Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, ignore);
		}

	}

	@Override
	protected String getPath() {
		return "test/datasetSubject.xml";
	}

	@Test
	public void testAddSubject() throws DaoException, SQLException, DatabaseUnitException{
		try(DBSubjectDao subjectDao = new DBSubjectDao(dbConn.getConnection())){
			
			DatabaseOperation.DELETE_ALL.execute(dbConn, beforeData);
			
			Subject subject1 = new Subject("TestSubject1");
			Subject subject2 = new Subject("TestSubject2");
			Subject subject3 = new Subject("TestSubject3");
			Subject subject4 = new Subject("TestSubject4");
			
			List<Subject> expectedSubjects = new ArrayList<Subject>();
			expectedSubjects.add(subject4);
			expectedSubjects.add(subject3);
			expectedSubjects.add(subject2);
			expectedSubjects.add(subject1);
			
			subjectDao.addItem(subject1);
			subjectDao.addItem(subject2);
			subjectDao.addItem(subject3);
			subjectDao.addItem(subject4);
			
			List<Subject> actualSubjects = subjectDao.getItems();
			
			assertNotNull(actualSubjects);
			assertTrue(actualSubjects.size()==4);
			
			boolean testCompare = compareByName(actualSubjects, expectedSubjects);
			assertTrue(testCompare);
		}
	}

	private boolean compareByName(List<Subject> actualSubjects, List<Subject> expectedSubjects) {
		if (actualSubjects.size() != expectedSubjects.size()) {
			return false;
		}

		boolean isSubjectFound = true;
		for (Subject sub1 : actualSubjects) {
			if (!isSubjectFound) {
				return isSubjectFound;
			}
			isSubjectFound = false;
			for (Subject sub2 : expectedSubjects) {
				if (sub1.getSubjectName().equals(sub2.getSubjectName())) {
					isSubjectFound = true;
					break;
				}
			}
		}
		return isSubjectFound;
	}
	
	@Test
	public void testDeleteSubjec() throws DaoException, SQLException{
		try(DBSubjectDao subjectDao = new DBSubjectDao(dbConn.getConnection())){
			
			List<Subject> beforeDeleteSubjects = subjectDao.getItems();
			Subject deleteSubjec = beforeDeleteSubjects.get(3);
			
			subjectDao.deleteItem(deleteSubjec.getId());
			List<Subject> actualSubjects = subjectDao.getItems();
			
			assertTrue(actualSubjects.size()==3);
		}
	}
	
	@Test
	public void testUpdateSubject() throws DaoException, SQLException{
		try(DBSubjectDao subjectDao = new DBSubjectDao(dbConn.getConnection())){
			
			List<Subject> beforeUpdateSubjects = subjectDao.getItems();
			Subject updateSubjec = beforeUpdateSubjects.get(3);
			updateSubjec.setSubjectName("newSub");
			
			subjectDao.updateItem(updateSubjec);
			List<Subject> actualSubjects = subjectDao.getItems();
			Subject afterUpadteSubject = actualSubjects.get(3);
			
			if (afterUpadteSubject.equals(updateSubjec)){
				afterUpadteSubject.getSubjectName().equals(updateSubjec.getSubjectName());
			}
		
			assertEquals(afterUpadteSubject.getId(), updateSubjec.getId());
			assertEquals(afterUpadteSubject.getSubjectName(), updateSubjec.getSubjectName());
		}
	}
}
