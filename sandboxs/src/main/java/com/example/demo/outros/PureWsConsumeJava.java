package com.example.demo.outros;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class PureWsConsumeJava {
	public static void main(String[] args) throws Exception {

		URL url = new URL("");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String apiOutput = br.readLine();

		// JSONObject json = new JSONObject(apiOutput);

		JSONArray array = new JSONArray(apiOutput);

		for (int i = 0; i < array.length(); i++) {

			JSONObject jsonObject = array.getJSONObject(i);

			JSONObject dadosGeral = (JSONObject) jsonObject.get("a");

			String processoAtual = dadosGeral.getString("b");
			// cabecalho
			System.out.println(jsonObject.get("c")+" - "+processoAtual);
			// 01
			System.out.println(jsonObject.get("d"));
			
			JSONArray dadosInracao = (JSONArray) jsonObject.get("e");
			
			for (int j = 0; j < dadosInracao.length(); j++) {
				JSONObject object = (JSONObject) dadosInracao.get(i);
				System.out.println(object.getString("f"));
				
			}
			
			// 02
			JSONArray dadosInfra = jsonObject.getJSONArray("g");
			// foreach 02
			for (int j = 0; j < dadosInfra.length(); j++) {
				JSONObject object = (JSONObject) dadosInfra.get(j);
				System.out.println(object.getString("h"));
			}
			// 03
			System.out.println(jsonObject.get("i"));
			// 04
			JSONArray dadosHistPont = jsonObject.getJSONArray("j");
			// foreach 04
			for (int j = 0; j < dadosInfra.length(); j++) {
				JSONObject object = (JSONObject) dadosInfra.get(j);
				System.out.println(object.getString("k"));
			}
		}

		System.out.println(apiOutput);
		conn.disconnect();
	}
}
