package r2u.tools.document;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.property.Properties;
import org.apache.log4j.Logger;

@SuppressWarnings({"DuplicatedCode"})
public class FNDocumentClass {
    private static final Logger logger = Logger.getLogger(FNDocumentClass.class.getName());
    protected static Properties documentDestinationProperties;

    public static void saveACQAttachmentsToDocumentOfContracts(Document documentDestination, Document documentSource) {
        saveSameProperties_ACQAttachmentsToODADocuments_DocumentsOfContract(documentDestination, documentSource);
    }

    public static void saveACQAttachmentsToODADocuments(Document documentDestination, Document documentSource) {
        saveSameProperties_ACQAttachmentsToODADocuments_DocumentsOfContract(documentDestination, documentSource);
    }

    public static void saveACQAgreementsProperties(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("anno", documentSource.getProperties().getStringValue("anno"));
        documentDestinationProperties.putValue("docnumber", documentSource.getProperties().getInteger32Value("docnumber"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestinationProperties.putValue("protocollo", documentSource.getProperties().getStringValue("protocollo"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("saving", documentSource.getProperties().getStringValue("saving"));
        documentDestinationProperties.putValue("societa", documentSource.getProperties().getStringValue("societa"));
        documentDestinationProperties.putValue("tipo_contratto", documentSource.getProperties().getStringValue("tipo_contratto"));
        documentDestinationProperties.putValue("versione", documentSource.getProperties().getStringValue("versione"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("importo_totale_contrattualizzato", documentSource.getProperties().getStringValue("importo_totale_contrattualizzato"));
        documentDestinationProperties.putValue("variante", documentSource.getProperties().getBooleanValue("variante"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    private static void saveSameProperties_ACQAttachmentsToODADocuments_DocumentsOfContract(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToRDADocuments(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToRDODocuments(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToAgreements(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToContracts(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("esito_conferma_fornitore", documentSource.getProperties().getStringValue("esito_conferma_fornitore"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("cognome_cancellazione_richiesta"));
        documentDestinationProperties.putValue("data_cancellazione_richiesta", documentSource.getProperties().getDateTimeValue("data_cancellazione_richiesta"));
        documentDestinationProperties.putValue("data_conferma_fornitore", documentSource.getProperties().getDateTimeValue("data_conferma_fornitore"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("data_scadenza", documentSource.getProperties().getDateTimeValue("data_scadenza"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("enti_vis_testo_di_contratto", documentSource.getProperties().getStringValue("enti_vis_testo_di_contratto"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("nome_cancellazione_richiesta", documentSource.getProperties().getStringValue("nome_cancellazione_richiesta"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestinationProperties.putValue("proivenienza", documentSource.getProperties().getStringValue("proivenienza"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("guid_riferimento_documento_testo_srm", documentSource.getProperties().getStringValue("guid_riferimento_documento_testo_srm"));
        documentDestinationProperties.putValue("guid_riferimento_documento_srm", documentSource.getProperties().getStringValue("guid_riferimento_documento_srm"));
        documentDestinationProperties.putValue("codice_tipologia_ritrascrizione", documentSource.getProperties().getStringValue("codice_tipologia_ritrascrizione"));
        documentDestinationProperties.putValue("stato_richiesta_conferma", documentSource.getProperties().getStringValue("stato_richiesta_conferma"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("guid_srm", documentSource.getProperties().getStringValue("guid_srm"));
        documentDestinationProperties.putValue("data_variante", documentSource.getProperties().getDateTimeValue("data_variante"));
        documentDestinationProperties.putValue("variante", documentSource.getProperties().getBooleanValue("variante"));
        documentDestinationProperties.putValue("id_file_ra", documentSource.getProperties().getStringValue("id_file_ra"));
        documentDestinationProperties.putValue("gruppo_acquisti", documentSource.getProperties().getStringValue("gruppo_acquisti"));
        documentDestinationProperties.putValue("tipo_dati_personali", documentSource.getProperties().getStringValue("tipo_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToDocumentSuppliers(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("fornitore_non_anagrafato", documentSource.getProperties().getStringValue("fornitore_non_anagrafato"));
        documentDestinationProperties.putValue("saving", documentSource.getProperties().getStringValue("saving"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToODA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("codice_negoziazione"));
        documentDestinationProperties.putValue("data_scadenza", documentSource.getProperties().getDateTimeValue("data_scadenza"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("ente_richiedente", documentSource.getProperties().getStringValue("ente_richiedente"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestinationProperties.putValue("proivenienza", documentSource.getProperties().getStringValue("proivenienza"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("guid_srm", documentSource.getProperties().getStringValue("guid_srm"));
        documentDestinationProperties.putValue("id_file_ra", documentSource.getProperties().getStringValue("id_file_ra"));
        documentDestinationProperties.putValue("gruppo_acquisti", documentSource.getProperties().getStringValue("gruppo_acquisti"));
        documentDestinationProperties.putValue("tipo_dati_personali", documentSource.getProperties().getStringValue("tipo_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToRDA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("data_scadenza", documentSource.getProperties().getDateTimeValue("data_scadenza"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("ente_richiedente", documentSource.getProperties().getStringValue("ente_richiedente"));
        documentDestinationProperties.putValue("fornitore_presente_in_anagrafe", documentSource.getProperties().getStringValue("fornitore_presente_in_anagrafe"));
        documentDestinationProperties.putValue("gruppo_acquisti", documentSource.getProperties().getStringValue("gruppo_acquisti"));
        documentDestinationProperties.putValue("file_name", documentSource.getProperties().getStringValue("file_name"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("fornitore_non_anagrafato", documentSource.getProperties().getStringValue("fornitore_non_anagrafato"));
        documentDestinationProperties.putValue("trattamento_dati_personali", documentSource.getProperties().getStringValue("trattamento_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachmentsToRDO(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("data_scadenza", documentSource.getProperties().getDateTimeValue("data_scadenza"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQDocumentsToSuppliers(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("fornitore_non_anagrafato", documentSource.getProperties().getStringValue("fornitore_non_anagrafato"));
        documentDestinationProperties.putValue("saving", documentSource.getProperties().getStringValue("saving"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQODAPrints(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("codice_negoziazione"));
        documentDestinationProperties.putValue("data_scadenza", documentSource.getProperties().getDateTimeValue("data_scadenza"));
        documentDestinationProperties.putValue("data_conservazione", documentSource.getProperties().getDateTimeValue("data_conservazione"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("ente_richiedente", documentSource.getProperties().getStringValue("ente_richiedente"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("proivenienza", documentSource.getProperties().getStringValue("proivenienza"));
        documentDestinationProperties.putValue("responsabile_conservazione", documentSource.getProperties().getStringValue("responsabile_conservazione"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("guid_srm", documentSource.getProperties().getStringValue("guid_srm"));
        documentDestinationProperties.putValue("pu_assegnataria", documentSource.getProperties().getStringValue("pu_assegnataria"));
        documentDestinationProperties.putValue("volume_conservazione", documentSource.getProperties().getStringValue("volume_conservazione"));
        documentDestinationProperties.putValue("versione_srm", documentSource.getProperties().getStringValue("versione_srm"));
        documentDestinationProperties.putValue("tipo_rilascio", documentSource.getProperties().getStringValue("tipo_rilascio"));
        documentDestinationProperties.putValue("progressivo_stampe", documentSource.getProperties().getStringValue("progressivo_stampe"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQSCArchiveODA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("xml_scheda_delta_prezzo", documentSource.getProperties().getStringValue("xml_scheda_delta_prezzo"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("link_uda", documentSource.getProperties().getInteger32Value("link_uda"));
        documentDestinationProperties.putValue("link_dossier", documentSource.getProperties().getInteger32Value("link_dossier"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("codice_negoziazione_manuale", documentSource.getProperties().getStringValue("codice_negoziazione_manuale"));
        documentDestinationProperties.putValue("bu_all_chronid_ref", documentSource.getProperties().getStringListValue("bu_all_chronid_ref"));
        documentDestinationProperties.putValue("ente_all_chronid_ref", documentSource.getProperties().getStringListValue("ente_all_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_all_chronid_ref", documentSource.getProperties().getStringListValue("fornitori_all_chronid_ref"));
        documentDestinationProperties.putValue("gestore", documentSource.getProperties().getStringValue("gestore"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQSCArchiveContracts(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("xml_scheda_delta_prezzo", documentSource.getProperties().getStringListValue("xml_scheda_delta_prezzo"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("codice_contratto", documentSource.getProperties().getStringValue("codice_contratto"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("link_uda", documentSource.getProperties().getInteger32Value("link_uda"));
        documentDestinationProperties.putValue("link_dossier", documentSource.getProperties().getInteger32Value("link_dossier"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("codice_negoziazione_manuale", documentSource.getProperties().getStringValue("codice_negoziazione_manuale"));
        documentDestinationProperties.putValue("bu_all_chronid_ref", documentSource.getProperties().getStringListValue("bu_all_chronid_ref"));
        documentDestinationProperties.putValue("ente_all_chronid_ref", documentSource.getProperties().getStringListValue("ente_all_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_all_chronid_ref", documentSource.getProperties().getStringListValue("fornitori_all_chronid_ref"));
        documentDestinationProperties.putValue("gestore", documentSource.getProperties().getStringValue("gestore"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQSCArchiveAgreement(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("xml_scheda_delta_prezzo", documentSource.getProperties().getStringValue("xml_scheda_delta_prezzo"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("codice_contratto", documentSource.getProperties().getStringValue("codice_contratto"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("link_uda", documentSource.getProperties().getInteger32Value("link_uda"));
        documentDestinationProperties.putValue("link_dossier", documentSource.getProperties().getInteger32Value("link_dossier"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("codice_negoziazione_manuale", documentSource.getProperties().getStringValue("codice_negoziazione_manuale"));
        documentDestinationProperties.putValue("bu_all_chronid_ref", documentSource.getProperties().getStringListValue("bu_all_chronid_ref"));
        documentDestinationProperties.putValue("ente_all_chronid_ref", documentSource.getProperties().getStringListValue("ente_all_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_all_chronid_ref", documentSource.getProperties().getStringListValue("fornitori_all_chronid_ref"));
        documentDestinationProperties.putValue("gestore", documentSource.getProperties().getStringValue("gestore"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQRDO(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("ragione_sociale", documentSource.getProperties().getStringValue("ragione_sociale"));
        documentDestinationProperties.putValue("gruppi_merci", documentSource.getProperties().getStringValue("gruppi_merci"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQRDA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("gruppi_merci", documentSource.getProperties().getStringValue("gruppi_merci"));
        documentDestinationProperties.putValue("gruppo_acquisti", documentSource.getProperties().getStringValue("gruppo_acquisti"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("ente_richiedente", documentSource.getProperties().getStringValue("ente_richiedente"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("bo_bu", documentSource.getProperties().getInteger32Value("bo_bu"));
        documentDestinationProperties.putValue("fornitore", documentSource.getProperties().getInteger32Value("fornitore"));
        documentDestinationProperties.putValue("creation_date", documentSource.getProperties().getDateTimeValue("creation_date"));
        documentDestinationProperties.putValue("bo_ente", documentSource.getProperties().getInteger32Value("bo_ente"));
        documentDestinationProperties.putValue("flag_allegati", documentSource.getProperties().getInteger32Value("flag_allegati"));
        documentDestinationProperties.putValue("old_bo_bu", documentSource.getProperties().getInteger32Value("old_bo_bu"));
        documentDestinationProperties.putValue("tipo_negoz", documentSource.getProperties().getInteger32Value("tipo_negoz"));
        documentDestinationProperties.putValue("data_in_val", documentSource.getProperties().getDateTimeValue("data_in_val"));
        documentDestinationProperties.putValue("data_fin_val", documentSource.getProperties().getDateTimeValue("data_fin_val"));
        documentDestinationProperties.putValue("gracq", documentSource.getProperties().getStringValue("gracq"));
        documentDestinationProperties.putValue("sigla", documentSource.getProperties().getStringValue("sigla"));
        documentDestinationProperties.putValue("category_manager", documentSource.getProperties().getStringValue("category_manager"));
        documentDestinationProperties.putValue("flag_sincro", documentSource.getProperties().getStringValue("flag_sincro"));
        documentDestinationProperties.putValue("documento_corr_mig", documentSource.getProperties().getStringValue("documento_corr_mig"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("has_correlazioni", documentSource.getProperties().getBooleanValue("has_correlazioni"));
        documentDestinationProperties.putValue("has_riferimenti", documentSource.getProperties().getBooleanValue("has_riferimenti"));
        documentDestinationProperties.putValue("nomina_trattamento_dati_personali", documentSource.getProperties().getStringValue("nomina_trattamento_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQPOS(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bo_bu", documentSource.getProperties().getInteger32Value("bo_bu"));
        documentDestinationProperties.putValue("bo_ente", documentSource.getProperties().getInteger32Value("bo_ente"));
        documentDestinationProperties.putValue("bo_gm", documentSource.getProperties().getInteger32Value("bo_gm"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("bo_pos", documentSource.getProperties().getStringValue("bo_pos"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("tipo_negoz", documentSource.getProperties().getInteger32Value("tipo_negoz"));
        documentDestinationProperties.putValue("bo_gm_chronid_ref", documentSource.getProperties().getStringValue("bo_gm_chronid_ref"));
        documentDestinationProperties.putValue("creation_date", documentSource.getProperties().getDateTimeValue("creation_date"));
        documentDestinationProperties.putValue("data_fin_val", documentSource.getProperties().getDateTimeValue("data_fin_val"));
        documentDestinationProperties.putValue("data_in_val", documentSource.getProperties().getDateTimeValue("data_in_val"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("fk1", documentSource.getProperties().getInteger32Value("fk1"));
        documentDestinationProperties.putValue("fk2", documentSource.getProperties().getInteger32Value("fk2"));
        documentDestinationProperties.putValue("flag_allegati", documentSource.getProperties().getInteger32Value("flag_allegati"));
        documentDestinationProperties.putValue("flag_cancellato", documentSource.getProperties().getInteger32Value("flag_cancellato"));
        documentDestinationProperties.putValue("flag_migrato", documentSource.getProperties().getStringValue("flag_migrato"));
        documentDestinationProperties.putValue("gracq", documentSource.getProperties().getStringValue("gracq"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("migrato_da", documentSource.getProperties().getStringValue("migrato_da"));
        documentDestinationProperties.putValue("old_bo_bu", documentSource.getProperties().getInteger32Value("old_bo_bu"));
        documentDestinationProperties.putValue("padre", documentSource.getProperties().getInteger32Value("padre"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("sigla", documentSource.getProperties().getStringValue("sigla"));
        documentDestinationProperties.putValue("bo_pu_chronid_ref", documentSource.getProperties().getStringValue("bo_pu_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("has_correlazioni", documentSource.getProperties().getBooleanValue("has_correlazioni"));
        documentDestinationProperties.putValue("has_riferimenti", documentSource.getProperties().getBooleanValue("has_riferimenti"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQPON(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("bo_bu", documentSource.getProperties().getInteger32Value("bo_bu"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQODA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("ragione_sociale", documentSource.getProperties().getStringValue("ragione_sociale"));
        documentDestinationProperties.putValue("gruppi_merci", documentSource.getProperties().getStringValue("gruppi_merci"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("fornitore", documentSource.getProperties().getInteger32Value("fornitore"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("tipo_negoz", documentSource.getProperties().getInteger32Value("tipo_negoz"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("codice_negoziazione"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("ente_richiedente", documentSource.getProperties().getStringValue("ente_richiedente"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("bo_bu", documentSource.getProperties().getInteger32Value("bo_bu"));
        documentDestinationProperties.putValue("creation_date", documentSource.getProperties().getDateTimeValue("creation_date"));
        documentDestinationProperties.putValue("bo_ente", documentSource.getProperties().getInteger32Value("bo_ente"));
        documentDestinationProperties.putValue("flag_allegati", documentSource.getProperties().getInteger32Value("flag_allegati"));
        documentDestinationProperties.putValue("old_bo_bu", documentSource.getProperties().getInteger32Value("old_bo_bu"));
        documentDestinationProperties.putValue("data_in_val", documentSource.getProperties().getDateTimeValue("data_in_val"));
        documentDestinationProperties.putValue("data_fin_val", documentSource.getProperties().getDateTimeValue("data_fin_val"));
        documentDestinationProperties.putValue("gracq", documentSource.getProperties().getStringValue("gracq"));
        documentDestinationProperties.putValue("sigla", documentSource.getProperties().getStringValue("sigla"));
        documentDestinationProperties.putValue("category_manager", documentSource.getProperties().getStringValue("category_manager"));
        documentDestinationProperties.putValue("cancellato_str", documentSource.getProperties().getStringValue("cancellato_str"));
        documentDestinationProperties.putValue("flag_sincro", documentSource.getProperties().getStringValue("flag_sincro"));
        documentDestinationProperties.putValue("documento_corr_mig", documentSource.getProperties().getStringValue("documento_corr_mig"));
        documentDestinationProperties.putValue("richiesta_conferma", documentSource.getProperties().getStringValue("richiesta_conferma"));
        documentDestinationProperties.putValue("negoz_prov", documentSource.getProperties().getStringValue("negoz_prov"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("has_riferimenti", documentSource.getProperties().getBooleanValue("has_riferimenti"));
        documentDestinationProperties.putValue("has_correlazioni", documentSource.getProperties().getBooleanValue("has_correlazioni"));
        documentDestinationProperties.putValue("titolo", documentSource.getProperties().getStringValue("titolo"));
        documentDestinationProperties.putValue("nomina_trattamento_dati_personali", documentSource.getProperties().getStringValue("nomina_trattamento_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQGoodGroupRegistry(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("parent", documentSource.getProperties().getIdValue("parent"));
        documentDestinationProperties.putValue("val_name", documentSource.getProperties().getStringValue("val_name"));
        documentDestinationProperties.putValue("enabled", documentSource.getProperties().getBooleanValue("enabled"));
        documentDestinationProperties.putValue("is_cessato", documentSource.getProperties().getBooleanValue("is_cessato"));
        documentDestinationProperties.putValue("hash_allegato", documentSource.getProperties().getStringValue("hash_allegato"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQSuppliersMasterData(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("val_name", documentSource.getProperties().getStringValue("val_name"));
        documentDestinationProperties.putValue("enabled", documentSource.getProperties().getBooleanValue("enabled"));
        documentDestinationProperties.putValue("cod_fiscale", documentSource.getProperties().getStringValue("cod_fiscale"));
        documentDestinationProperties.putValue("cod_part_iva", documentSource.getProperties().getStringValue("cod_part_iva"));
        documentDestinationProperties.putValue("flag_naz", documentSource.getProperties().getStringValue("flag_naz"));
        documentDestinationProperties.putValue("flag_validita", documentSource.getProperties().getBooleanValue("flag_validita"));
        documentDestinationProperties.putValue("sede", documentSource.getProperties().getStringValue("sede"));
        documentDestinationProperties.putValue("hash_allegato", documentSource.getProperties().getStringValue("hash_allegato"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQAttachments(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bu_rda", documentSource.getProperties().getInteger32Value("bu_rda"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("codice_oda", documentSource.getProperties().getStringValue("codice_oda"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("fornitori_not_anag", documentSource.getProperties().getStringValue("fornitori_not_anag"));
        documentDestinationProperties.putValue("tipo_documento", documentSource.getProperties().getInteger32Value("tipo_documento"));
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("tipo_autorizzazione", documentSource.getProperties().getStringValue("tipo_autorizzazione"));
        documentDestinationProperties.putValue("stato_conservazione", documentSource.getProperties().getInteger32Value("stato_conservazione"));
        documentDestinationProperties.putValue("stato", documentSource.getProperties().getInteger32Value("stato"));
        documentDestinationProperties.putValue("codice_contratto", documentSource.getProperties().getStringValue("codice_contratto"));
        documentDestinationProperties.putValue("data_allegato", documentSource.getProperties().getDateTimeValue("data_allegato"));
        documentDestinationProperties.putValue("data_decorrenza", documentSource.getProperties().getDateTimeValue("data_decorrenza"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("ragione_sociale", documentSource.getProperties().getStringValue("ragione_sociale"));
        documentDestinationProperties.putValue("sede", documentSource.getProperties().getStringValue("sede"));
        documentDestinationProperties.putValue("riservatezza", documentSource.getProperties().getStringValue("riservatezza"));
        documentDestinationProperties.putValue("pubblicabile", documentSource.getProperties().getStringValue("pubblicabile"));
        documentDestinationProperties.putValue("assegnatario", documentSource.getProperties().getStringValue("assegnatario"));
        documentDestinationProperties.putValue("data_documento", documentSource.getProperties().getDateTimeValue("data_documento"));
        documentDestinationProperties.putValue("dimensione", documentSource.getProperties().getInteger32Value("dimensione"));
        documentDestinationProperties.putValue("bo_gm", documentSource.getProperties().getInteger32Value("bo_gm"));
        documentDestinationProperties.putValue("strutture_organizzative", documentSource.getProperties().getInteger32Value("strutture_organizzative"));
        documentDestinationProperties.putValue("note", documentSource.getProperties().getStringValue("note"));
        documentDestinationProperties.putValue("tipologie_trattative", documentSource.getProperties().getInteger32Value("tipologie_trattative"));
        documentDestinationProperties.putValue("tipologie", documentSource.getProperties().getInteger32Value("tipologie"));
        documentDestinationProperties.putValue("valore", documentSource.getProperties().getInteger32Value("valore"));
        documentDestinationProperties.putValue("data_scadenza_contratto", documentSource.getProperties().getDateTimeValue("data_scadenza_contratto"));
        documentDestinationProperties.putValue("data_invio", documentSource.getProperties().getDateTimeValue("data_invio"));
        documentDestinationProperties.putValue("data_partenza", documentSource.getProperties().getDateTimeValue("data_partenza"));
        documentDestinationProperties.putValue("firmatario", documentSource.getProperties().getStringValue("firmatario"));
        documentDestinationProperties.putValue("riferimento_nomina", documentSource.getProperties().getStringValue("riferimento_nomina"));
        documentDestinationProperties.putValue("societa_beneficiarie", documentSource.getProperties().getStringValue("societa_beneficiarie"));
        documentDestinationProperties.putValue("pu", documentSource.getProperties().getStringValue("pu"));
        documentDestinationProperties.putValue("struttura_autorizzata", documentSource.getProperties().getStringValue("struttura_autorizzata"));
        documentDestinationProperties.putValue("trattamenti", documentSource.getProperties().getStringValue("trattamenti"));
        documentDestinationProperties.putValue("link_doc_esterno", documentSource.getProperties().getStringValue("link_doc_esterno"));
        documentDestinationProperties.putValue("archive_type", documentSource.getProperties().getStringValue("archive_type"));
        documentDestinationProperties.putValue("contesto", documentSource.getProperties().getInteger32Value("contesto"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("is_pec", documentSource.getProperties().getBooleanValue("is_pec"));
        documentDestinationProperties.putValue("bo_pu_chronid_ref", documentSource.getProperties().getStringValue("bo_pu_chronid_ref"));
        documentDestinationProperties.putValue("autore", documentSource.getProperties().getInteger32Value("autore"));
        documentDestinationProperties.putValue("tipo_negoz", documentSource.getProperties().getInteger32Value("tipo_negoz"));
        documentDestinationProperties.putValue("bu_all_chronid_ref", documentSource.getProperties().getStringListValue("bu_all_chronid_ref"));
        documentDestinationProperties.putValue("gm_all_chronid_ref", documentSource.getProperties().getStringListValue("gm_all_chronid_ref"));
        documentDestinationProperties.putValue("strut_aut_all_chronid_ref", documentSource.getProperties().getStringListValue("strut_aut_all_chronid_ref"));
        documentDestinationProperties.putValue("fornitori_all_chronid_ref", documentSource.getProperties().getStringListValue("fornitori_all_chronid_ref"));
        documentDestinationProperties.putValue("ente_all_chronid_ref", documentSource.getProperties().getStringListValue("ente_all_chronid_ref"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("has_riferimenti", documentSource.getProperties().getBooleanValue("has_riferimenti"));
        documentDestinationProperties.putValue("autore_str", documentSource.getProperties().getStringValue("autore_str"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQContracts(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("bu_societa", documentSource.getProperties().getStringValue("bu_societa"));
        documentDestinationProperties.putValue("buyer", documentSource.getProperties().getStringValue("buyer"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("codice_negoziazione"));
        documentDestinationProperties.putValue("data_emissione", documentSource.getProperties().getDateTimeValue("data_emissione"));
        documentDestinationProperties.putValue("ente_emittente", documentSource.getProperties().getInteger32Value("ente_emittente"));
        documentDestinationProperties.putValue("ragione_sociale", documentSource.getProperties().getStringValue("ragione_sociale"));
        documentDestinationProperties.putValue("gruppi_merci", documentSource.getProperties().getStringValue("gruppi_merci"));
        documentDestinationProperties.putValue("importo", documentSource.getProperties().getStringValue("importo"));
        documentDestinationProperties.putValue("bo_id", documentSource.getProperties().getStringValue("bo_id"));
        documentDestinationProperties.putValue("fornitore", documentSource.getProperties().getInteger32Value("fornitore"));
        documentDestinationProperties.putValue("tipo_negoz", documentSource.getProperties().getInteger32Value("tipo_negoz"));
        documentDestinationProperties.putValue("data_in_val", documentSource.getProperties().getDateTimeValue("data_in_val"));
        documentDestinationProperties.putValue("data_fin_val", documentSource.getProperties().getDateTimeValue("data_fin_val"));
        documentDestinationProperties.putValue("bo_bu_chronid_ref", documentSource.getProperties().getStringValue("bo_bu_chronid_ref"));
        documentDestinationProperties.putValue("data_scadenza_contratto", documentSource.getProperties().getDateTimeValue("data_scadenza_contratto"));
        documentDestinationProperties.putValue("data_decorrenza", documentSource.getProperties().getDateTimeValue("data_decorrenza"));
        documentDestinationProperties.putValue("divisione", documentSource.getProperties().getStringValue("divisione"));
        documentDestinationProperties.putValue("fornitori", documentSource.getProperties().getInteger32Value("fornitori"));
        documentDestinationProperties.putValue("origine", documentSource.getProperties().getInteger32Value("origine"));
        documentDestinationProperties.putValue("sid", documentSource.getProperties().getStringValue("sid"));
        documentDestinationProperties.putValue("mandante", documentSource.getProperties().getStringValue("mandante"));
        documentDestinationProperties.putValue("codice_rda", documentSource.getProperties().getStringValue("codice_rda"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("bo_bu", documentSource.getProperties().getInteger32Value("bo_bu"));
        documentDestinationProperties.putValue("creation_date", documentSource.getProperties().getDateTimeValue("creation_date"));
        documentDestinationProperties.putValue("bo_ente", documentSource.getProperties().getInteger32Value("bo_ente"));
        documentDestinationProperties.putValue("flag_allegati", documentSource.getProperties().getInteger32Value("flag_allegati"));
        documentDestinationProperties.putValue("old_bo_bu", documentSource.getProperties().getInteger32Value("old_bo_bu"));
        documentDestinationProperties.putValue("gracq", documentSource.getProperties().getStringValue("gracq"));
        documentDestinationProperties.putValue("sigla", documentSource.getProperties().getStringValue("sigla"));
        documentDestinationProperties.putValue("category_manager", documentSource.getProperties().getStringValue("category_manager"));
        documentDestinationProperties.putValue("cancellato_str", documentSource.getProperties().getStringValue("cancellato_str"));
        documentDestinationProperties.putValue("flag_sincro", documentSource.getProperties().getStringValue("flag_sincro"));
        documentDestinationProperties.putValue("negoz_prov", documentSource.getProperties().getStringValue("negoz_prov"));
        documentDestinationProperties.putValue("documento_corr_mig", documentSource.getProperties().getStringValue("documento_corr_mig"));
        documentDestinationProperties.putValue("fornitori_chronid_ref", documentSource.getProperties().getStringValue("fornitori_chronid_ref"));
        documentDestinationProperties.putValue("ente_emittente_chronid_ref", documentSource.getProperties().getStringValue("ente_emittente_chronid_ref"));
        documentDestinationProperties.putValue("codice", documentSource.getProperties().getStringValue("codice"));
        documentDestinationProperties.putValue("has_riferimenti", documentSource.getProperties().getBooleanValue("has_riferimenti"));
        documentDestinationProperties.putValue("has_correlazioni", documentSource.getProperties().getBooleanValue("has_correlazioni"));
        documentDestinationProperties.putValue("nomina_trattamento_dati_personali", documentSource.getProperties().getStringValue("nomina_trattamento_dati_personali"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQNegotiationCodesMasterData(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("codice_negoziazione", documentSource.getProperties().getStringValue("codice_negoziazione"));
        documentDestinationProperties.putValue("tipo", documentSource.getProperties().getStringValue("tipo"));
        documentDestinationProperties.putValue("numero_oda_contratto", documentSource.getProperties().getStringValue("numero_oda_contratto"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQBUMasterData(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("description_full", documentSource.getProperties().getStringValue("description_full"));
        documentDestinationProperties.putValue("parent", documentSource.getProperties().getIdValue("parent"));
        documentDestinationProperties.putValue("val_name", documentSource.getProperties().getStringValue("val_name"));
        documentDestinationProperties.putValue("enabled", documentSource.getProperties().getBooleanValue("enabled"));
        documentDestinationProperties.putValue("is_emittente", documentSource.getProperties().getBooleanValue("is_emittente"));
        documentDestinationProperties.putValue("is_azienda", documentSource.getProperties().getBooleanValue("is_azienda"));
        documentDestinationProperties.putValue("is_waq", documentSource.getProperties().getBooleanValue("is_waq"));
        documentDestinationProperties.putValue("flag_seleziona", documentSource.getProperties().getBooleanValue("flag_seleziona"));
        documentDestinationProperties.putValue("nome_sb", documentSource.getProperties().getStringValue("nome_sb"));
        documentDestinationProperties.putValue("is_qualita", documentSource.getProperties().getBooleanValue("is_qualita"));
        documentDestinationProperties.putValue("nome_gruppo", documentSource.getProperties().getStringValue("nome_gruppo"));
        documentDestination.save(RefreshMode.REFRESH);
    }

    public static void saveACQAcceptanceODA(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("tipo_accettazione", documentSource.getProperties().getStringValue("tipo_accettazione"));
        documentDestinationProperties.putValue("data_ora_presa_in_carico", documentSource.getProperties().getDateTimeValue("data_ora_presa_in_carico"));
        documentDestinationProperties.putValue("accettazione_cg", documentSource.getProperties().getStringValue("accettazione_cg"));
        documentDestinationProperties.putValue("nominativo_accettazione", documentSource.getProperties().getStringValue("nominativo_accettazione"));
        documentDestinationProperties.putValue("data_ora_accettazione", documentSource.getProperties().getDateTimeValue("data_ora_accettazione"));
        documentDestinationProperties.putValue("accettazione_cv", documentSource.getProperties().getStringValue("accettazione_cv"));
        documentDestinationProperties.putValue("data_staging", documentSource.getProperties().getDateTimeValue("data_staging"));
        documentDestinationProperties.putValue("enabled", documentSource.getProperties().getBooleanValue("enabled"));
        documentDestinationProperties.putValue("data_elaborazione", documentSource.getProperties().getDateTimeValue("data_elaborazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQContractAcceptance(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("system_id", documentSource.getProperties().getInteger32Value("system_id"));
        documentDestinationProperties.putValue("numero_documento", documentSource.getProperties().getStringValue("numero_documento"));
        documentDestinationProperties.putValue("stato_conferma", documentSource.getProperties().getStringValue("stato_conferma"));
        documentDestinationProperties.putValue("data_ora_conferma", documentSource.getProperties().getDateTimeValue("data_ora_conferma"));
        documentDestinationProperties.putValue("cognome", documentSource.getProperties().getStringValue("cognome"));
        documentDestinationProperties.putValue("nome", documentSource.getProperties().getStringValue("nome"));
        documentDestinationProperties.putValue("utenza", documentSource.getProperties().getStringValue("utenza"));
        documentDestinationProperties.putValue("nome_file", documentSource.getProperties().getStringValue("nome_file"));
        documentDestinationProperties.putValue("guid_testo_srm", documentSource.getProperties().getStringValue("guid_testo_srm"));
        documentDestinationProperties.putValue("data_testo_srm", documentSource.getProperties().getDateTimeValue("data_testo_srm"));
        documentDestinationProperties.putValue("data_elaborazione", documentSource.getProperties().getDateTimeValue("data_elaborazione"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQJobRequest(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("argument_keys", documentSource.getProperties().getStringValue("argument_keys"));
        documentDestinationProperties.putValue("argument_values", documentSource.getProperties().getStringValue("argument_values"));
        documentDestinationProperties.putValue("status", documentSource.getProperties().getInteger32Value("status"));
        documentDestinationProperties.putValue("job_name", documentSource.getProperties().getStringValue("job_name"));
        documentDestinationProperties.putValue("data_inizio_esecuzione", documentSource.getProperties().getDateTimeValue("data_inizio_esecuzione"));
        documentDestinationProperties.putValue("data_fine_esecuzione", documentSource.getProperties().getDateTimeValue("data_fine_esecuzione"));
        documentDestinationProperties.putValue("request_completed", documentSource.getProperties().getBooleanValue("request_completed"));
        documentDestinationProperties.putValue("elapsed_time", documentSource.getProperties().getInteger32Value("elapsed_time"));
        documentDestinationProperties.putValue("execution_server", documentSource.getProperties().getStringValue("execution_server"));
        documentDestinationProperties.putValue("result", documentSource.getProperties().getInteger32Value("result"));
        documentDestinationProperties.putValue("user_id", documentSource.getProperties().getStringValue("user_id"));
        documentDestinationProperties.putValue("mail_recipient", documentSource.getProperties().getStringValue("mail_recipient"));
        documentDestinationProperties.putValue("report_type", documentSource.getProperties().getStringValue("report_type"));
        documentDestinationProperties.putValue("note", documentSource.getProperties().getStringValue("note"));
        documentDestinationProperties.putValue("selected_columns", documentSource.getProperties().getStringValue("selected_columns"));
        documentDestinationProperties.putValue("argument_values_big", documentSource.getProperties().getStringValue("argument_values_big"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }

    public static void saveACQJobReport(Document documentDestination, Document documentSource) {
        documentDestinationProperties.putValue("DocumentTitle", documentSource.getProperties().getStringValue("DocumentTitle"));
        documentDestinationProperties.putValue("data_inizio_esecuzione", documentSource.getProperties().getDateTimeValue("data_inizio_esecuzione"));
        documentDestinationProperties.putValue("data_fine_esecuzione", documentSource.getProperties().getDateTimeValue("data_fine_esecuzione"));
        documentDestinationProperties.putValue("has_error", documentSource.getProperties().getStringValue("has_error"));
        documentDestinationProperties.putValue("mail_sent", documentSource.getProperties().getBooleanValue("mail_sent"));
        documentDestinationProperties.putValue("mail_recipient", documentSource.getProperties().getStringValue("mail_recipient"));
        documentDestinationProperties.putValue("item_read", documentSource.getProperties().getInteger32Value("item_read"));
        documentDestinationProperties.putValue("item_updated", documentSource.getProperties().getInteger32Value("item_updated"));
        documentDestinationProperties.putValue("item_skipped", documentSource.getProperties().getInteger32Value("item_skipped"));
        documentDestinationProperties.putValue("item_inserted", documentSource.getProperties().getInteger32Value("item_inserted"));
        documentDestinationProperties.putValue("report_type", documentSource.getProperties().getStringValue("report_type"));
        documentDestination.save(RefreshMode.REFRESH);
        logger.info("Object successfully inserted!");
    }
}
