package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customer_id = resultSet.getLong("Customer_id");
		 Long item_id1 = resultSet.getLong("item_id1");
		 String item_name=resultSet.getString("item_name");
		Long quantity=resultSet.getLong("quantity");
		 Double cost = resultSet.getDouble("cost");
		
		return new Order(order_id,customer_id,item_id1,item_name,quantity,cost);
	}

	/**
	 * Reads all Order from the database
	 * 
	 * @return A list of Order
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(" select order_id,customer_id,item_id1,item.name as item_name,\r\n"
						+ "sum(quantity)as quantity,sum(value1)*quantity cost from  customers,item,\r\n"
						+ " order_items where	\r\n"
						+ "  order_items.item_id1=item.item_id and \r\n"
						+ "   order_items.customer_id=customers.id group by customers.id\r\n"
						+ "order by  order_id ;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet)); 
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM  order_items ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a Order in the database
	 * 
	 * @param customer - takes in a Order object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO  order_items (customer_id,item_id1,quantity) "
								+ " values (?,?,?)");
		
		PreparedStatement statement1 = connection
		.prepareStatement("INSERT INTO orders (customer_id1) "
				+ " values (?)");)
		
		{
			statement.setLong(1, order.getCustomer_id());
			statement.setLong(2, order.getItem_id1());
			statement.setLong(3, order.getQuantity());
			
			
			
			statement1.setLong(1, order.getCustomer_id());
			//statement1.setLong(1, order.getItem_id1());
			//statement1.setLong(2, order.getQuantity());
			
			statement1.executeUpdate();
			
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM  order_items WHERE order_id = ?");)
				{
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a Order in the database
	 * 
	 * @param Order - takes in a Order object, the id field will be used to
	 *                 update that Order in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET customer_id = ?, item_id1 = ? , quantity =  ? WHERE order_id = ?");) {
			statement.setLong(1, order.getCustomer_id());
			statement.setLong(2, order.getItem_id1());
			statement.setLong(3, order.getQuantity());
			statement.setLong(4, order.getOrder_id());
			statement.executeUpdate();
			return read( order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a Order in the database
	 * 
	 * @param id - id of the Order
	 */
	@Override
	public int delete(long order_id ) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_id = ?");) {
			statement.setLong(1, order_id );
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	

}
