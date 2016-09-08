package hu.schonherz.training.venue.vo;

import java.io.Serializable;

public class TypeVo implements Serializable {

    private static final long serialVersionUID = 729312L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TypeVo typeVo = (TypeVo) o;

        if (!id.equals(typeVo.id)) {
            return false;
        }
        return name.equals(typeVo.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
