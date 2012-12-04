package com.unbrokenforge.infinitesource.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginTask extends AsyncTask<String, Void, Boolean> {

	private static String TAG = "LoginTask";
	@Override
	protected Boolean doInBackground(String... params) {
		if(params.length < 2)
		{
			return false;
		}
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String username = params[0];
		String password = params[1];
		HttpPost post = new HttpPost("http://audtag.com/verifylogin.php");
		ArrayList<NameValuePair> postValues = new ArrayList<NameValuePair>();
		postValues.add(new BasicNameValuePair("username", username));
		postValues.add(new BasicNameValuePair("password", password));

		try {
			post.setEntity(new UrlEncodedFormEntity(postValues));

			HttpResponse resp = httpClient.execute(post);
			InputStream is = resp.getEntity().getContent();
						
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = br.readLine();
			if ("false".equals(line)) {
				return false;
			}
			JsonFactory f = new JsonFactory();
			ObjectMapper objectMapper = new ObjectMapper();
			JsonParser jp = f.createJsonParser(br);
		} catch (Exception ex) {
			Log.e(TAG, "Error checking login information" + ex.toString());
		}
		return null;
	}

}
