package it.negro.lm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.negro.lm.entity.ItemCategory;

@Repository("itemCategoryRepositoryJdbcImpl")
public class ItemCategoryRepositoryJdbcImpl implements ItemCategoryRepository {

	@Override
	public ItemCategory findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemCategory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
