package r2u.tools.config;

import com.filenet.api.core.ObjectStore;

import java.util.HashMap;

public class Configurator {
    private static Configurator instance = null;
    private String uriSource,
            uriDestination,
            objectStoreSource,
            objectStoreDestination,
            sourceCPEUsername,
            sourceCPEPassword,
            destinationCPEUsername,
            destinationCPEPassword,
            documentClass,
            jaasStanzaName;
    private HashMap<String, Boolean> customObjectMap, documentClassMap, folderMap;
    private ObjectStore objectStoreStart, objectStoreEnd;

    private Configurator() {

    }

    public static synchronized Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }

    public String getUriSource() {
        return uriSource;
    }

    public void setUriSource(String uriSource) {
        this.uriSource = uriSource;
    }

    public String getSourceCPEUsername() {
        return sourceCPEUsername;
    }

    public void setSourceCPEUsername(String sourceCPEUsername) {
        this.sourceCPEUsername = sourceCPEUsername;
    }

    public String getSourceCPEPassword() {
        return sourceCPEPassword;
    }

    public void setSourceCPEPassword(String sourceCPEPassword) {
        this.sourceCPEPassword = sourceCPEPassword;
    }

    public String getDocumentClass() {
        return documentClass;
    }

    public void setDocumentClass(String documentClass) {
        this.documentClass = documentClass;
    }

    public String getJaasStanzaName() {
        return jaasStanzaName;
    }

    public void setJaasStanzaName(String jaasStanzaName) {
        this.jaasStanzaName = jaasStanzaName;
    }

    public HashMap<String, Boolean> getCustomObjectMap() {
        return customObjectMap;
    }

    public void setCustomObjectMap(HashMap<String, Boolean> customObjectMap) {
        this.customObjectMap = customObjectMap;
    }

    public HashMap<String, Boolean> getDocumentClassMap() {
        return documentClassMap;
    }

    public void setDocumentClassMap(HashMap<String, Boolean> documentClassMap) {
        this.documentClassMap = documentClassMap;
    }

    public String getUriDestination() {
        return uriDestination;
    }

    public void setUriDestination(String uriDestination) {
        this.uriDestination = uriDestination;
    }

    public String getDestinationCPEUsername() {
        return destinationCPEUsername;
    }

    public void setDestinationCPEUsername(String destinationCPEUsername) {
        this.destinationCPEUsername = destinationCPEUsername;
    }

    public String getDestinationCPEPassword() {
        return destinationCPEPassword;
    }

    public void setDestinationCPEPassword(String destinationCPEPassword) {
        this.destinationCPEPassword = destinationCPEPassword;
    }

    public String getObjectStoreSource() {
        return objectStoreSource;
    }

    public void setObjectStoreSource(String objectStoreSource) {
        this.objectStoreSource = objectStoreSource;
    }

    public String getObjectStoreDestination() {
        return objectStoreDestination;
    }

    public void setObjectStoreDestination(String objectStoreDestination) {
        this.objectStoreDestination = objectStoreDestination;
    }

    public ObjectStore getObjectStoreStart() {
        return objectStoreStart;
    }

    public void setObjectStoreStart(ObjectStore objectStoreStart) {
        this.objectStoreStart = objectStoreStart;
    }

    public ObjectStore getObjectStoreEnd() {
        return objectStoreEnd;
    }

    public void setObjectStoreEnd(ObjectStore objectStoreEnd) {
        this.objectStoreEnd = objectStoreEnd;
    }
}
