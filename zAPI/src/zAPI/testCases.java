package zAPI;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings({ "unchecked", "unused", "deprecation" })
public class testCases extends superClass {

	public void listUsers() {

		apiName = "ListUsers";
		endPoint = "/users?page=2";
		getResponse(endPoint);
		status(apiName);
	}

	public void createUser() {

		apiName = "CreateUser";
		endPoint = "/api/register";

		requestParams.put("email", "Sahajanand");
		requestParams.put("password", "Automation");

		postResponse(endPoint);
		status(apiName);
	}

	public void updateUser() {

		apiName = "UpdateUser";
		endPoint = "/api/users/2";

		requestParams.put("name", "Sahaj");
		requestParams.put("job", "QA Automation");

		postResponse(endPoint);
		status(apiName);
	}
}
