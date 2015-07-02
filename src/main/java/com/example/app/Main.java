package com.example.app;

import com.example.entity.Order;
import com.example.entity.OrderItem;
//import com.example.entity.OrderItem_;
//import com.example.entity.Order_;
import java.util.List;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Subgraph;

/**
 *
 * @author tada
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("samplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        EntityGraph<Order> rootOrderGraph = em.createEntityGraph(Order.class);
//        rootOrderGraph.addSubgraph(Order_.orderItems)
//                .addSubgraph(OrderItem_.item);
        rootOrderGraph.addSubgraph("orderItems")
                .addSubgraph("item");
        
        List<Order> orders = em.createQuery(
                "SELECT o FROM Order o ORDER BY o.id", 
                Order.class)
                .setHint("javax.persistence.fetchgraph", rootOrderGraph)
                .getResultList();
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
