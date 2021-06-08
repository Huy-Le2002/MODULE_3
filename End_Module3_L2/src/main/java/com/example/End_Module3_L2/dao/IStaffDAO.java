package com.example.End_Module3_L2.dao;

import com.example.End_Module3_L2.model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IStaffDAO {
    public void insertStaff(Staff staff) throws SQLException;
    public Staff selectStaff(int id);
    public List<Staff> selectAllStaff();
    public List<String> selectgroupstaff();
    public boolean deleteStaff(int id) throws SQLException;
    public boolean updateStaff(Staff staff) throws SQLException;
    public List<Staff> searchLikeStaff(String keyWord);
}
