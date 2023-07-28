package com.QLK.test;

import org.testng.Assert;

import org.junit.runner.notification.Failure;
import org.testng.AssertJUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.QLK.dao.TaiKhoanDAO;

public class DoiMatKhauTest {
	TaiKhoanDAO udao = new TaiKhoanDAO();
	@Rule
	public ErrorCollector ec = new ErrorCollector();

	@Test
	public void testChangePassword1() {
	    TaiKhoanDAO udao = new TaiKhoanDAO();
	    String user = "KietLT";
	    String oldPass = "";
	    String newPass = "123";
	    String confirmPass = "123";
	    boolean expected = false;
	    boolean actual = udao.changePassword(user, oldPass, newPass, confirmPass);
	    Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testChangePassword2() {
	    TaiKhoanDAO udao = new TaiKhoanDAO();
	    String user = "KietLT";
	    String oldPass = "123";
	    String newPass = "";
	    String confirmPass = "258";
	    boolean expected = false;
	    boolean actual = udao.changePassword(user, oldPass, newPass, confirmPass);
	    Assert.assertEquals(expected, actual);
	}

	@Test
	public void testChangePassword3() {
	    TaiKhoanDAO udao = new TaiKhoanDAO();
	    String user = "";
	    String oldPass = "";
	    String newPass = "";
	    String confirmPass = "";
	    boolean expected = false;
	    boolean actual = udao.changePassword(user, oldPass, newPass, confirmPass);
	    Assert.assertEquals(expected, actual);
	}

	@Test
	public void testChangePasswordWithMatchingNewPasswords() {
	    TaiKhoanDAO udao = new TaiKhoanDAO();
	    String user = "KietLT";
	    String oldPass = "123";
	    String newPass = "258";
	    String confirmPass = "258";
	    boolean expected = true;
	    boolean actual = udao.changePassword(user, oldPass, newPass, confirmPass);
	    Assert.assertEquals(expected, actual);
	}

	 public static void main(String[] args) {
	        JUnitCore runner = new JUnitCore();
	        Result result = runner.run(DoiMatKhauTest.class);
	        System.out.println("Run tests: " + result.getRunCount());
	        System.out.println("Failed tests: " + result.getFailureCount());
	        System.out.println("Ignored tests: " + result.getIgnoreCount());
	        System.out.println("Success: " + result.wasSuccessful());
	        for (Failure failure : result.getFailures()) {
	            System.out.println("Failure: " + failure.toString());
	        }
	    }
}
