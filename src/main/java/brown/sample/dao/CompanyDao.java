package brown.sample.dao;

import brown.sample.domain.Company;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public interface CompanyDao {

    Company get(long id);
}
