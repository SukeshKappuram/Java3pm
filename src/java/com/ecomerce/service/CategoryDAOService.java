/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.service;

import com.ecomerce.model.Category;
import java.util.List;

/**
 *
 * @author iamsu
 */
public interface CategoryDAOService {
    int create(Category c);
    Category read(Category c);
    List<Category> read();
    int update(Category c);
    int delete(Category c);
}
