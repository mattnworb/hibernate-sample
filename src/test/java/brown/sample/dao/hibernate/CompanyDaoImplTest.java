package brown.sample.dao.hibernate;

import brown.sample.dao.CompanyDao;
import brown.sample.domain.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public class CompanyDaoImplTest extends BaseDaoTest {

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testGet() {
        Company company = companyDao.get(1);
        assertNotNull(company);
        assertEquals("Spacetek", company.getName());
        assertEquals(2, company.getEmployees().size());
    }

    @Test
    public void testGetCompanyWithNoEmployees() {
        Company company = companyDao.get(2);
        assertNotNull(company);
        assertNotNull(company.getEmployees());
        assertTrue(company.getEmployees().isEmpty());
    }
}
