package jlm.dao.assertkks;

import jlm.dao.JpaDao;
import jlm.entity.AssertKks;
import jlm.entity.AssertMaintain;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class JpaAssertKksDao extends JpaDao<AssertKks,Long> implements AssertKksDao {

    public JpaAssertKksDao() {
        super(AssertKks.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssertKks> findAll(){
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<AssertKks> criteriaQuery = builder.createQuery(AssertKks.class);

        Root<AssertKks> root = criteriaQuery.from(AssertKks.class);
        criteriaQuery.orderBy(builder.desc(root.get("id")));

        TypedQuery<AssertKks> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
