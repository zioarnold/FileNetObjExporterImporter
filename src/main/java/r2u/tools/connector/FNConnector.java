package r2u.tools.connector;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.util.UserContext;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.log4j.Logger;
import r2u.tools.config.Configurator;
import r2u.tools.constants.Constants;
import r2u.tools.custom.FNCustomObject;
import r2u.tools.document.FNDocument;
import r2u.tools.utils.JSONParser;

import javax.security.auth.Subject;

public class FNConnector {
    Configurator instance = Configurator.getInstance();
    private static final Logger logger = Logger.getLogger(JSONParser.class.getName());

    public FNConnector() {
    }

    public void startExportImport() {
        long startTime, endTime;
        String[] documentClass = instance.getDocumentClass().split(",");
        instance.setObjectStoreStart(getSourceConnection());
        instance.setObjectStoreEnd(getSourceConnection());
        //scorro la chiave documentClass da JSON, attualmente sono due: Document,CustomObject
        for (String docClass : documentClass) {
            switch (docClass) {
                default: {
                    logger.info("Please specify 'documentClass' in your config.json. Accepted values are: Document,CustomObject - case sensitive!!!");
                    System.exit(-1);
                }
                break;
                case "Document": {
                    if (getSourceConnection() != null && getDestinationConnection() != null) {
                        startTime = System.currentTimeMillis();
                        FNDocument fnDocument = new FNDocument();
                        fnDocument.processDocumentClasses(docClass);
                        endTime = System.currentTimeMillis();
                        logger.info("processDocumentClasses terminated within: " +
                                DurationFormatUtils.formatDuration(endTime - startTime, Constants.dateTimeFormat, true));
                    } else {
                        logger.error("Neither source and destination URIs are available.");
                        System.exit(-1);
                    }
                }
                break;
                case "CustomObject": {
                    if (getSourceConnection() != null && getDestinationConnection() != null) {
                        startTime = System.currentTimeMillis();
                        FNCustomObject fnCustomObject = new FNCustomObject();
                        fnCustomObject.processCustomObjects(docClass);
                        endTime = System.currentTimeMillis();
                        logger.info("processCustomObjects terminated within: " +
                                DurationFormatUtils.formatDuration(endTime - startTime, Constants.dateTimeFormat, true));
                    } else {
                        logger.error("Neither source and destination URIs are available.");
                        System.exit(-1);
                    }
                }
                break;
            }
        }
    }

    private ObjectStore getSourceConnection() {
        Domain sourceDomain;
        Connection sourceConnection;
        ObjectStore objectStoreSource;
        try {
            sourceConnection = Factory.Connection.getConnection(instance.getUriSource());
            Subject sourceSubject = UserContext.createSubject(Factory.Connection.getConnection(instance.getUriSource()),
                    instance.getSourceCPEUsername(), instance.getSourceCPEPassword(), instance.getJaasStanzaName());
            UserContext.get().pushSubject(sourceSubject);
            sourceDomain = Factory.Domain.fetchInstance(sourceConnection, null, null);
            logger.info("FileNet sourceDomain name: " + sourceDomain.get_Name());
            objectStoreSource = Factory.ObjectStore.fetchInstance(sourceDomain, instance.getObjectStoreSource(), null);
            logger.info("Object Store source: " + objectStoreSource.get_DisplayName());
            logger.info("Connected to Source CPE successfully:" + sourceConnection.getURI() + " " + sourceConnection.getConnectionType());
            return objectStoreSource;
        } catch (EngineRuntimeException exception) {
            logger.error("Unable to establish connection with: " + instance.getUriSource(), exception);
            System.exit(-1);
            return null;
        }
    }

    private ObjectStore getDestinationConnection() {
        Domain destinationDomain;
        Connection destinationConnection;
        ObjectStore objectStoreDestination;
        try {
            destinationConnection = Factory.Connection.getConnection(instance.getUriDestination());
            Subject destinationSubject = UserContext.createSubject(Factory.Connection.getConnection(instance.getUriDestination()),
                    instance.getDestinationCPEUsername(), instance.getDestinationCPEPassword(), instance.getJaasStanzaName());
            UserContext.get().pushSubject(destinationSubject);
            destinationDomain = Factory.Domain.fetchInstance(destinationConnection, null, null);
            logger.info("FileNet destinationDomain name: " + destinationDomain.get_Name());
            objectStoreDestination = Factory.ObjectStore.fetchInstance(destinationDomain, instance.getObjectStoreDestination(), null);
            logger.info("Object Store destination: " + objectStoreDestination.get_DisplayName());
            logger.info("Connected to Destination CPE successfully: " + destinationConnection.getURI() + " " + destinationConnection.getConnectionType());
            return objectStoreDestination;
        } catch (EngineRuntimeException exception) {
            logger.error("Unable to establish connection with: " + instance.getUriDestination(), exception);
            System.exit(-1);
            return null;
        }
    }
}
