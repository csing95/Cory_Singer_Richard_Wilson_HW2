import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmailListServlet")
public class EmailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/index.html";
        String action = request.getParameter("action");

        if (action ==null){
            action = "join";
        }

        if (action.equals("join")){
            url = "/index.html";
        } else if (action.equals("add")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(firstName,lastName,email);
            UserDB.doesEmailExist(user);
            if (false) {
                UserDB.insert(user);
            } else {
                //input an alert here
                System.out.println("email already taken");
                
            }
            url = "/index.html";
        } else if (action.equals("delete")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(firstName,lastName,email);
            UserDB.delete(user);
            url = "/index.html";
        } else if (action.equals("select")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User u1 = new User(firstName,lastName,email);
            UserDB.selectUsers(u1);

            ArrayList<User> users = UserDB.selectUsers(u1);
            request.setAttribute("users",users);

            url= "/update.jsp";

        } else if (action.equals("update")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String id = request.getParameter("id");

            User user = new User(firstName,lastName,email, id);
            UserDB.update(user);
            url = "/update.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
