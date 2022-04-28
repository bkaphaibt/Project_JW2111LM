package cate_pro.dao;

import java.util.List;

import cate_pro.entities.Product;

public interface ProductDAO {
	public List<Product> getListProducts();
	public boolean insertProduct(Product pro);
}
