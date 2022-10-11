

package lk.foodmart.superMarket.bo.custom.impl;

import lk.foodmart.superMarket.bo.custom.MainReportBO;
import lk.foodmart.superMarket.dao.DAOFactory;
import lk.foodmart.superMarket.dao.custom.QueryDAO;
import lk.foodmart.superMarket.dao.custom.impl.QueryDAOImpl;
import lk.foodmart.superMarket.dto.CustomDTO;
import lk.foodmart.superMarket.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainReportBOImpl implements MainReportBO {

    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public ArrayList<CustomDTO> MostMovableItem() throws SQLException, ClassNotFoundException {
        ArrayList<CustomEntity> customEntities = queryDAO.MostMovableItem();
        ArrayList<CustomDTO> itDto=new  ArrayList<>();

        for (CustomEntity customEt : customEntities) {
            itDto.add(new CustomDTO(
                    customEt.getItemCode(),
                    customEt.getDescription(),
                    customEt.getPackSize(),
                    customEt.getUnitPrice(),
                    customEt.getOrderQty()
            ));
        }
        return itDto;
    }

    @Override
    public ArrayList<CustomDTO> LeastMovableItem() throws SQLException, ClassNotFoundException {
        ArrayList<CustomEntity> customEntities = queryDAO.LeastMovableItem();
        ArrayList<CustomDTO> itDto=new  ArrayList<>();

        for (CustomEntity customEt : customEntities) {
            itDto.add(new CustomDTO(
                    customEt.getItemCode(),
                    customEt.getDescription(),
                    customEt.getPackSize(),
                    customEt.getUnitPrice(),
                    customEt.getOrderQty()
            ));
        }
        return itDto;
    }

}
