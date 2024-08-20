package com.grepp.controller;

import com.grepp.controller.util.MyControllerMapping;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// board.do, member.do, login.do, ... etc 모두 다 여기로 실행되게
// 그런고로 혹시 다른 서블릿이 있다면 걔들보다 이 서블릿이 더 먼저 생성되게 loadOnStartup=1
// Spring 백엔드 프레임워크 만든 사람들의 생각. 서블릿 단 하나로 다 처리되게 하자. DispatcherServlet!!!!!!!!!!!!!!!!!!!!1
@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    private MyControllerMapping controllerMapping = new MyControllerMapping();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected  void process(HttpServletRequest request, HttpServletResponse response){
        String url = request.getServletPath();
        System.out.println("request here : "+url);

        MyController controller = controllerMapping.getController(url); // 얘한테 물어보면 컨트롤러 객체중에 하나 줄거임~ BoardController, MemberController, MainController, ... etc
    }
}
