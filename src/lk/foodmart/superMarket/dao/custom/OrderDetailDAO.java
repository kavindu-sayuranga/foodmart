

package lk.foodmart.superMarket.dao.custom;

import lk.foodmart.superMarket.dao.CrudDAO;
import lk.foodmart.superMarket.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<OrderDetail,String> {
    ArrayList<OrderDetail> searchOrderDetail(String enteredText) throws SQLException, ClassNotFoundException;
}
