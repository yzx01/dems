package jlm.dao.assertmonthoperation;

import jlm.dao.JpaDao;
import jlm.entity.AssertMonthOperation;
import jlm.entity.BlogPost;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class JpaAssertMonthOperationDao extends JpaDao<AssertMonthOperation,Long> implements AssertMonthOperationDao{

    public JpaAssertMonthOperationDao()
    {
        super(AssertMonthOperation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssertMonthOperation> findAll()
    {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<AssertMonthOperation> criteriaQuery = builder.createQuery(AssertMonthOperation.class);

        Root<AssertMonthOperation> root = criteriaQuery.from(AssertMonthOperation.class);
        criteriaQuery.orderBy(builder.desc(root.get("id")));

        TypedQuery<AssertMonthOperation> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
