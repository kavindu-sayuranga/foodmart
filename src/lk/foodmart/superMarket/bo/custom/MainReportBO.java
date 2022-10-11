

package lk.foodmart.superMarket.bo.custom;

import lk.foodmart.superMarket.bo.SuperBO;
import lk.foodmart.superMarket.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MainReportBO extends SuperBO {
    ArrayList<CustomDTO> MostMovableItem() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> LeastMovableItem() throws SQLException, ClassNotFoundException;
}
