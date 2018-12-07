import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
public class Send_HTTP_Request2 {

public static void call_me() throws Exception {
     String url = "http://node-web.flyrobeapp.com/get_home_page?screen_type=1&warehouse_id=5";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     //con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
   
     System.out.println(response);
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     JSONObject objectdata=new JSONObject(myResponse.getJSONObject("data").toString());
     JSONArray obj_JSONArray1 = objectdata.getJSONArray("collections");
     System.out.println("obj_JSONArray1 "+obj_JSONArray1);
     JSONObject collectionschildindex_0_getid=obj_JSONArray1.getJSONObject(0);
     System.out.println("collectionschildindex_0_getid "+collectionschildindex_0_getid);
     System.out.println("id  "+collectionschildindex_0_getid.getString("_id"));
     
     }
        public static void main(String[] args) throws Exception {
	     
        Send_HTTP_Request2.call_me();
       
	   
     }
}