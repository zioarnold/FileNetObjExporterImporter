# FileNetObjExporterImporter by MrArni_ZIO
### Description
Tool per export ed import delle classi documentali fra gli ambienti,
sviluppato per necessita di rimettere in piedi lo sviluppo.
Attualmente bisogna passarli un file json strutturato in questo modo:<br>
`{
"sourceCPE": "http://xxx:000/wsi/FNCEWS40MTOM/",
"sourceCPEObjectStore": "xxx",
"destinationCPE": "http://yyy:000/wsi/FNCEWS40MTOM/",
"destinationCPEObjectStore": "yyy",
"sourceCPEUsername": "xxx",
"sourceCPEPassword": "xxx",
"destinationCPEUsername": "yyy",
"destinationCPEPassword": "yyy",
"documentClass": "Document,CustomObject",
"objectClasses": [
{
"CustomObject": [
"customobject=true"
],
"Document": [
"document=true"]}]}`
<br>
Se si vuole disabilitare una classe documentale dal censimento, basta scegliere quella classe ed impostarla a false.
### Usage
`java -jar config.json`.<br>
Per qualsiasi bug, feature request - non esitate a chiamarmi, messagarmi.
