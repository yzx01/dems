package jlm.dao.assertmain;

import jlm.dao.JpaDao;
import jlm.entity.AssertMaintain;
import jlm.entity.BlogPost;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public class JpaAssertMaintainDao extends JpaDao<AssertMaintain,Long> implements AssertMaintainDao {

    public JpaAssertMaintainDao() {
        super(AssertMaintain.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssertMaintain> findAll(){
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<AssertMaintain> criteriaQuery = builder.createQuery(AssertMaintain.class);

        Root<AssertMaintain> root = criteriaQuery.from(AssertMaintain.class);
        criteriaQuery.orderBy(builder.desc(root.get("id")));

        TypedQuery<AssertMaintain> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
