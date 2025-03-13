package hello.spring_mvc1.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.spring_mvc1.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        final HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        final String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
