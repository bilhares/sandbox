package com.example.demo.outros;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpPost {
	public static void main(String[] args) throws IOException {
		String urlUpload ="url";
		
		Map<String, String> params = new HashMap<>();
		params.put("chave", "val");
		params.put("obs", "obs");
		
		HttpHelper http = new HttpHelper();
		http.setContentType("application/x-www-form-urlencoded");
		http.setCharsetToEncode("UTF-8");
		String json = http.doPost(urlUpload, params, "UTF-8");
		System.out.println(json);
	}
}
