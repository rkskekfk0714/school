package sch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sch.service.Service;

public class ProShowSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = null;
		String job = request.getParameter("job");
		if(job.equals("q"))
			path = "/result/proEnrollListResult.jsp";
		
		String id = (String)request.getSession().getAttribute("id");
		
		int num = 0;
		if(id == null)
		{
			System.out.print("query:id is not exist");
		}
		else
			num = Service.getInstance().proEnrollList(id);
		
		request.setAttribute("num", num);
		HttpUtil.forward(request, response, path);
	}

}
