

package lk.foodmart.superMarket.bo.custom;

import lk.foodmart.superMarket.bo.SuperBO;
import lk.foodmart.superMarket.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    ArrayList<OrderDetailDTO> searchOrderDetail(String enteredText) throws SQLException, ClassNotFoundException;
}
