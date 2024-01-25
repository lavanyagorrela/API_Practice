package api.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.userEndpoints;
import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.response.Response;

public class userTests {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeSuite
	public void setUp() {
		 htmlReporter= new ExtentHtmlReporter("extentReports.html");
		//create extentReports and attach reports
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData()
	{
	faker= new Faker();
	userPayload= new User();
	
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5,10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response=userEndpoints.createUser(userPayload);
		response.then().log().all();
	 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetUserByName() 
	{
		Response response=userEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void testUpdateUserByName() {
		
	
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response=userEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseAfterupdate=userEndpoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response response=userEndpoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	

}
