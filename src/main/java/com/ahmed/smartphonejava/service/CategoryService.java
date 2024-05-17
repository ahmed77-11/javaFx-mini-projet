package com.ahmed.smartphonejava.service;

import com.ahmed.smartphonejava.beans.Category;
import com.ahmed.smartphonejava.connexion.Connexion;
import com.ahmed.smartphonejava.dao.ICategoryDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryDao<Category> {
    @Override
    public List<Category> getAllCategories() {
        List<Category> list=new ArrayList<>();
        String query="Select * from category";
        try{
            PreparedStatement ps= Connexion.connecter().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setNom(rs.getString("nom"));
                category.setDescription(rs.getString("description"));
                category.setCreate_at(rs.getDate("created_at"));
                list.add(category);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category getCategoryById(int id) {
        String query="Select * from category where id=?";
        Category category=new Category();
        try{
            PreparedStatement ps= Connexion.connecter().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                category.setId(rs.getInt("id"));
                category.setNom(rs.getString("nom"));
                category.setDescription(rs.getString("description"));
                category.setCreate_at(rs.getDate("created_at"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }
}
