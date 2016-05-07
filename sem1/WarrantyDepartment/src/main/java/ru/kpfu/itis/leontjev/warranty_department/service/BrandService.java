package ru.kpfu.itis.leontjev.warranty_department.service;


import ru.kpfu.itis.leontjev.warranty_department.entity.Brand;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface BrandService {
    Brand create(Brand brand);
    Brand delete(long id);
    List<Brand> findAll();
    Brand update(Brand brand);
    Brand findById(long id);
}
