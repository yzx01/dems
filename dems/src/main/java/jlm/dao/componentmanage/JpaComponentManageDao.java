package jlm.dao.componentmanage;

import jlm.dao.JpaDao;
import jlm.entity.BlogPost;
import jlm.entity.ComponentManage;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class JpaComponentManageDao extends JpaDao<ComponentManage, Long> implements ComponentManageDao {

    public JpaComponentManageDao()
    {
        super(ComponentManage.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComponentManage> findAll()
    {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<ComponentManage> criteriaQuery = builder.createQuery(ComponentManage.class);

        Root<ComponentManage> root = criteriaQuery.from(ComponentManage.class);
        criteriaQuery.orderBy(builder.desc(root.get("id")));

        TypedQuery<ComponentManage> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
