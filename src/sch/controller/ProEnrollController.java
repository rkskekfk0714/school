package sch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sch.service.Service;

public class ProEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service s = Service.getInstance();
		int totalnum = s.proEnroll(id, num);
		
		request.setAttribute("num", num);
		request.setAttribute("tNum", totalnum);
		HttpUtil.forward(request, response, "/result/proShowSubjectResult.jsp");
	}

}
