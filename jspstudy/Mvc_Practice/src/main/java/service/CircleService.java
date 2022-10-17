package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class CircleService implements ShapeService{

	@Override
	public ActionForward  execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		double radius = Double.parseDouble(request.getParameter("radius"));
		
		request.setAttribute("radius", radius);
		request.setAttribute("area", Math.PI * Math.pow(radius, 2));
		request.setAttribute("shape", "circle");
		
		ActionForward af = new ActionForward();
		af.setView("views/output.jsp");
		af.setRedirect(false);
		return af;
	}
}
