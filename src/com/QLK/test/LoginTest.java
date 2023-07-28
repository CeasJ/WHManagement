package com.QLK.test;
import org.testng.AssertJUnit;

import com.QLK.dao.TaiKhoanDAO;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;



public class LoginTest {
	TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

	@Test
	public void checkLogin1() {
		String username = "";
		String password = "";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogin2() {
		String username = "";
		String password = "123";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogin3() {
		String username = "KietLT";
		String password = "";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogin4() {
		String username = "Kiet123";
		String password = "123";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogi5() {
		String username = "Kiet123";
		String password = "23";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogin6() {
		String username = "KietLT";
		String password = "23";
		boolean expected = false;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	public void checkLogin7() {
		String username = "KietLT";
		String password = "123";
		boolean expected = true;
		boolean actual = taiKhoanDAO.checkLogin(username, password);
		AssertJUnit.assertEquals(actual, expected);
	}

	public static void main(String[] args) throws Exception {
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(LoginTest.class);
		System.out.println("run tests: " + result.getRunCount());
		System.out.println("failed tests: " + result.getFailureCount());
		System.out.println("ignored tests: " + result.getIgnoreCount());
		System.out.println("success: " + result.wasSuccessful());
	}
}

