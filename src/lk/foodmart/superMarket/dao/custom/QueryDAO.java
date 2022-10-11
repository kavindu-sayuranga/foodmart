

package lk.foodmart.superMarket.dao.custom;

import lk.foodmart.superMarket.dao.SuperDAO;
import lk.foodmart.superMarket.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomEntity> MostMovableItem() throws SQLException, ClassNotFoundException;
    ArrayList<CustomEntity> LeastMovableItem() throws SQLException, ClassNotFoundException;

    ArrayList<CustomEntity> getDailyIncomeReportDetails(int year,int Month) throws SQLException, ClassNotFoundException;
    ArrayList<CustomEntity> getAnnuallyIncomeReportDetails() throws SQLException, ClassNotFoundException;
    ArrayList<CustomEntity> getMonthlyIncomeReportDetails(int Year) throws SQLException, ClassNotFoundException;

    ArrayList<CustomEntity> searchItemsBYItemCodeAndDescription(String enteredText) throws SQLException, ClassNotFoundException;
    ArrayList<CustomEntity> getSearchItemsBYItemCodeAndDescription(String enteredText) throws SQLException, ClassNotFoundException;


}
