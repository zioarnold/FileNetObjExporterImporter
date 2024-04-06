import r2u.tools.utils.JSONParser;

/**
 * Se vogliate finire la giornata di lavoro sani, chiudete subito sto codice.
 * Diversamente, benvenuti nell'incubo! Si raccomanda di lavorare con sale e pepe nel sedere.
 * Questa versione dell'incubo 1 attualmente necessita di 6 parametri configurabili su JSON
 * MTOM dell'origine e del suo nome objectStore
 * MTOM della Destinazione e del suo nome objectStore
 * Utente e Password
 * Classi documentali (Document e CustomObject)
 */
public class Main {
    public static void main(String[] args) {
        String jsonPath = args[0];
        JSONParser jsonParser = new JSONParser();
        jsonParser.parseJson(jsonPath);
    }
}