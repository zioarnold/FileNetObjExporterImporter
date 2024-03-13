import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import r2u.tools.connector.FNConnector;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class JSONParser {
    public void parseJson(String json) throws IOException, URISyntaxException {
        URI uri = Paths.get(json).toUri();
        JSONObject jsonObject = getJSON(new URI(uri.toString()).toURL());
        FNConnector fnConnector = new FNConnector(
                jsonObject.getString("sourceCPE"),
                jsonObject.getString("sourceCPEObjectStore"),
                jsonObject.getString("destinationCPE"),
                jsonObject.getString("destinationCPEObjectStore"),
                jsonObject.getString("sourceCPEUsername"),
                jsonObject.getString("sourceCPEPassword"),
                jsonObject.getString("destinationCPEUsername"),
                jsonObject.getString("destinationCPEPassword"),
                jsonObject.getString("documentClass"),
                jsonObject.getString("jaasStanzaName"),
                jsonObject.getJSONArray("objectClasses")
        );
        fnConnector.startExportImport();
    }

    private static JSONObject getJSON(URL url) throws IOException {
        String string = IOUtils.toString(url, StandardCharsets.UTF_8);
        return new JSONObject(string);
    }
}
