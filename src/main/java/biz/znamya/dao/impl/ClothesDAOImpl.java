package biz.znamya.dao.impl;

import biz.znamya.dao.interfaces.ClothesDAO;
import biz.znamya.entities.Clothes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClothesDAOImpl implements ClothesDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Clothes> getClothes() {
        return sessionFactory.getCurrentSession().createCriteria(Clothes.class).list();
    }





}
