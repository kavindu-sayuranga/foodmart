

package lk.foodmart.superMarket.bo.custom;

import lk.foodmart.superMarket.bo.SuperBO;
import lk.foodmart.superMarket.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    ArrayList<OrderDTO> getAllOrder() throws SQLException, ClassNotFoundException;

    boolean deleteOrder(String oid) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDTO> searchOrder(String enteredText) throws SQLException, ClassNotFoundException;
}
