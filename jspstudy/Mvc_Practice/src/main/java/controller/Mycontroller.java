package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.ShapeService;
import service.CircleService;
import service.RectangleService;
import service.TriangleService;

@WebServlet("*.do")
public class Mycontroller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requesetURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requesetURI.substring(contextPath.length() + 1);
		
		ShapeService shapeService = null;
		
		ActionForward actionForward = null;
		
		switch(command) {
		case "rectangle.do":
			shapeService = new RectangleService();
			break;
		case "triangle.do":
			shapeService = new TriangleService();
			break;
		case "circle.do":
			shapeService = new CircleService();
		case "input.do":
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			actionForward.setRedirect(false);
			break;
		}
		
		if(shapeService != null) {
			actionForward = shapeService.execute(request, response);
		}
		
		if(actionForward != null) {
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getView());
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
