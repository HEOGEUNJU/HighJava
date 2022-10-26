package kr.or.ddit.basic;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6300000/storyDaejeonService/storyDaejeonList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("searchCondition","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*TITLE=제목WRITER_NM=작성자CONTENT=내용*/
        urlBuilder.append("&" + URLEncoder.encode("searchKeyword","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("categorySeq","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*291: 소통하는행정292: 희망원도심으로293: 함께사회적자본294: 경제복지환경295: 문화예술관광296: 과학도시대전*/
        urlBuilder.append("&" + URLEncoder.encode("ntatcSeq","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("ntatcSeq","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}