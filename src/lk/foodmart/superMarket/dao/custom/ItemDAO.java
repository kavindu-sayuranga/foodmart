

package lk.foodmart.superMarket.dao.custom;

import lk.foodmart.superMarket.dao.CrudDAO;
import lk.foodmart.superMarket.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    ArrayList<Item> searchItems(String enteredText) throws SQLException, ClassNotFoundException;
}
