package biz.znamya.entities;

import java.util.Arrays;


public class Model implements java.io.Serializable {
    private long id;
    private Clothes clothes;
    private Gender gender;
    private String name;
    private byte[] image;
    private Integer rating;
    private Long voteCount;

    public Model(){}

    public Model(long id, Clothes clothes, Gender gender, String name, byte[] image, Integer rating, Long voteCount) {
        this.id = id;
        this.clothes = clothes;
        this.gender = gender;
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.voteCount = voteCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clothes getClothes() {
        return this.clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (!clothes.equals(model.clothes)) return false;
        if (!gender.equals(model.gender)) return false;
        if (!name.equals(model.name)) return false;
        if (!Arrays.equals(image, model.image)) return false;
        if (!rating.equals(model.rating)) return false;
        return voteCount.equals(model.voteCount);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + clothes.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + rating.hashCode();
        result = 31 * result + voteCount.hashCode();
        return result;
    }

}
