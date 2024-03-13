package r2u.tools.custom;

import com.filenet.api.collection.RepositoryRowSet;
import com.filenet.api.core.CustomObject;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Properties;
import com.filenet.api.query.RepositoryRow;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;

import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
public class FNCustomObject {
    public void processCustomObjects(String docClass,
                                     ObjectStore objectStoreSource,
                                     ObjectStore objectStoreDestination,
                                     HashMap<String, Boolean> customObjectMap) {
        if (docClass.equalsIgnoreCase("CustomObject")) {
            Iterator iterator = fetchRows(docClass, objectStoreSource);
            //Scorreggio ogni record presente nella Generic
            while (iterator.hasNext()) {
                RepositoryRow repositoryRow = (RepositoryRow) iterator.next();
                try {
                    Properties properties = repositoryRow.getProperties();
                    //Estraggo l'ID
                    String id = properties.getIdValue("ID").toString();
                    CustomObject documentSource = Factory.CustomObject.fetchInstance(objectStoreSource, id, null);
                    CustomObject documentDestination = Factory.CustomObject.createInstance(objectStoreDestination, documentSource.getClassName());
                    System.out.println("Found: " + id + " className:" + documentSource.getClassName());
                    switch (documentSource.getClassName()) {
                        case "acq_codici_dossier":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                dossierCodes(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_codici_uda":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                udaCodes(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_allegati_counter":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqAttachmentsCounterReport(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_lookup":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqLookup(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_relation":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqRelationships(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_report_errori_pec":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqPECErrorReports(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_configuration":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqConfigurations(documentSource, documentDestination, id);
                            }
                            break;
                        case "acq_security_proxy":
                            if (customObjectMap.get(documentSource.getClassName())) {
                                System.out.println("Working on: " + id + " className:" + documentSource.getClassName());
                                acqSecurityProxy(documentSource, documentDestination, id);
                            }
                            break;
                    }
                    //(c) Zio Arnold aka MrArni_ZIO, seguitemi su Twitch, Trovo e YouTube :-D
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private static Iterator fetchRows(String docClass, ObjectStore objectStoreSource) {
        String querySource = "SELECT * FROM " + docClass;
        SearchSQL searchSQL = new SearchSQL();
        searchSQL.setQueryString(querySource);
        SearchScope searchScope = new SearchScope(objectStoreSource);
        RepositoryRowSet rowSet = searchScope.fetchRows(searchSQL, null, null, Boolean.TRUE);
        return rowSet.iterator();
    }

    private void acqSecurityProxy(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQSecurityProxy(documentDestination, documentSource);
    }

    private void acqConfigurations(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQConfiguration(documentDestination, documentSource);
    }

    private void acqPECErrorReports(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQPECErrorReports(documentSource, documentDestination);
    }

    private void acqRelationships(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQRelationships(documentDestination, documentSource);
    }

    private void acqLookup(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQLookup(documentDestination, documentSource);
    }

    private void acqAttachmentsCounterReport(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveACQAttachmentsCounterReport(documentDestination, documentSource);
    }

    private void udaCodes(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveUDACodes(documentDestination, documentSource);
    }

    private void dossierCodes(CustomObject documentSource, CustomObject documentDestination, String id) {
        System.out.println("For: " + documentSource.getClassName() + " id: " + id + " inserting properties");
        FNCustomObjects.saveDossierCodes(documentDestination, documentSource);
    }
}
