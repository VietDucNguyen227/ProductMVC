package jdbcapp.mvc.model;

import jdbcapp.mvc.entity.Users;

import java.sql.SQLException;

public interface LoginDAO {
    public String checkLoginStatement(Users users) throws SQLException, ClassNotFoundException;

    public String checkLoginPreparedStatement(Users users) throws SQLException, ClassNotFoundException;


}
