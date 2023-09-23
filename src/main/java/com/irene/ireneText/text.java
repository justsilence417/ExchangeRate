package com.irene.ireneText;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class text {

	public static void main(String[] args) {
        // 本地JSON檔案路徑
	 String jsonFilePath ="C:\\Users\\irene\\Downloads\\DailyForeignExchangeRates.json";


        try {
            String json = getJsonFromFile(jsonFilePath);
            parseJSON(json);
            System.out.println("Finish");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static String getJsonFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

    // Parse JSON
    static void parseJSON(String json) throws Exception {
    	Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exchange", prop);
		
		Statement stmt = conn.createStatement();
        

        String sql = "INSERT INTO ExchangeRates (date, usd_to_ntd, rmb_to_ntd, eur_to_usd, usd_to_jpy, gbp_to_usd, aud_to_usd, usd_to_hkd, usd_to_rmb, usd_to_zar, nzd_to_usd)" + 
                     " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);

            pstmt.setString(1, jsonData.getString("Date"));
            pstmt.setDouble(2, Double.parseDouble(jsonData.getString("USD/NTD")));
            pstmt.setDouble(3, Double.parseDouble(jsonData.getString("RMB/NTD")));
            pstmt.setDouble(4, Double.parseDouble(jsonData.getString("EUR/USD")));
            pstmt.setDouble(5, Double.parseDouble(jsonData.getString("USD/JPY")));
            pstmt.setDouble(6, Double.parseDouble(jsonData.getString("GBP/USD")));
            pstmt.setDouble(7, Double.parseDouble(jsonData.getString("AUD/USD")));
            pstmt.setDouble(8, Double.parseDouble(jsonData.getString("USD/HKD")));
            pstmt.setDouble(9, Double.parseDouble(jsonData.getString("USD/RMB")));
            pstmt.setDouble(10, Double.parseDouble(jsonData.getString("USD/ZAR")));
            pstmt.setDouble(11, Double.parseDouble(jsonData.getString("NZD/USD")));
            
            pstmt.executeUpdate();
        }
        
        pstmt.close();
        stmt.close();
        conn.close();

    }

}
