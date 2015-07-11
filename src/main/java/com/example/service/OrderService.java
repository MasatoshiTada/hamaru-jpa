package com.example.service;

import com.example.entity.Item;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author tada
 */
@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class OrderService implements Serializable {
    @Inject
    private EntityManager em;
    
    public List<Order> listOrders() {
        EntityGraph<Order> rootOrderGraph = em.createEntityGraph(Order.class);
        Subgraph<OrderItem> orderItemSubgraph = rootOrderGraph.addSubgraph("orderItems");
        Subgraph<Item> itemSubgraph = orderItemSubgraph.addSubgraph("item");
        
        TypedQuery<Order> query = em.createQuery(
                "SELECT DISTINCT o FROM Order o ORDER BY o.id", 
                Order.class);
        query.setHint("javax.persistence.fetchgraph", rootOrderGraph);
        List<Order> orders = query.getResultList();
        return orders;
    }
}
