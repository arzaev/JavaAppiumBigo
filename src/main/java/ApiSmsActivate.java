import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiSmsActivate {
    OkHttpClient client = new OkHttpClient();
    String _service;
    String _api;

    public ApiSmsActivate(String service, String api) {
        _service = service;
        _api = api;
    }

    public String GetNumber() throws IOException {
        Request request = new Request.Builder()
                .url("http://sms-activate.ru/stubs/handler_api.php?api_key=" +
                        _api + "&action=getNumber&service=" +
                        _service + "&")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }

    public String Ready(String id) throws IOException {
        Request request = new Request.Builder()
                .url("http://sms-activate.ru/stubs/handler_api.php?api_key=" + _api +
                        "&action=setStatus&status=1&id=" + id)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }

    public String GetCode(String id) throws IOException {
        Request request = new Request.Builder()
                .url("http://sms-activate.ru/stubs/handler_api.php?api_key=" + _api +
                        "&action=getStatus&id=" + id)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }

}
