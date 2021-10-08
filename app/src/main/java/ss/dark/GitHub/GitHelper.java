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
	private Context context = null;
	private JSONObject obj ;
	private JSONArray array ;
	public GitHelper(Context context){
		this.context = context ;
	}
	public JSONObject getJSONobject(){
		Volley.newRequestQueue(this.context).add(
			new JsonObjectRequest(
				Request.Method.GET,
				"https://api.github.com/users/ShivaShirsath",
				null,
				new Response.Listener<JSONObject>(){
					@Override
					public void onResponse(JSONObject response) {
						try{
							obj = response ;
						} catch(Exception e){
							e.printStackTrace();
						}
					}
				},
				new Response.ErrorListener(){
					@Override
					public void onErrorResponse(VolleyError e) {

					}
				}
			)
		);
		return obj ;
	}
	public JSONArray getJSONarray(){
		Volley.newRequestQueue(this.context).add(
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
							e.printStackTrace();
						}
					}
				},
				new Response.ErrorListener(){
					@Override
					public void onErrorResponse(VolleyError e) {

					}
				}
			)
		);
		return array ;
	}
	
}
