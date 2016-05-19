package biz.znamya.dao.interfaces;


import biz.znamya.entities.Clothes;
import biz.znamya.entities.Model;
import biz.znamya.entities.Gender;

import java.util.List;


public interface ModelDAO {

    List<Model> getModels();
    List<Model> getModels(Clothes clothes);
    List<Model> getModels(String modelName);
    List<Model> getModels(Gender gender);
    Object getFieldValue(Long id, String fieldName);

}
