package jlm.dao.assertchanging;

import jlm.dao.JpaDao;
import jlm.entity.AssertChanging;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class JpaAssertChangingDao extends JpaDao<AssertChanging,Long> implements AssertChangingDao {

    public JpaAssertChangingDao() {
        super(AssertChanging.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssertChanging> findAll(){
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<AssertChanging> criteriaQuery = builder.createQuery(AssertChanging.class);

        Root<AssertChanging> root = criteriaQuery.from(AssertChanging.class);
        criteriaQuery.orderBy(builder.desc(root.get("id")));

        TypedQuery<AssertChanging> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();

    }
}
