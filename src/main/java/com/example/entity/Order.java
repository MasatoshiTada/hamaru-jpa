package com.example.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tada
 */
@Entity
@Table(name = "T_ORDER")
@Getter @Setter
//@NamedEntityGraph(
//        name = "Order.hoge",
//        attributeNodes = {
//            @NamedAttributeNode(value = "orderItems", subgraph = "OrderItem.hoge")
//        }
//)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;

    @OneToMany(mappedBy = "order", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.Order[ id=" + id + " ]";
    }
    
}
