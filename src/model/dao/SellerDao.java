package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(model.entities.Seller obj);
    void update(model.entities.Seller obj);
    void deleteByID(Integer id);
    model.entities.Seller findById(Integer id);
    List<model.entities.Seller> findAll();
    List<Seller> findBYDepartment(Department department);
}
