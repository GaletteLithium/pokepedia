package com.grotteazuree;

public class Login {
	public static void login(String username) {
		API.login(username,  getPassword(username));
	}
	
	public static String getPassword(String username) {
		switch (username) {
		}
	}
}
