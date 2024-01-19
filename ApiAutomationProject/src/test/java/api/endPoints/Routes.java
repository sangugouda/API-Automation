package api.endPoints;

public class Routes {
	
	// https://petstore.swagger.io/v2/user - Post
	// https://petstore.swagger.io/v2/user/:userId - get 
	// https://petstore.swagger.io/v2/user/:userId - put
	// https://petstore.swagger.io/v2/user/:userId - delete  
	
	public static String base_Url = "https://petstore.swagger.io/v2";
	
	// User Module Urls
	public static String post_Url = base_Url + "/user";
	public static String get_Url = base_Url + "/user/{userName}";
	public static String put_Url = base_Url + "/user/{userName}";
	public static String delete_Url = base_Url + "/user/{userName}";
	
	
	
	//Store Module URL's
	
	public static String storePost_Url = base_Url + "/store/order";
	public static String sinleStoreGet_Url = base_Url + "/store/order/{orderId}";
	public static String storeDelete_Url =  base_Url + "/store/order/{orderId}";
	public static String getStoreDetails = base_Url + "/store/inventory";
	
	
}
