package r2u.tools.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import r2u.tools.config.Configurator;
import r2u.tools.connector.FNConnector;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSONParser {
    private static final Logger logger = Logger.getLogger(JSONParser.class.getName());

    public void parseJson(String json) {
        JSONObject jsonObject;
        try {
            URI uri = Paths.get(json).toUri();
            jsonObject = getJSON(new URI(uri.toString()).toURL());
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException is caught: " + e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException is caught: " + e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            logger.error("URISyntaxException is caught: " + e.getLocalizedMessage(), e);
            throw new RuntimeException(e);
        }

        HashMap<String, Boolean> customObjectMap = convertArrayList2HashMap(
                convertObject2StringArrayList(jsonObject.getJSONArray("objectClasses").getJSONObject(0).getJSONArray("CustomObject").toList())
        );
        HashMap<String, Boolean> documentMap = convertArrayList2HashMap(
                convertObject2StringArrayList(jsonObject.getJSONArray("objectClasses").getJSONObject(0).getJSONArray("Document").toList())
        );

        FNConnector fnConnector = new FNConnector();
        //noinspection ConstantValue
        if (jsonObject != null) {
            Configurator instance = Configurator.getInstance();
            instance.setUriSource(jsonObject.getString("sourceCPE"));
            instance.setObjectStoreSource(jsonObject.getString("sourceCPEObjectStore"));
            instance.setUriDestination(jsonObject.getString("destinationCPE"));
            instance.setObjectStoreDestination("destinationCPEObjectStore");
            instance.setSourceCPEUsername(jsonObject.getString("sourceCPEUsername"));
            instance.setSourceCPEPassword(jsonObject.getString("sourceCPEPassword"));
            instance.setDestinationCPEUsername(jsonObject.getString("destinationCPEUsername"));
            instance.setDestinationCPEPassword(jsonObject.getString("destinationCPEPassword"));
            instance.setDocumentClass(jsonObject.getString("documentClass"));
            instance.setJaasStanzaName(jsonObject.getString("jaasStanzaName"));
            instance.setCustomObjectMap(customObjectMap);
            instance.setDocumentClassMap(documentMap);
        }
        fnConnector.startExportImport();
    }

    private static JSONObject getJSON(URL url) throws IOException {
        return new JSONObject(IOUtils.toString(url, StandardCharsets.UTF_8));
    }

    private static ArrayList<String> convertObject2StringArrayList(List<Object> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        //Converto oggetti in stringhe
        for (Object object : list) {
            arrayList.add(object.toString());
        }
        return arrayList;
    }

    private static HashMap<String, Boolean> convertArrayList2HashMap(ArrayList<String> objectList) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String object : objectList) {
            map.put(object.split("=")[0], Boolean.valueOf(object.split("=")[1]));
        }
        return map;
    }
}
