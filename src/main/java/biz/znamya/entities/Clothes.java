package biz.znamya.entities;


public class Clothes {
    private long id;
    private String view;

    public Clothes() {
    }

    public Clothes(String view) {
        this.view = view;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clothes clothes = (Clothes) o;

        if (id != clothes.id) return false;
        if (view != null ? !view.equals(clothes.view) : clothes.view != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (view != null ? view.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return view;
    }
}
