

package lk.foodmart.superMarket.bo.custom;


import lk.foodmart.superMarket.bo.SuperBO;
import lk.foodmart.superMarket.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DailyIncomeReportBO extends SuperBO {
    ArrayList<CustomDTO> getDailyIncomeReportDetails(int year, int month) throws SQLException, ClassNotFoundException;

    int getMonth(String month);
}
