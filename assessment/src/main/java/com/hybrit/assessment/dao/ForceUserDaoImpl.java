package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.ForceUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim
 */
@Repository
public class ForceUserDaoImpl implements ForceUserDao {
        
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public ForceUser find(int id) {
                return this.sessionFactory.getCurrentSession().get(ForceUser.class, id);
        }
}
