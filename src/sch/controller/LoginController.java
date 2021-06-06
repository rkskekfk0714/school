package sch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sch.service.Service;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String radio = request.getParameter("radio");
		System.out.print("lc" + pwd);
		Service s = Service.getInstance();
		boolean result = s.index(id, pwd, radio);
		String path = null;
		
		
		if(radio == "prof")
		{
			if(result)
			{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				path = "/profMenu.jsp";
			}
			else
			{
				path = "/index.jsp";
			}
		}else if(radio == "student")
		{
			if(result)
			{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				path = "/studentMenu.jsp";
			}
			else
			{
				path = "/index.jsp";
			}
		}
		
		HttpUtil.forward(request, response, path);
	}

}
