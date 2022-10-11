

package lk.foodmart.superMarket.dao.custom;

import lk.foodmart.superMarket.dao.CrudDAO;
import lk.foodmart.superMarket.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<Order,String> {
    ArrayList<Order> searchOrder(String enteredText) throws SQLException, ClassNotFoundException;
}
