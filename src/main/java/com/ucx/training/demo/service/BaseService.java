package com.ucx.training.demo.service;

import com.ucx.training.demo.entity.BaseModel;
import com.ucx.training.demo.repository.BaseRepository;
import com.ucx.training.demo.type.RecordStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BaseService<T extends BaseModel<U>, U> {
    @Autowired
    private BaseRepository<T, U> baseRepository;

    public T save(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid argument: " + t);
        } else {
            return baseRepository.save(t);
        }
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public List<T> findAllSorted(String direction, String... properties) {
        if (!Arrays.asList("ASC", "DESC").contains(direction.toUpperCase())) {
            throw new IllegalArgumentException("Value must be either ASC or DESC: " + direction);

        }
        return baseRepository.findAll(Sort.by(Sort.Direction.valueOf(direction), properties));
    }

    public T update(T t, U u) {
        if (t == null) {
            throw new IllegalArgumentException(String.format("One of the arguments is invalid: %s", t));
        }
        T foundT = findById(u);
        if (foundT == null) {
            throw new RuntimeException("Entity not found");
        }

        BeanUtils.copyProperties(t, foundT, getNullPropertyNames(t));
        return foundT;
    }

    public T findById(U id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid argument: " + id);
        }
        Optional<T> optionalT = baseRepository.findById(id);
        return optionalT.orElse(null);
    }

    public void remove(U id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid argument: " + id);
        }
        T t = findById(id);
        if (t == null) {
            throw new RuntimeException("Entity not found");
        }

        t.setRecordStatus(RecordStatus.INACTIVE);
    }

    private static <T> String[] getNullPropertyNames(T source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public Page<T> findAllPaged(int pageNumber, int pageSize) {
        return baseRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("id")));
    }
}
