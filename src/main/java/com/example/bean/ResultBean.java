package com.example.bean;

import com.example.entity.Order;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tada
 */
@Named
@ViewScoped
public class ResultBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter @Setter
    private List<Order> orders;
    
    @Getter @Setter
    Long time;
    
    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash();
        orders = (List<Order>) flash.get("orders");
        time = (Long) flash.get("time");
    }
    
}
