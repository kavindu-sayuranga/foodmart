

package lk.foodmart.superMarket.bo.custom.impl;

import lk.foodmart.superMarket.bo.custom.OrderDetailBO;
import lk.foodmart.superMarket.dao.DAOFactory;
import lk.foodmart.superMarket.dao.custom.OrderDetailDAO;
import lk.foodmart.superMarket.dao.custom.impl.OrderDetailDAOImpl;
import lk.foodmart.superMarket.dto.OrderDetailDTO;
import lk.foodmart.superMarket.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO {

    private final OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    @Override
    public ArrayList<OrderDetailDTO> searchOrderDetail(String enteredText) throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetail> orderDetails = orderDetailDAO.searchOrderDetail(enteredText);
        ArrayList<OrderDetailDTO> orDetailDto=new ArrayList<>();

        for (OrderDetail ordersList : orderDetails) {

            orDetailDto.add(new OrderDetailDTO(ordersList.getOrderId(),
                    ordersList.getItemCode(),
                    ordersList.getOrderQty(),
                    ordersList.getUnitPrice().doubleValue(),
                    ordersList.getDiscount(),
                    ordersList.getTotal()
            ));
        }
        return orDetailDto;
    }
}
