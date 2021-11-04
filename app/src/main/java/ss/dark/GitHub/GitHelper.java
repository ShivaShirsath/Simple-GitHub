package ss.dark.GitHub;

import com.android.volley.toolbox.Volley;
import android.content.Context;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONArray;
import android.widget.Toast;
import org.json.JSONObject;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class GitHelper {
	public static Context context = null;
	public static JSONObject obj ;
	public static JSONArray array ;
	public static String username;
	GitHelper(Context context, String username){
		this.context = context;
		this.username = username;
	}
	public static JSONObject getJSONobject(){
		Volley.newRequestQueue(context).add(
			new JsonArrayRequest(
				Request.Method.GET,
				"https://api.github.com/users/ShivaShirsath",
				null,
				new Response.Listener<JSONArray>(){
					@Override
					public void onResponse(JSONArray response) {
						try{
							array = response ;
						} catch(Exception e){
							Toast.makeText(context,"JSON() :" + e.getMessage(), Toast.LENGTH_LONG).show();
						}
					}
				},
				new Response.ErrorListener(){
					@Override
					public void onErrorResponse(VolleyError e) {
						Toast.makeText(context,"JSON(error) :" + e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			)
		);
		return obj ;
	}
	public static JSONArray getJSONarray(){
		Volley.newRequestQueue(context).add(
			new JsonArrayRequest(
				Request.Method.GET,
				"https://api.github.com/users/ShivaShirsath/repos",
				null,
				new Response.Listener<JSONArray>(){
					@Override
					public void onResponse(JSONArray response) {
						try{
							array = response ;
						} catch(Exception e){
							Toast.makeText(context, "JSON[] :" + e.getMessage(), Toast.LENGTH_LONG).show();
						}
					}
				},
				new Response.ErrorListener(){
					@Override
					public void onErrorResponse(VolleyError e) {
						Toast.makeText(context, "JSON[error] :" + e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			)
		);
		return array ;
	}
	
}
