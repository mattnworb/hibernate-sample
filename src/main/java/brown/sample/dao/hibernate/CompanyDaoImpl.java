package brown.sample.dao.hibernate;

import brown.sample.dao.CompanyDao;
import brown.sample.domain.Company;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author: Matt Brown
 * @since: 8/3/11
 */
public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao {

    public Company get(long id) {
        return getHibernateTemplate().get(Company.class, id);
    }
}
