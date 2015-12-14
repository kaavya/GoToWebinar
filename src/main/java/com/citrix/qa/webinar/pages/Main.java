package com.citrix.qa.webinar.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String args[]){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, YYYY");
		Date today = new Date();
		System.out.println(sdf.format(today));
	}
}
