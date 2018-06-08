package meesho;

import java.io.Serializable;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class MessageServiceDAO {

    public synchronized void updateObject(MessageServiceBean entity) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.update(entity);
//            transaction.commit();
//        }
    }

    public MessageServiceBean getObject(Class entityClass, Serializable id) {
        MessageServiceBean object = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            object = session.get(entityClass, id);
//        }
        return object;
    }
}
