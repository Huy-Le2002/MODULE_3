package com.example.CaseStudy_Module3.dao;

import com.example.CaseStudy_Module3.model.Country;
import com.example.CaseStudy_Module3.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public List<User> sortUser();
    public List<User> searchLikeUser(String keyWord);
    public List<Country> list();
}
