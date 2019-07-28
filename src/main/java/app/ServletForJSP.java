package app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletForJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAO dao = new DAO();

        if (request.getParameter("richer") != null ) {
            String user = dao.getTheRichestUser();
            request.setAttribute("valueUser", user);
            if(request.getParameter("valueSum") != null) {
                request.setAttribute("valueSum", request.getParameter("valueSum"));
            }

        } else if (request.getParameter("sum") != null) {
            String sum = dao.getSumOfAccounts();
            request.setAttribute("valueSum", sum);
            if(request.getParameter("valueUser") != null) {
                request.setAttribute("valueUser", request.getParameter("valueUser"));
            }
        }

        request.getRequestDispatcher("jsp_with_servlet.jsp").forward(request, response);
    }


}
