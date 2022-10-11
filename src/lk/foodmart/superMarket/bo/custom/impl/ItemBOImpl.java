

package lk.foodmart.superMarket.bo.custom.impl;

import lk.foodmart.superMarket.bo.custom.ItemBO;
import lk.foodmart.superMarket.dao.DAOFactory;
import lk.foodmart.superMarket.dao.custom.ItemDAO;
import lk.foodmart.superMarket.dao.custom.impl.ItemDAOImpl;
import lk.foodmart.superMarket.dto.ItemDTO;
import lk.foodmart.superMarket.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItem = new ArrayList<>();
        for (Item item : all) {
            allItem.add(new ItemDTO(item.getItemCode(),item.getDescription(),item.getPackSize(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return allItem;
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getItemCode(),dto.getDescription(),dto.getPackSize(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getItemCode(),dto.getDescription(),dto.getPackSize(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean itemExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    @Override
    public ArrayList<ItemDTO> searchItems(String enteredText) throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = itemDAO.searchItems(enteredText);
        ArrayList<ItemDTO> itemDto=new ArrayList<>();

        for (Item item : items) {
            itemDto.add(new ItemDTO(item.getItemCode(),
                    item.getDescription(),
                    item.getPackSize(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()

            ));
        }
        return itemDto;
    }

}
