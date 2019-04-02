import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public static ArrayList<User> selectUsers(User u1) {

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
                String queryEmail = u1.getEmail();
                //System.out.println("Your email is " + queryEmail);
                rs = ps.executeQuery();

                while (rs.next()){
                    User user = new User();
                    user.setFirstName(rs.getString("email_user_firstname"));
                    user.setLastName(rs.getString("email_user_lastname"));
                    user.setEmail(rs.getString("email_user_email"));
                    user.setId(rs.getString(1));
                    users.add(user);
                }

                ArrayList<User> singleUser = new ArrayList<>();

                for (int i = 0; i < users.size(); i++){
                    if (queryEmail.equals(users.get(i).getEmail())){
                        singleUser.add(users.get(i));
                        System.out.println(queryEmail + " : They matched");
                    }
                }
                return singleUser;

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

    public static boolean doesEmailExist(User user){
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String selectQuery = "select email_user_email from email_user where email_user_email = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");

            ps = conn.prepareStatement(selectQuery);
            ps.setString(1, user.getEmail());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }

}