package lk.foodmart.superMarket.bo.custom;



import lk.foodmart.superMarket.bo.SuperBO;
import lk.foodmart.superMarket.dto.CustomDTO;
import lk.foodmart.superMarket.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DashBoardBO extends SuperBO {
    ArrayList<ItemDTO> getAllItemName() throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getSearchICodeDescription(String enteredText) throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getCustomerBuyingItems(String text) throws SQLException, ClassNotFoundException;

    ArrayList<String> getCmbCustomerIds() throws SQLException, ClassNotFoundException;

    int getOrderCount() throws SQLException, ClassNotFoundException;

    int getItemTypes() throws SQLException, ClassNotFoundException;

    int getTotalCustomer() throws SQLException, ClassNotFoundException;
}
