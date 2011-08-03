package brown.sample.dao.hibernate;

import brown.sample.dao.EmployeeDao;
import brown.sample.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public class EmployeeDaoImplTest extends BaseDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGet() {
        Employee employee = employeeDao.get(1);
        assertNotNull(employee);
        assertEquals("Bob", employee.getFirstName());

        assertNotNull("Company not found for employee", employee.getCompany());

        assertNotNull("Team not set for employee", employee.getTeam());
        assertEquals("Super team", employee.getTeam().getName());
    }

    @Test
    public void testGetNoCompanyOrTeam() {
        Employee employee = employeeDao.get(2);
        assertNotNull(employee);
        assertNull(employee.getCompany());
        assertNull(employee.getTeam());
    }
}
