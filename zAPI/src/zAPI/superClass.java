package zAPI;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("deprecation")
public class superClass {

	int statusCode;

	String endPoint, status, apiName;

	String responseBody = null;

	public static final String Host = "https://reqres.in/api";

	JSONObject requestParams = new JSONObject();

	public String getResponse(String endPoint) {

		try {
			RestAssured.baseURI = Host;
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.request(Method.GET, endPoint);
			statusCode = response.getStatusCode();
			responseBody = response.getBody().asString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBody;
	}

	public String postResponse(String endPoint) {

		try {
			RestAssured.baseURI = Host;
			RequestSpecification request = RestAssured.given();
			request.body(requestParams.toJSONString());
			Response response = request.post(endPoint);
			statusCode = response.getStatusCode();
			responseBody = response.getBody().asString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBody;
	}

	public void status(String APIName) {
		try {

			System.out.println("StatusCode = " + statusCode + "\n" + APIName + " response = " + responseBody);

			if ((statusCode == 200 || statusCode == 201) && responseBody != null) {

				status = "Execution passed";

			} else {
				status = "Execution failed";
			}
			System.out.println(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
