package biz.znamya.objects;


import biz.znamya.entities.Clothes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import biz.znamya.entities.Gender;
import biz.znamya.enums.SearchType;

import java.io.Serializable;

@Component
@Scope("singleton")
public class SearchCriteria implements Serializable{

    private String text;

    private SearchType searchType = SearchType.TITLE;

    private Gender gender;

    private Clothes clothes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}
