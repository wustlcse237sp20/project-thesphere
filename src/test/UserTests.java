package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.User;

public class UserTests {
	
	private static User testUser;
	
	@BeforeClass
	public static void setup() {
		try {
			testUser = User.createNewUser("test_first", "test_last", "test@email", "testpass");
		}
		catch (IOException e) {
			System.out.println("Failed creating test user");
			e.printStackTrace();
		}
	}

	@Test
	public void userCreation() {
		assertEquals("test_first test_last", testUser.getName());
	}
	
	@Test
	public void passwordCheck() {
		assertFalse(User.checkEmailAndPassword("test@email", "wrong"));
		assertTrue(User.checkEmailAndPassword("test@email", "testpass"));
	}
	
	@AfterClass
	public static void takedown() {
		File f = new File("Users/test@email");
		for (File x : f.listFiles()) {
			x.delete();
		}
		if (f.delete()) {
			System.out.println("Test user successfully deleted");
		}
	}

}
