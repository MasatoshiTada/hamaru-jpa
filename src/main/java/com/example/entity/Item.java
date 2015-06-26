package com.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tada
 */
@Entity
@Table(name = "T_ITEM")
@Getter @Setter
@NamedEntityGraph(name = "Item.hoge", includeAllAttributes = true)
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    private String name;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
