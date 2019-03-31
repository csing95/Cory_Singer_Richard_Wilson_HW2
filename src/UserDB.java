import java.sql.*;

public class UserDB {


    public static int insert(User user) {
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String insertQuery = "insert into email_user(email_user_firstname, email_user_lastname, email_user_email) " +
                "values (?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int delete(User user){
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String deleteQuery = "delete from email_user where email_user_email = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(deleteQuery);
            ps.setString(1, user.getEmail());
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static User select(User user){
        Connection conn;
        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        ResultSet rs = null;
        String selectQuery = "select * from email_user where email_user_email = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(selectQuery);
            ps.setString(1, user.getEmail());
            rs =  ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setFirstName(rs.getString("email_user_firstname"));
                user.setLastName(rs.getString("email_user_lastname"));
                user.setEmail(rs.getString("email_user_email"));
                user.setId(rs.getString("idemail_user"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
        }
    }

    public static int update(User user){
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String updateQuery = "update email_user set email_user_firstname = ?, email_user_lastname = ?, email_user_email = ? where idemail_user = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(updateQuery);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getId());
//            ps.setString(4, );
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }
}