package jp.trans_it.html_parser;

public class Weather {
	private String time;                // 時刻
	private String weather;             // 天気
	private String temperature;         // 気温
	private String humidity;            // 湿度
	private String precipitation;       // 降水量
	
	private String wind;                // 風

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	
	public String toString() {
		String string = String.format(
			"%s : %s  (気温: %s ℃, 湿度 %s %%, 降水量 %s mm, 風: %s m/s)",
			this.time,
			this.weather,
			this.temperature,
			this.humidity,
			this.precipitation,
			this.wind
		);

		return string;
	}
}
