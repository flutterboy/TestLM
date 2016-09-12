package it.negro.lm.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.negro.lm.entity.ItemCategory;

@Repository("itemCategoryRepositoryFileImpl")
public class ItemCategoryRepositoryFileImpl implements ItemCategoryRepository {
	
	private List<ItemCategory> categories;
	
	private String file;
	
	@Value("categories.json")
	public void setFile(String file) throws FileNotFoundException {
		this.file = file;
	}
	
	public String getFile() {
		return file;
	}
	
	@PostConstruct
	public void init() throws IOException{
		InputStream categoryStream = null;
		try{
			categoryStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.file);
			ObjectMapper om = new ObjectMapper();
			ItemCategory[] categoriesArray = om.readValue(categoryStream, ItemCategory[].class);
			this.categories = Arrays.asList(categoriesArray);
		}finally{
			if (categoryStream != null)
				categoryStream.close();
		}
	}
	
	@Override
	public ItemCategory findOne(Integer id) {
		ItemCategory result = null;
		Optional<ItemCategory> oic = categories.stream().filter(c->c.getId().equals(id)).findFirst();
		if (oic.isPresent())
			result = oic.get();
		return result;
	}
	
	@Override
	public boolean exists(Integer id) {
		return findOne(id) != null;
	}
	
	@Override
	public List<ItemCategory> findAll() {
		return this.categories;
	}

}
