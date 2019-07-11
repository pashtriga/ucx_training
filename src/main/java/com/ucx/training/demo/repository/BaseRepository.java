package com.ucx.training.demo.repository;

import com.ucx.training.demo.entity.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseModel<U>, U> extends JpaRepository<T, U> {
}
