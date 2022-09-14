var req = `<?xml version="1.0" encoding="utf-8"?>

<soapenv:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:iplanprime="https://iplanprime.eventready.com">

<soapenv:Header/>

<soapenv:Body>

<iplanprime:getAttendees soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">

<key xsi:type="xsd:string">FB2E1B876F9EC303179F37BFEB2C56E4</key>

<event_id xsi:type="xsd:string">847</event_id>
<reg_id>0</reg_id>

</iplanprime:getAttendees>

</soapenv:Body>

</soapenv:Envelope>`