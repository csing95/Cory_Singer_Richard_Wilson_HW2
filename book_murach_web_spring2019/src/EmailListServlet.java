import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailListServlet")
public class EmailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "index.html";
        String action = request.getParameter("action");

        if(action==null){
            action = "join";
        }

        if(action.equals("join")){
            url = "/index.html";
        } else if(action.equals("add")){

            String email = request.getParameter("email");
            String firstName =request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User user = new User(email, firstName, lastName);
            UserDB.insert(user);
        }
        else if(action.equals("delete")){

                String email = request.getParameter("email");
                String firstName =request.getParameter("firstName");
                String lastName = request.getParameter("lastName");

                User user = new User(email, firstName, lastName);
                UserDB.delete(user);
        }
        else if(action.equals("update")){
            String email = request.getParameter("email");
            String firstName =request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User user = new User(email, firstName, lastName);
            UserDB.update(user);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}