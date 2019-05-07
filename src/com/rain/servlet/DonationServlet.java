package com.rain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rain.dao.BookDao;
import com.rain.dao.DonationDao;


/**
 * Servlet implementation class DonationServlet
 */
@WebServlet("/DonationServlet")

public class DonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    DonationDao  donationBiz=new DonationDao();
		String donator = request.getParameter("donater_name");
		String phone = request.getParameter("donater_phone");
		String bookname=request.getParameter("donater_bookname");
		String booknumber=request.getParameter("donater_booknumber");
		
		System.out.println(donator+phone+bookname+booknumber);
		
		if(!donator.equals("")&&!phone.equals("")&&!bookname.equals("")&&!booknumber.equals("")) {
			
			int b = donationBiz.donate(donator, phone, bookname, booknumber);
			if(b>0) {
				request.getRequestDispatcher("index2.jsp").forward(request, response);
			}else {
				response.sendRedirect("donation.html");
			}

		}else {			
			response.sendRedirect("donation.html");
		}
	}
 

}
