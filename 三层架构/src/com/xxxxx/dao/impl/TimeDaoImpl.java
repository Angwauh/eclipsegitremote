package com.xxxxx.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.xxxxx.dao.ITimeDao;

import java.sql.Date;



public class TimeDaoImpl implements ITimeDao{
	//String——》sql.Date
	public Date StringToSqlDate(String s) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			java.util.Date date = df.parse(s);
			date2 = new Date(date.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}
}
