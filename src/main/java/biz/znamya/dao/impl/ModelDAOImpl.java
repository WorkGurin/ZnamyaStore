package biz.znamya.dao.impl;

import biz.znamya.dao.interfaces.ModelDAO;
import biz.znamya.entities.Clothes;
import biz.znamya.entities.Gender;
import biz.znamya.entities.Model;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ModelDAOImpl implements ModelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList modelProjection;

    public ModelDAOImpl() {
        modelProjection = Projections.projectionList();
        modelProjection.add(Projections.property("id"), "id");
        modelProjection.add(Projections.property("name"), "name");
        modelProjection.add(Projections.property("image"), "image");
        modelProjection.add(Projections.property("gender"), "gender");
        modelProjection.add(Projections.property("clothes"), "clothes");
        modelProjection.add(Projections.property("rating"), "rating");
        modelProjection.add(Projections.property("voteCount"), "voteCount");
    }


    @Transactional
    public List<Model> getModels() {
        List<Model> models = createModelList(createModelCriteria());
        return models;
    }

    @Transactional
    public List<Model> getModels(Clothes clothes) {
        List<Model> models = createModelList(createModelCriteria().add(Restrictions.eq("clothes.id", clothes.getId())));
        return models;
    }

    @Transactional
    public List<Model> getModels(String modelName) {
        List<Model> models = createModelList(createModelCriteria().add(Restrictions.ilike("m.name", modelName, MatchMode.ANYWHERE)));
        return models;
    }

    @Transactional
    public List<Model> getModels(Gender gender) {
        List<Model> models = createModelList(createModelCriteria().add(Restrictions.eq("gender.id", gender.getId())));
        return models;
    }

    @Transactional
    public Object getFieldValue(Long id, String fieldName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Model.class);
        criteria.setProjection(Property.forName(fieldName));
        criteria.add(Restrictions.eq("id", id));
        return criteria.uniqueResult();

    }

    private DetachedCriteria createModelCriteria() {
        DetachedCriteria modelListCriteria = DetachedCriteria.forClass(Model.class, "m");
        createAliases(modelListCriteria);
        return modelListCriteria;
    }


    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("m.clothes", "clothes");
        criteria.createAlias("m.gender", "gender");
    }


    private List<Model> createModelList(DetachedCriteria modelListCriteria) {
        Criteria criteria = modelListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.desc("m.name")).setProjection(modelProjection).setResultTransformer(Transformers.aliasToBean(Model.class));
        return criteria.list();
    }


}
