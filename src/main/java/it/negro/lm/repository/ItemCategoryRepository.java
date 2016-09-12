package it.negro.lm.repository;

import java.util.List;

import it.negro.lm.entity.ItemCategory;

public interface ItemCategoryRepository {
	
	ItemCategory findOne(Integer id);
	boolean exists(Integer id);
	List<ItemCategory> findAll();
	
}
