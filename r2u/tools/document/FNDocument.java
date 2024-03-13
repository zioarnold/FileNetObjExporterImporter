package r2u.tools.document;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.collection.RepositoryRowSet;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Properties;
import com.filenet.api.query.RepositoryRow;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;

import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
public class FNDocument {

    public void processDocumentClasses(String docClass,
                                       ObjectStore objectStoreSource,
                                       ObjectStore objectStoreDestination,
                                       HashMap<String, Boolean> documentClassMap) {
        Iterator<?> iterator = fetchRows(docClass, objectStoreSource);
        //Scorreggio ogni record presente nella DOCVERSION
        while (iterator.hasNext()) {
            RepositoryRow repositoryRow = (RepositoryRow) iterator.next();
            try {
                Properties properties = repositoryRow.getProperties();
                //Estraggo l'ID
                String id = properties.getIdValue("ID").toString();
                Document documentSource = Factory.Document.fetchInstance(objectStoreSource, id, null);
                Document documentDestination = Factory.Document.createInstance(objectStoreDestination, documentSource.getClassName());
                System.out.println("Found: " + id + " className:" + documentSource.getClassName());
                //Qui il bello, al documento ottenuto, verifico a quale classe documentale esso appartiene.
                //Esempio acq_job_report, se tale documento e` presente nella classe documentale in origine (source)
                //Allora estraggo i file fisici presenti e le properties dopodiche`
                //Lo butto nella destinazione popolando i rispettivi properties (metadati).
                //Se tale oggetto non ha i file... allora lo censisco comunque e popolo i metadati.

                //Qualora per necessita si ha voglia di importare gli allegati tipo: acq_all_oda
                //allora bisogna gestire aggiungendo un case "acq_all_oda" : blah-blah break;
                //E fare il resto come dio comanda (cioe` come son gestiti gli altri) popolando i metadati (properties) necessari.
                switch (documentSource.getClassName()) {
                    case "acq_job_report":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqJobReport(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_job_request":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqJobRequest(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_accettazione_contratti":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqContractAcceptance(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_accettazione_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAcceptanceODA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_anagrafica_bu":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqBUMasterData(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_anagrafica_codici_negoziazione":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqNegotiationCodesMasterData(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_contratto":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqContracts(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_allegato":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachments(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_anagrafica_fornitori":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqSuppliersMasterData(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_anagrafica_gruppo_merci":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqGoodGroupRegistry(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqODA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_pon":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqPON(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_pos":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqPOS(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_rda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqRDA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_rdo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqRDO(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_sc_archiviazione_accordo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqSCArchiveAgreement(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_sc_archiviazione_contratto":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqSCArchiveContracts(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_sc_archiviazione_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqSCArchiveODA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_accordo_quadro_normativo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAgreements(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_doc_contratto":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToDocumentsOfContracts(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_doc_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToODADocuments(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_doc_rda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToRDADocuments(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_doc_rdo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToRDODocuments(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_accordo_quadro_normativo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToAgreements(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_contratto":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToContracts(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_doc_vario_fornitori":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToDocumentSuppliers(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToODA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_pon":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToPON(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_rda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToRDA(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_all_rdo":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqAttachmentsToRDO(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_doc_vari_fornitori":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqDocumentsToSuppliers(documentSource, documentDestination, id);
                        }
                        break;
                    case "acq_stampa_oda":
                        if (documentClassMap.get(documentSource.getClassName())) {
                            System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                            acqODAPrints(documentSource, documentDestination, id);
                        }
                        break;
                }
                //(c) Zio Arnold aka MrArni_ZIO, seguitemi su Twitch, Trovo e YouTube :-D
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


    private static Iterator<?> fetchRows(String docClass, ObjectStore objectStoreSource) {
        String querySource = "SELECT * FROM " + docClass;
        SearchSQL searchSQL = new SearchSQL();
        searchSQL.setQueryString(querySource);
        SearchScope searchScope = new SearchScope(objectStoreSource);
        RepositoryRowSet rowSet = searchScope.fetchRows(searchSQL, null, null, Boolean.TRUE);
        return rowSet.iterator();
    }

    private void acqAgreements(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAgreementsProperties(documentDestination, documentSource);
    }

    private void acqAttachmentsToDocumentsOfContracts(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToDocumentOfContracts(documentDestination, documentSource);
    }

    private void acqAttachmentsToODADocuments(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToODADocuments(documentDestination, documentSource);
    }

    private void acqAttachmentsToRDADocuments(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToRDADocuments(documentDestination, documentSource);
    }

    private void acqAttachmentsToRDODocuments(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToRDODocuments(documentDestination, documentSource);
    }

    private void acqAttachmentsToAgreements(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToAgreements(documentDestination, documentSource);
    }

    private void acqAttachmentsToContracts(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToContracts(documentDestination, documentSource);
    }

    private void acqAttachmentsToDocumentSuppliers(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToDocumentSuppliers(documentDestination, documentSource);
    }

    private void acqAttachmentsToODA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToODA(documentDestination, documentSource);
    }

    private void acqAttachmentsToPON(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        documentDestination.save(RefreshMode.REFRESH);
        System.out.println("Object successfully inserted!");
    }

    private void acqAttachmentsToRDA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToRDA(documentDestination, documentSource);
    }

    public void acqAttachmentsToRDO(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachmentsToRDO(documentDestination, documentSource);
    }

    public void acqDocumentsToSuppliers(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQDocumentsToSuppliers(documentDestination, documentSource);
    }

    public void acqODAPrints(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQODAPrints(documentDestination, documentSource);
    }

    private void acqSCArchiveODA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQSCArchiveODA(documentDestination, documentSource);
    }

    private void acqSCArchiveContracts(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQSCArchiveContracts(documentDestination, documentSource);
    }

    private void acqSCArchiveAgreement(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQSCArchiveAgreement(documentDestination, documentSource);
    }

    private void acqRDO(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQRDO(documentDestination, documentSource);
    }

    private void acqRDA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQRDA(documentDestination, documentSource);
    }

    private void acqPOS(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQPOS(documentDestination, documentSource);
    }

    private void acqPON(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQPON(documentDestination, documentSource);
    }

    private void acqODA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQODA(documentDestination, documentSource);
    }

    private void acqGoodGroupRegistry(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQGoodGroupRegistry(documentDestination, documentSource);
    }

    private void acqSuppliersMasterData(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQSuppliersMasterData(documentDestination, documentSource);
    }

    private void acqAttachments(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAttachments(documentDestination, documentSource);
    }

    private void acqContracts(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQContracts(documentDestination, documentSource);
    }

    private void acqNegotiationCodesMasterData(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQNegotiationCodesMasterData(documentDestination, documentSource);
    }

    private void acqBUMasterData(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQBUMasterData(documentDestination, documentSource);
    }

    private void acqAcceptanceODA(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQAcceptanceODA(documentDestination, documentSource);
    }

    private void acqContractAcceptance(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQContractAcceptance(documentDestination, documentSource);
    }

    private void acqJobRequest(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQJobRequest(documentDestination, documentSource);
    }

    public void acqJobReport(Document documentSource, Document documentDestination, String id) {
        ContentElementList contentElementsSource = documentSource.get_ContentElements();
        for (Object o : contentElementsSource) { // inserisco ogni content element
            ContentTransfer contentTransferSource = (ContentTransfer) o;
            System.out.println("Content Element is present for: " + documentSource.getClassName() + " id: " + id + " inserting data");
            ContentTransfer contentTransferDestination = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementDestination = Factory.ContentTransfer.createList();
            contentTransferDestination.setCaptureSource(contentTransferSource.accessContentStream());
            contentTransferDestination.set_ContentType(contentTransferSource.get_ContentType());
            contentElementDestination.add(contentTransferDestination);
            documentDestination.set_MimeType(documentSource.get_MimeType());
            documentDestination.set_ContentElements(contentElementDestination);
        }
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNDocumentClass.saveACQJobReport(documentDestination, documentSource);
    }
}
