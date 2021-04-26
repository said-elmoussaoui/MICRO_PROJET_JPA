package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class categories {
    private int refCat;
    private String cat;

    @Id
    @Column(name = "RefCat", nullable = false)
    public int getRefCat() {
        return refCat;
    }

    public void setRefCat(int refCat) {
        this.refCat = refCat;
    }

    @Column(name = "cat", nullable = true, length = 20)
    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        categories that = (categories) o;

        if (refCat != that.refCat) return false;
        if (cat != null ? !cat.equals(that.cat) : that.cat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refCat;
        result = 31 * result + (cat != null ? cat.hashCode() : 0);
        return result;
    }
}
