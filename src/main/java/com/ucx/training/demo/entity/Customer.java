package com.ucx.training.demo.entity;

import com.ucx.training.demo.type.RecordStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseModel<Integer> {

    private String name;
    @Builder
    public Customer(Integer id, RecordStatus recordStatus, String name){
        super(id, recordStatus);
        this.name = name;
    }
}
