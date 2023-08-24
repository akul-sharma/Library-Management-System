package com.assignment9.mycontroller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.assignment9.model.Authors;
import com.assignment9.model.Books;
import com.assignment9.model.User;
import com.assignment9.repo.*;

@Controller
public class MyController {

	@Autowired
	BooksRepo booksRepo;
	
	@Autowired
	AuthorsRepo authorsRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/")
	public String getLogin() {
	   return "login";
	}
	
	@PostMapping("login")
	public ModelAndView checkLogin(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		List<User> allUsers=userRepo.findAll();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		for(User user: allUsers) {
			System.out.println(user.getUserName()+" "+user.getUserPassword());
		}
		
		for(User user: allUsers) {
			if(username.equals(user.getUserName()) && password.equals(user.getUserPassword())) {
				HttpSession session=req.getSession();
				session.setAttribute("username", username);
				List<Books> allBooks=booksRepo.findAll();
				mav.addObject("allBooks", allBooks);
			    mav.setViewName("welcome");
			    return mav;
			}
		}
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("Logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "login";
	}

	@RequestMapping("books")
	public ModelAndView getWelcome() {
	   ModelAndView mav=new ModelAndView();
	   List<Books> allBooks=booksRepo.findAll();
	   mav.addObject("allBooks", allBooks);
	   mav.setViewName("welcome");
	   return mav;
	}
	
	@RequestMapping("add")
	public ModelAndView getAddPage() {
		ModelAndView mav=new ModelAndView();
	    List<Authors> allAuthors=authorsRepo.findAll();
	    mav.addObject("allAuthors", allAuthors);
		mav.setViewName("add");
	    return mav;
	}
	
	@PostMapping("addBook")
	public void addBook(Books newBook) {
		booksRepo.save(newBook);
	}
	
	@PostMapping("addData")
	public ModelAndView addData(@RequestParam("bookCode") int bookCode, @RequestParam("bookName") String bookName, @RequestParam("author") String author, @RequestParam("date") String date) {
		 
		Books newBook=new Books(bookCode, bookName, author, date);
		addBook(newBook);
	    return getWelcome();
	}
	
	@GetMapping("edit")
	public ModelAndView editBook(@RequestParam("bookId") int bookId,@RequestParam("bookName") String bookName, @RequestParam("author") String author, @RequestParam("date") String date) {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("bookId", bookId);
		mav.addObject("bookName", bookName);
		mav.addObject("author", author);
		mav.addObject("date", date);
		
		System.out.println(author);
		
		List<Authors> allAuthors=authorsRepo.findAll();
	    mav.addObject("allAuthors", allAuthors);
		mav.setViewName("edit");
		return mav;
		
	}
	
	@PostMapping("update")
	public ModelAndView updateBook(@RequestParam("bookId") int bookId,@RequestParam("bookName") String bookName, @RequestParam("author") String author, @RequestParam("date") String date) {
		
		System.out.println(bookId);
		
		booksRepo.deleteById(bookId);
			Books newBook= new Books(bookId,bookName,author,date);
			booksRepo.save(newBook);
		return getWelcome();
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteBook(@RequestParam("bookId") int bookId) {
		booksRepo.deleteById(bookId);
		ModelAndView mav=new ModelAndView();
		   List<Books> allBooks=booksRepo.findAll();
		   mav.addObject("allBooks", allBooks);
		   mav.setViewName("welcome");
		   return mav;
	}
	
}
