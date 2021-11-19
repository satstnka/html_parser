package jp.trans_it.html_parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	private static final String URL = "https://weather.yahoo.co.jp/weather/jp/9/4110/9201.html";

	public static void main(String[] args) throws IOException {
		List<Weather> list = parse();
		for(Weather weather: list) {
			System.out.println(weather);
		}
	}

	public static List<Weather> parse() throws IOException {
		List<Weather> list = new ArrayList<Weather>();

		Document doc = Jsoup.connect(URL).get();
		Element table = doc.selectFirst(".yjw_table2");
		if(table == null) {
			System.out.println("情報の取得に失敗しました。");
			return list;
		}

		Elements trElements = table.select("tr");
		int step = 0;
		for(Element tr : trElements) {
			Elements tdElements =   tr.select("td");
			int index = -1;    // 最初の列はタイトルなので -1 としておく

			for(Element td : tdElements) {
				if(index >= 0) {
					String information = td.text(); // 情報取得

					if(step == 0) {    // 最初の行は時刻
						Weather weather = new Weather();
						list.add(weather);

						weather.setTime(information);
					}
					else if(step == 1){    // 天気
						list.get(index).setWeather(information);
					}
					else if(step == 2) {    // 気温
						list.get(index).setTemperature(information);
					}
					else if(step == 3) {    // 湿度
						list.get(index).setHumidity(information);
					}
					else if(step == 4) {    // 降水量
						list.get(index).setPrecipitation(information);
					}
					else if(step == 5) {
						list.get(index).setWind(information);
					}
				}
				index++;
			}
			step++;
		}

		return list;
	}
}
