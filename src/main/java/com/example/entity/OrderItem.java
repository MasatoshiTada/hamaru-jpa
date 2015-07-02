package com.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "T_ORDER_ITEM")
@Getter @Setter
//@NamedEntityGraph(
//        name = "OrderItem.hoge",
//        attributeNodes = {
//            @NamedAttributeNode(value = "item", subgraph = "Item.hoge")
//        }
//)
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.OrderItem[ id=" + id + " ]";
    }
    
}
