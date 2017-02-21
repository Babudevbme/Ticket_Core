package com.ticket.dao;

import java.util.List;

import com.ticket.model.Department;

public interface DepartmentInterface {

	void save(Department dept);

	void update(Department dept);

	void delete(int id);

	List<Department> list();

	Department listById(int id);

	Department listByName(String name);

}