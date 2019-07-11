package com.ucx.training.demo.entity;

import com.ucx.training.demo.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;

}
