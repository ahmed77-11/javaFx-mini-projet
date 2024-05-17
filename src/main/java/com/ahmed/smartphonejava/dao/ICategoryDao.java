package com.ahmed.smartphonejava.dao;

import java.util.List;

public interface ICategoryDao <T>{
    public List<T> getAllCategories();
    public T getCategoryById(int id);
}
