package brown.sample.dao.hibernate;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dao-test-context.xml")
public abstract class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IDatabaseConnection databaseConnection;

    @Before
    public void setUp() throws Exception {
        IDataSet dataSet = loadDataSet();
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
    }

    protected IDataSet loadDataSet() throws DataSetException {
        String name = "dbunit-dataset.xml";
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        if (stream == null) {
            throw new IllegalStateException("Dbunit file '" + name + "' does not exist");
        }
        return new FlatXmlDataSetBuilder().build(stream);
    }
}