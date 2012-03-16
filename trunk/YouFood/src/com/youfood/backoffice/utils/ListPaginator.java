package com.youfood.backoffice.utils;

import java.util.List;

public class ListPaginator {
	private List<?> entries;
	private double currentPage = 1;
	private double nbPage;
	private int entryPerPage = 25;
	
	public ListPaginator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListPaginator(List<?> entries) {
		super();
		this.entries = entries;
	}

	public List<?> getEntries() {
		return entries;
	}

	public void setEntries(List<?> entries) {
		this.entries = entries;
	}

	public double getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Double getPreviousPage() {
		if ((currentPage - 1) > 0){
			return currentPage - 1;
		}
		return null;
	}

	public Double getNextPage() {
		if (currentPage < nbPage){
			return currentPage + 1;
		}
		return null;
	}	

	public double getNbPage() {
		nbPage = Math.ceil(entries.size() / entryPerPage);
		
		if (currentPage > nbPage){
			currentPage = nbPage;
		}
		
		return nbPage;		
	}

	public int getEntryPerPage() {
		return entryPerPage;
	}

	public void setEntryPerPage(int entryPerPage) {
		this.entryPerPage = entryPerPage;
	}
	
	
}
