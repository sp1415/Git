package zAPI;

public class APIExecution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			testCases tC = new testCases();

			tC.listUsers();
			tC.createUser();
			tC.updateUser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
