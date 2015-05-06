package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAOJDBCImpl extends BaseDAO implements ProductsDAO {

	@Override
	public List<Product> getByOrderId(int orderId) throws DAOException {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		List<Product> products = new ArrayList<Product>();
		
		try
		{
			con = getConnection();

			String sql = "select 	p.product_id product_id, p.product_type, p.product_name, p.price " + 
					 	"from 		order_details od, products p " + 
					 	"where   	od.order_id = p.order_id " +
					 	"and		od.order_id = ?";		
			
			statement = con.prepareStatement(sql);
			statement.setInt(1, orderId);
			
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("pid");
				String type = rs.getString("product_type");
				String name = rs.getString("product_name");
				double price = rs.getDouble("price");
				
				Product product = new Product(id, type, name, price);
				products.add(product);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
			throw new DAOException("Error occured while selecting", ex);
		} finally {
			closeResources(rs, statement, con);
		}
		
		return products;
	}
}	

