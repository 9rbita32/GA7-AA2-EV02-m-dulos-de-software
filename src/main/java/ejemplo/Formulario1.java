package ejemplo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/procesarFormulario1")
public class Formulario1 extends HttpServlet {
    private static final String EMAIL_VALIDO = "Tatiana@gmail.com";
    private static final String PASSWORD_VALIDA = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String contraseña = request.getParameter("contraseña");

        if (EMAIL_VALIDO.equals(email) && PASSWORD_VALIDA.equals(contraseña)) {
            request.getRequestDispatcher("Bienvenido.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Correo electrónico o contraseña incorrectos");
            request.setAttribute("errorExists", true);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}