package brown.sample.dao.hibernate;

import brown.sample.dao.EmployeeDao;
import brown.sample.domain.Employee;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    public Employee get(long id) {
        return getHibernateTemplate().get(Employee.class, id);
    }
}
