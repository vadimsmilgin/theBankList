package app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

    private Service service = new Service();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String concreteUser = null;
        List<String> listOfAccounts = new ArrayList<String>();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        listOfAccounts = service.getListOfAccounts();

        String title = "The List Bank";

        writer.println("<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>");

        try {
            if(request.getParameter("id") != null){
                concreteUser = service.getConcreteUser(Integer.valueOf(request.getParameter("id")));
                writer.println("Selected user : " + concreteUser + "<br>");
            }
        } catch (NumberFormatException e){}

        for(int i=0; i<listOfAccounts.size(); i++){
            writer.println(listOfAccounts.get(i) + "<br>");
        }

        writer.println(
                "</body>" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
