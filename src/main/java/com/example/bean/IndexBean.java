package com.example.bean;

import com.example.entity.Order;
import com.example.service.OrderService;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tada
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private OrderService orderService;
    
    public String send() {
        long start = System.currentTimeMillis();
        List<Order> orders = orderService.listOrders();
        long time = System.currentTimeMillis() - start;
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash();
        flash.put("orders", orders);
        flash.put("time", time);
        return "result.xhtml?faces-redirect=true";
    }
}
