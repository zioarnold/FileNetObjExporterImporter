package r2u.tools.connector;

import com.filenet.api.core.*;
import com.filenet.api.property.Properties;
import com.filenet.api.query.RepositoryRow;
import com.filenet.api.util.UserContext;
import org.json.JSONArray;
import r2u.tools.custom.*;
import r2u.tools.document.*;

import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"SpellCheckingInspection", "DuplicatedCode"})
public class FNConnector {
    private final String uriSource;
    private final String objectStoreSource;
    private final String uriDestination;
    private final String objectStoreDestination;
    private final String sourceCPEUsername;
    private final String sourceCPEPassword;
    private final String destinationCPEUsername;
    private final String destinationCPEPassword;
    private final String documentClass;
    private final String jaasStanzaName;
    private final JSONArray objectClasses;
    static Connection sourceConnection = null;
    static Connection destinationConnection = null;

    public FNConnector(String uriSource,
                       String objectStoreSource,
                       String uriDestination,
                       String objectStoreDestination,
                       String sourceCPEUsername,
                       String sourceCPEPassword,
                       String destinationCPEUsername,
                       String destinationCPEPassword,
                       String documentClass,
                       String jaasStanzaName,
                       JSONArray objectClasses) {
        this.uriSource = uriSource;
        this.objectStoreSource = objectStoreSource;
        this.uriDestination = uriDestination;
        this.objectStoreDestination = objectStoreDestination;
        this.sourceCPEUsername = sourceCPEUsername;
        this.sourceCPEPassword = sourceCPEPassword;
        this.destinationCPEUsername = destinationCPEUsername;
        this.destinationCPEPassword = destinationCPEPassword;
        this.documentClass = documentClass;
        this.jaasStanzaName = jaasStanzaName;
        this.objectClasses = objectClasses;
    }

    private boolean isSourceConnected() {
        boolean connected = false;
        if (sourceConnection == null) {
            sourceConnection = Factory.Connection.getConnection(uriSource);
            Subject subject = UserContext.createSubject(sourceConnection, sourceCPEUsername, sourceCPEPassword, jaasStanzaName);
            UserContext.get().pushSubject(subject);
            connected = true;
        }
        return connected;
    }

    private boolean isDestinationConnected() {
        boolean connected = false;
        if (destinationConnection == null) {
            destinationConnection = Factory.Connection.getConnection(uriDestination);
            Subject subject = UserContext.createSubject(destinationConnection, destinationCPEUsername, destinationCPEPassword, jaasStanzaName);
            UserContext.get().pushSubject(subject);
            connected = true;
        }
        return connected;
    }

    public void startExportImport() {
        Domain sourceDomain, destinationDomain;
        String[] documentClass = this.documentClass.split(",");
        List<Object> customObject = this.objectClasses.getJSONObject(0).getJSONArray("CustomObject").toList();
        List<Object> document = this.objectClasses.getJSONObject(0).getJSONArray("Document").toList();

        //Nei hashmap memorizzo il symbolic_name della classe documentale a fianco il suo valore true/false.
        //Se e` true, allora da importare, diversamente - no.
        HashMap<String, Boolean> customObjectMap = new HashMap<>();
        for (Object o : customObject) {
            String[] s = o.toString().split("=");
            customObjectMap.put(s[0], Boolean.parseBoolean(s[1]));
        }
        HashMap<String, Boolean> documentClassMap = new HashMap<>();
        for (Object o : document) {
            String[] s = o.toString().split("=");
            documentClassMap.put(s[0], Boolean.parseBoolean(s[1]));
        }
        //Verifico se raggiungo CPE dell'ingresso e CPE dell'uscita (source, destination).
        //Se non va uno di sopra menzionati, manco lo si fa il lavour
        if (isSourceConnected() && isDestinationConnected()) {
            sourceDomain = Factory.Domain.fetchInstance(sourceConnection, null, null);
            System.out.println("FileNet sourceDomain name: " + sourceDomain.get_Name());

            ObjectStore objectStoreSource = Factory.ObjectStore.fetchInstance(sourceDomain, this.objectStoreSource, null);
            System.out.println("Object Store source: " + objectStoreSource.get_DisplayName());
            System.out.println("Connected to Source CPE successfully:" + sourceConnection.getURI() + " " + sourceConnection.getConnectionType());

            destinationDomain = Factory.Domain.fetchInstance(destinationConnection, null, null);
            System.out.println("FileNet destinationDomain name: " + destinationDomain.get_Name());

            ObjectStore objectStoreDestination = Factory.ObjectStore.fetchInstance(destinationDomain, this.objectStoreDestination, null);
            System.out.println("Object Store destination: " + objectStoreDestination.get_DisplayName());
            System.out.println("Connected to Destination CPE successfully: " + destinationConnection.getURI() + " " + destinationConnection.getConnectionType());
            //scorro la chiave documentClass da JSON, attualmente sono due: Document,CustomObject
            for (String docClass : documentClass) {
                switch (docClass) {
                    default:
                        System.out.println("Please specify 'documentClass' in your config.json. Accepted values are: Document,CustomObject - case sensitive!!!");
                        System.exit(-1);
                        break;
                    case "Document":
                        new FNDocument().processDocumentClasses(docClass, objectStoreSource, objectStoreDestination, documentClassMap);
                        break;
                    case "CustomObject":
                        new FNCustomObject().processCustomObjects(docClass, objectStoreSource, objectStoreDestination, customObjectMap);
                        break;
                }
            }
        }
    }
}
