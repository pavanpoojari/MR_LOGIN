package com.niit.loginapp.DAO;

public class UserDAO {

	public boolean isValidUser(String userID,String password) {
		if(userID.equals("niit") && password.equals("niit")){
			
			return true;
		}else{
			return false;
		}
	}
}
