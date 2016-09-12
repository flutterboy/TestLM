package it.negro.lm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.negro.lm.entity.ItemCategory;
import it.negro.lm.repository.ItemCategoryRepository;

@Service
public class CategoryService {
	
	private ItemCategoryRepository itemCategoryRepository;
	
	@Autowired
	@Qualifier("itemCategoryRepositoryFileImpl")
	public void setItemCategoryRepository(ItemCategoryRepository itemCategoryRepository) {
		this.itemCategoryRepository = itemCategoryRepository;
	}
	
	public List<ItemCategory> getAll(){
		return itemCategoryRepository.findAll();
	}
	
	public ItemCategory get(Integer id){
		return itemCategoryRepository.findOne(id);
	}
	
}
