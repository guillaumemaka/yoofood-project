package com.supinfo.notetonsta.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.dao.jpa.DaoFactory;
import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Mark;
import com.supinfo.notetonsta.entity.Speaker;
import com.supinfo.servlet.custom.ActionServlet;

/**
 * Servlet implementation class InterventionServlet
 */
@WebServlet("/interventions/*")
public class InterventionServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InterventionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Catch those url pattern 
	 * /interventions/new					# Create an inervention
	 * /interventions/mine 					@ Display Speaker interventions 
	 * /interventions/edit/[0-9+]			# Edit an intervention
	 * /interventions/delete/[0-9+]			# Delete an intervention
	 * /interventions/show/[0-9+]			# Show an intervention
	 * /interventions/list/campus//[0-9+]	# List intrvention by campus 
	 * 
	 * otherwise /home
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();

		if (
				action.equalsIgnoreCase("/new")
			) {
			
			Intervention intervention = new Intervention();

			request.setAttribute("campus", DaoFactory.campusDao().findAll());
			request.setAttribute("intervention", intervention);
			request.getRequestDispatcher("/pages/interventions/new.jsp")
					.forward(request, response);
			
		} else if (
				action.equalsIgnoreCase("/mine")
				) {

			Integer id = (Integer) request.getSession().getAttribute("user_id");

			Set<Intervention> interventions = DaoFactory.speakerDao().find(id)
					.getInterventions();
						
			request.setAttribute("interventions", interventions);
			request.getRequestDispatcher("/pages/interventions/mine.jsp")
					.forward(request, response);
			
		} else if (
				action.matches("/show/[0-9]+")
				) {
			
			String[] path = action.split("/", 3);
			
			int id = Integer.parseInt(path[2]);

			Intervention intervention = DaoFactory.interventionDao().find(id);
			
			request.setAttribute("marks_avg", DaoFactory.markDao().getStatsForIntervention(intervention));
			request.setAttribute("back_url", this.backUrl(request));
			request.setAttribute("intervention", intervention);
			request.getRequestDispatcher("/pages/interventions/show.jsp")
					.forward(request, response);
			
		} else if (
				action.matches("/list/campus/[0-9]+")
				) {
			
			String[] path = action.split("/", 4);
			int id = Integer.parseInt(path[3]);
			
			Campus campus = DaoFactory.campusDao().find(id);
			
			request.setAttribute("campus", campus);
			request.setAttribute("interventions", campus.getInterventions());
			request.getRequestDispatcher("/pages/interventions/list.jsp")
					.forward(request, response);
			
		} else if (
				action.matches("/edit/[0-9]+")
				) {
			
			String[] path = action.split("/", 3);
			int id = Integer.parseInt(path[2]);

			Intervention intervention = DaoFactory.interventionDao().find(id);
			
			request.setAttribute("campus", DaoFactory.campusDao().findAll());
			request.setAttribute("intervention", intervention);
			request.getRequestDispatcher("/pages/interventions/edit.jsp")
					.forward(request, response);
			
		}else if (
				action.matches("/delete/[0-9]+")
				) {
			
			this.delete(request, response);
			
		} else {			
			request.getRequestDispatcher("/home").forward(request, response);
		}
	}

	/**
	 * 
	 * Catch those url pattern 
	 * /interventions/new 			with parameter 'action' set too 'create'  # Create an inervention
	 * /interventions/update 		with parameter 'action' set too 'update'  # Update an inervention 
	 * /interventions/evaluate		with parameter 'action' set too 'evaluate'  # Evaluate an inervention 
	 * 
	 * otherwise /home
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if(action == null){
			action = "unknow";
		}
		
		if (action.equalsIgnoreCase("new")){
			this.create(request, response);
		}else if(action.equalsIgnoreCase("update")){
			this.update(request, response);
		}else if ( action.equalsIgnoreCase( "evaluate" ) ) {	
			this.evaluate(request, response);			
		}else{
			request.getRequestDispatcher("/home").forward(request, response);
		}		
	}
	
	/*
	 * Create Intervention Logic
	 * @see com.supinfo.servlet.custom.ActionServlet#create(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		Intervention intervention = new Intervention();
		
		intervention.setSubject( request.getParameter( "subject" ) );
		
		Campus campus = new Campus();
		campus.setId(Integer.parseInt( request.getParameter( "campus_id" )));
		intervention.setCampus(campus);
				
		Speaker speaker = new Speaker();
		
		speaker.setId((Integer) request.getSession().getAttribute("user_id"));		
		intervention.setSpeaker(speaker);
		
		intervention.setEndDate(request.getParameter("to"));		
		intervention.setStartDate(request.getParameter("from"));		
		intervention.setDescription(request.getParameter("description"));		
		
		
		try {
			DaoFactory.interventionDao().addIntervention(intervention);
			request.setAttribute("success", "Intervention created");
		}catch(Exception e){
			request.setAttribute("error", "An error occcur during intervention creation");
			e.printStackTrace();
		}
		
		
		request.setAttribute("intervention", intervention);		
		request.getRequestDispatcher("/pages/interventions/show.jsp").forward(request, response);
	}
	
	/*
	 * Update intervention logic
	 * @see com.supinfo.servlet.custom.ActionServlet#update(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Intervention intervention = DaoFactory.interventionDao().find(Integer.parseInt(request.getParameter("intervention_id")));
		
		intervention.setSubject( request.getParameter( "subject" ) );
		intervention.getCampus().setId(Integer.parseInt(request.getParameter("campus_id")));		
		intervention.setEndDate(request.getParameter("to"));		
		intervention.setStartDate(request.getParameter("from"));		
		intervention.setDescription(request.getParameter("description"));		
		
		
		try {
			DaoFactory.interventionDao().updateIntervention(intervention);
			request.setAttribute("success", "Intervention updated");
		}catch(Exception e){
			request.setAttribute("error", "An error occcur during intervention update");
			e.printStackTrace();
		}
		
		request.setAttribute("marks_avg", DaoFactory.markDao().getStatsForIntervention(intervention));
		request.setAttribute("intervention", intervention);
		request.getRequestDispatcher("/pages/interventions/show.jsp").forward(request, response);
	}
	
	/*
	 * Delete intervention logic
	 * @see com.supinfo.servlet.custom.ActionServlet#delete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			String[] path = request.getPathInfo().split("/", 3);
			int id = Integer.parseInt(path[2]);

			Intervention intervention = DaoFactory.interventionDao().find(id);
			
			DaoFactory.interventionDao().removeIntervention(intervention);
			
			request.setAttribute("success", "Intervention deleted successfully !");
			
		}catch(Exception e){
			request.setAttribute("error", "An error occur durring the intervention deletion proccess !");
		}
		
		request.getRequestDispatcher("/interventions/mine").forward(request, response);
	}
	
	/*
	 * Evaluate intervention logic
	 */
	protected void evaluate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Mark mark = new Mark();
		Intervention intervention = new Intervention();
		double speakerMark; 
		int q1, q2, q3;
		double slideMark;
		int q4, q5, q6; 
		String idbooster, coment;
		int intervention_id;
		
		
		intervention_id = Integer.parseInt(req.getParameter("intervention_id"));
		idbooster = req.getParameter("idbooster");
		q1 = Integer.parseInt(req.getParameter("q1"));
		q2 = Integer.parseInt(req.getParameter("q2"));
		q3 = Integer.parseInt(req.getParameter("q3"));
		q4 = Integer.parseInt(req.getParameter("q4"));
		q5 = Integer.parseInt(req.getParameter("q5"));
		q6 = Integer.parseInt(req.getParameter("q6"));
		coment = req.getParameter("coment");
		
		speakerMark =	(q1 + q2 + q3) / 3;
		slideMark 	=	(q4 + q5 + q6) / 3;
		
		intervention.setId(intervention_id);
		mark.setIntervention(intervention);
		mark.setIdbooster(idbooster);
		mark.setSpeakerMark(speakerMark);
		mark.setSlideMark(slideMark);
		mark.setComent(coment);
		
		try{
			DaoFactory.markDao().addMark(mark);
			req.setAttribute("marks_avg", DaoFactory.markDao().getStatsForIntervention(intervention));
			req.setAttribute("intervention", DaoFactory.interventionDao().find(intervention_id));
			req.setAttribute("success","Evaluation completed successfully !");
		}catch(Exception e){
			req.setAttribute("error","An error occur, during proccessing your evaluation, please try again later !");
		}
		
		req.getRequestDispatcher("/pages/interventions/show.jsp").forward(req, resp);
	}
	
	private String backUrl(HttpServletRequest req){
		return req.getHeader("referer");
	}
}
