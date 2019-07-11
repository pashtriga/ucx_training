package com.ucx.training.demo.entity;

import com.ucx.training.demo.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends BaseModel<Integer>{

    private Integer invoiceNumber;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<LineItem> list = new ArrayList<>();

    private BigDecimal total;

    public Invoice(Integer id, RecordStatus recordStatus, Integer invoiceNumber, Customer customer, List<LineItem> list){
        super(id, recordStatus);
        this.invoiceNumber = invoiceNumber;
        this.customer = customer;
        this.list = list;
    }
}
