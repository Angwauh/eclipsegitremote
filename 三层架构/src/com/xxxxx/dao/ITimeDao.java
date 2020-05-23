package com.xxxxx.dao;

import java.sql.Date;

public interface ITimeDao {
	//String——》sql.Date
	public Date StringToSqlDate(String s);
}
