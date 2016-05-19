package biz.znamya.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import biz.znamya.dao.interfaces.GenderDAO;
import biz.znamya.entities.Gender;

import java.util.List;

@Component
public class GenderDAOImpl implements GenderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Gender> getGenders() {
        return sessionFactory.getCurrentSession().createCriteria(Gender.class).list();
    }





}
