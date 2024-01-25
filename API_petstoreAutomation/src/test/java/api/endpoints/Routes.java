package api.endpoints;

/*
 Swagger URI- https://petstore.swagger.io
CREATE user(POST)- https://petstore.swagger.io/v2/user
GET user (GET) - https://petstore.swagger.io/v2/user/{username}
Update user (PUT)- https://petstore.swagger.io/v2/user/{username}
Delete user (DELETE)- https://petstore.swagger.io/v2/user/{username}
*/
public class Routes {
	public static String base_url ="https://petstore.swagger.io/v2";
	//User module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

	
	
	//store module
	//store module URL's
	//pet module
	//pet module URL's
}
