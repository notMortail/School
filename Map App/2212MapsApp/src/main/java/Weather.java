import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

/**
 * Weather class that displays weather on homepage via API
 * @author Richard
 */
public class Weather {
    /**
     * Displayed temperature
     */
    private int temperature;
    /**
     * Displayed weather
     */
    private String condition;
    /**
     * Response from API
     */
    private HttpResponse<String> response;

    /**
     * Retrieves response from API
     * @throws IOException
     * @throws InterruptedException 
     */
    public Weather() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://api.openweathermap.org/data/3.0/onecall?lat=43.007705&lon=-81.273496&exclude=minutely,hourly,daily,alerts&units=metric&appid=9414ad5e853deb8f27974406136e071c"))
                .header("accept", "application/JSON")
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Setter for temperature
     * @param newTemp New temperature
     */
    public void setTemperature(int newTemp){
        temperature = newTemp;
    }

    /**
     * Setter for condition
     * @param newCond New weather
     */
    public void setCondition(String newCond){
        condition = newCond;
    }

    /**
     * Getter for temperature
     * @return temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Getter for weather
     * @return weather
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Getter for response
     * @return response
     */
    public HttpResponse<String> getResponse() {
        return response;
    }
}
