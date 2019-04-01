import java.sql.*;
import java.util.ArrayList;

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


    public static ArrayList<User> selectUsers() {

        Connection conn;
        PreparedStatement ps = null;
        String selectAll = "select * from email_user";
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conn.prepareStatement(selectAll);
                //User u1 = new User();
                //ps.setString(1, u1.getEmail());
                rs = ps.executeQuery();

                while (rs.next()){
                    User user = new User();
                    user.setFirstName(rs.getString("email_user_firstname"));
                    user.setLastName(rs.getString("email_user_lastname"));
                    user.setEmail(rs.getString("email_user_email"));
                    user.setId(rs.getString(1));
                    users.add(user);
                }

                return users;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePreparedStatement(ps);
            }
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

    public static int select(User user){
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String selectQuery = "select idemail_user from email_user where email_user_email = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(selectQuery);
            ps.setString(1, user.getEmail());
            System.out.println("This is the user ID"+user.getId());
            System.out.println("This is the user ID"+user.getEmail());
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