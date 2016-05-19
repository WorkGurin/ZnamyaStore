package biz.znamya.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import biz.znamya.dao.interfaces.ModelDAO;
import biz.znamya.entities.Clothes;
import biz.znamya.entities.Model;
import biz.znamya.entities.Gender;
import biz.znamya.enums.SearchType;

import java.util.List;

@Component("znamyaFacade")
@Scope("singleton")
public class ZnamyaFacade {

    private static final String FIELD_CONTENT = "content";


    @Autowired
    private ModelDAO modelDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Model> models;


    public List<Model> getModels() {
        if (models == null){
            models = modelDAO.getModels();
        }
        return models;
    }


    public void searchModelsByGender() {
        models = modelDAO.getModels(searchCriteria.getGender());
    }

    public void searchModelsByClothes() {
        models = modelDAO.getModels(searchCriteria.getClothes());
    }

    public void searchModelsByText() {

        switch (searchCriteria.getSearchType()){
            case TITLE:
                models = modelDAO.getModels(searchCriteria.getText());
                break;
        }

    }

    public byte[] getContent(long id){
        return (byte[])modelDAO.getFieldValue(id, FIELD_CONTENT);
    }



}
