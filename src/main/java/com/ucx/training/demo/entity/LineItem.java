package com.ucx.training.demo.entity;

import com.ucx.training.demo.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineItem extends BaseModel<Integer> {

    @ManyToOne
    private Invoice invoice;

    @ManyToOne
    private Product product;
    private Integer quantity;

    public LineItem(Integer id, RecordStatus recordStatus, Invoice invoice, Product product, Integer quantity){
        super(id, recordStatus);
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }
}
