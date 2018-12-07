import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class Test_URL_Req {
public static void main(String[] args) {
try {
  String url = "http://api.fixer.io/latest";
  URL obj = new URL(url);
  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
  int responseCode = con.getResponseCode();
  System.out.println("\nSending 'GET' request to URL : " + url);
  System.out.println("Response Code : " + responseCode);
  BufferedReader in =new BufferedReader(
  new InputStreamReader(con.getInputStream()));
  String inputLine;
  StringBuffer response = new StringBuffer();
   while ((inputLine = in.readLine()) != null) {
     response.append(inputLine);
   } in .close();
   //print in String
   // System.out.println(response.toString());
   JSONObject myresponse = new JSONObject(response.toString());
   System.out.println(myresponse);
   System.out.println("base -" + myresponse.getString("base"));
   System.out.println("date -" + myresponse.getString("date"));
   JSONObject rates_object = new JSONObject(myresponse.getJSONObject("rates").toString());
   System.out.println("rates -" + rates_object);
   System.out.println("AUD -" + rates_object.getDouble("AUD"));
   System.out.println("BGN -" + rates_object.getDouble("BGN"));
   System.out.println("BRL -" + rates_object.getDouble("BRL"));
    System.out.println("CAD -" + rates_object.getDouble("CAD"));
  } catch(Exception e) {
    System.out.println(e);
  }
 }
}