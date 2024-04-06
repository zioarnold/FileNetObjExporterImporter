package r2u.tools.custom;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.CustomObject;
import com.filenet.api.property.Properties;
import org.apache.log4j.Logger;

@SuppressWarnings({"DuplicatedCode"})
public class FNCustomObjects {
    private static final Logger logger = Logger.getLogger(FNCustomObjects.class.getName());
    static Properties documentDestinationProperties;
    public static void saveACQSecurityProxy(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQConfiguration(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("val_name", documentSource.getProperties().getStringValue("val_name"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQPECErrorReports(CustomObject documentSource, CustomObject documentDestination) {
        documentDestinationProperties.putValue("id_message", documentSource.getProperties().getStringValue("id_message"));
        documentDestinationProperties.putValue("id_mail", documentSource.getProperties().getStringValue("id_mail"));
        documentDestinationProperties.putValue("tipo_ricevuta", documentSource.getProperties().getStringValue("tipo_ricevuta"));
        documentDestinationProperties.putValue("mittente", documentSource.getProperties().getStringValue("mittente"));
        documentDestinationProperties.putValue("mittente_originario", documentSource.getProperties().getStringValue("mittente_originario"));
        documentDestinationProperties.putValue("emails", documentSource.getProperties().getStringValue("emails"));
        documentDestinationProperties.putValue("oggetto", documentSource.getProperties().getStringValue("oggetto"));
        documentDestinationProperties.putValue("data_ricezione", documentSource.getProperties().getDateTimeValue("data_ricezione"));
        documentDestinationProperties.putValue("motivazione_scarto", documentSource.getProperties().getStringValue("motivazione_scarto"));
        documentDestinationProperties.putValue("con_errore", documentSource.getProperties().getBooleanValue("con_errore"));
        documentDestinationProperties.putValue("filename", documentSource.getProperties().getStringValue("filename"));
        documentDestinationProperties.putValue("mail_sent", documentSource.getProperties().getBooleanValue("mail_sent"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQRelationships(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("head_chronicle_id", documentSource.getProperties().getIdValue("head_chronicle_id"));
        documentDestinationProperties.putValue("tail_chronicle_id", documentSource.getProperties().getIdValue("tail_chronicle_id"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQLookup(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("scope", documentSource.getProperties().getStringValue("scope"));
        documentDestinationProperties.putValue("codice_lookup", documentSource.getProperties().getInteger32Value("codice_lookup"));
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsCounterReport(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("num_schede_archiviazione", documentSource.getProperties().getInteger32Value("num_schede_archiviazione"));
        documentDestinationProperties.putValue("num_stampe_oda", documentSource.getProperties().getInteger32Value("num_stampe_oda"));
        documentDestinationProperties.putValue("num_varianti", documentSource.getProperties().getInteger32Value("num_varianti"));
        documentDestinationProperties.putValue("num_doc_correlati", documentSource.getProperties().getInteger32Value("num_doc_correlati"));
        documentDestinationProperties.putValue("bo_chronicle_id", documentSource.getProperties().getIdValue("bo_chronicle_id"));
        documentDestinationProperties.putValue("num_riferimenti_doc", documentSource.getProperties().getInteger32Value("num_riferimenti_doc"));
        documentDestinationProperties.putValue("num_allegati_doc", documentSource.getProperties().getInteger32Value("num_allegati_doc"));
        documentDestinationProperties.putValue("num_allegati_tipologie", documentSource.getProperties().getStringValue("num_allegati_tipologie"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveUDACodes(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("anno_emissione", documentSource.getProperties().getInteger32Value("anno_emissione"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("codice_def", documentSource.getProperties().getStringValue("codice_def"));
        documentDestinationProperties.putValue("progressivo", documentSource.getProperties().getInteger32Value("progressivo"));
        documentDestinationProperties.putValue("data_invio", documentSource.getProperties().getDateTimeValue("data_invio"));
        documentDestinationProperties.putValue("ente_emittente_str", documentSource.getProperties().getStringValue("ente_emittente_str"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveDossierCodes(CustomObject documentDestination, CustomObject documentSource) {
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("buyer_gestore", documentSource.getProperties().getStringValue("buyer_gestore"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("anno_emissione", documentSource.getProperties().getInteger32Value("anno_emissione"));
        documentDestinationProperties.putValue("progressivo", documentSource.getProperties().getInteger32Value("progressivo"));
        documentDestinationProperties.putValue("codice_def", documentSource.getProperties().getStringValue("codice_def"));
        documentDestinationProperties.putValue("link_uda", documentSource.getProperties().getInteger32Value("link_uda"));
        documentDestinationProperties.putValue("ente_emittente_str", documentSource.getProperties().getStringValue("ente_emittente_str"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }
}
