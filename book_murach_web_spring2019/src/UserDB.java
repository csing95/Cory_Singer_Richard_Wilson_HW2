import java.sql.*;

public class UserDB  {



    //Before connecting to the database, you need to add an external driver
    //Go to File -> Project Structure -> Libraries -> + -> From Maven then type mysql-connector-java-5.1.47.jar


    public static int insert(User user){
        Connection conn;

        PreparedStatement ps = null;
        String insertQuery = "insert into email_users (email, firstname, " +
                "lastname) values (?,?,?) ";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root",
                    "mysql");

            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());

            return ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }


    }

    public static int delete(User user){
        Connection conn;

        PreparedStatement psDelete = null;
        String deleteQuery = "delete from email_users where email = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root",
                    "mysql");

            psDelete = conn.prepareStatement(deleteQuery);

            psDelete.setString(1, user.getEmail());

            return psDelete.executeUpdate();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(psDelete);
        }

    }

    public static int update(User user){
        Connection conn;
        PreparedStatement psUpdate = null;

        String updateQuery = "update email_users set firstname = ?, lastname = ? where email = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root",
                    "mysql");

            psUpdate = conn.prepareStatement(updateQuery);

            psUpdate.setString(1,user.getFirstName());
            psUpdate.setString(2,user.getLastName());
            psUpdate.setString(3,user.getEmail());

            return psUpdate.executeUpdate();


        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(psUpdate);
        }

    }





}
