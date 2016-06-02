package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.Brand;
import ru.kpfu.itis.leontjev.warranty_department.repository.BrandRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.BrandService;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;

    @Override
    @Transactional
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    @Transactional
    public Brand delete(long id) {
        Brand brand = brandRepository.findOne(id);
        brandRepository.delete(brand);
        return brand;
    }

    @Override
    @Transactional
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    @Transactional
    public Brand update(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    @Override
    @Transactional
    public Brand findById(long id) {
        return brandRepository.findOne(id);
    }

    @Override
    public List<Brand> findAllByOrderByNameAsc() {
        return brandRepository.findAllByOrderByNameAsc();
    }
}
