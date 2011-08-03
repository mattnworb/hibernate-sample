package brown.sample.dao;

import brown.sample.domain.Employee;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public interface EmployeeDao {
    Employee get(long id);
}
