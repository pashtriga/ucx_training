package com.ucx.training.demo.entity;

import com.ucx.training.demo.type.RecordStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel<Integer>{

    private String name;
    private BigDecimal unitPrice;
    private Boolean inStock;

    @Builder
    public Product(Integer id, RecordStatus recordStatus, String name, BigDecimal unitPrice, Boolean inStock){
        super(id, recordStatus);
        this.name = name;
        this.unitPrice = unitPrice;
        this.inStock = inStock;

    }


}
