package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.ForceUserDao;
import com.hybrit.assessment.model.ForceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tim
 */
@Service
@Transactional(readOnly = true)
public class ForceUserServiceImpl implements ForceUserService {
        
        @Autowired
        private ForceUserDao forceUserDao;

        @Override
        public ForceUser find(int id) {
                return this.forceUserDao.find(id);
        }
}
