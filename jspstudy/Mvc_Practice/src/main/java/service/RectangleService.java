package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class RectangleService implements ShapeService{

	@Override
	public ActionForward  execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double width = Double.parseDouble(request.getParameter("width"));
		double height = Double.parseDouble(request.getParameter("height"));
		
		request.setAttribute("width", width);
		request.setAttribute("height", height);
		request.setAttribute("area", width * height);
		request.setAttribute("shape", "rectangle");
		
		ActionForward af = new ActionForward();
		af.setView("views/output.jsp");
		af.setRedirect(false);
		return af;
	}
}
