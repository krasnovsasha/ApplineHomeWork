package yandexSpellerGet;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {
	static String sURL = "https://speller.yandex.net/services/spellservice";

	public static void main(String[] args) {
		CloseableHttpResponse response1 = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(sURL + "/checkText?text=это+тестовый+зопрос+к+яндекс+спеллеру");
			response1 = httpclient.execute(httpGet);
			System.out.println(EntityUtils.toString(response1.getEntity()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				assert response1 != null;
				response1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
