////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var request;
export const base_url = "https://iplanprime.eventready.com"


export const getData = (endpoint, data) => {
  let reqParams = getBodyParams(data)
  let requestString = makeFinalRequestString(base_url, endpoint, reqParams)
  console.log("XML_REQUEST", requestString)
  request.send(requestString);

  request.onload = function () {
    parseXML(endpoint, this.responseText)
  };
}

const parseXML = (endpoint, response) => {
  var parseString = require('react-native-xml2js').parseString;
  console.log("XML_RESPONSE", response);
  parseString(response, function (err, result) {
    console.log("RESPONSE", result);
    var error = result["soapenv:Envelope"]["soapenv:Body"][0]["soapenv:Fault"];
    if (error != undefined) {
      let errResponse = {
        code: error[0]["faultcode"][0],
        message: error[0]["faultstring"][0]
      }
      console.log(errResponse);
      return errResponse
    } else {
      let res = JSON.parse(result["soapenv:Envelope"]["soapenv:Body"][0][`ns1:${endpoint}Response`][0][`${endpoint}Return`][0]["_"])
      console.log("result", res);
    }

  });
}

export const makeFinalRequestString = (base_url, endpoint, data, key = "FB2E1B876F9EC303179F37BFEB2C56E4") => {
  reqString = `<?xml version="1.0" encoding="utf-8"?>
    <soapenv:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:iplanprime="${base_url}">
    <soapenv:Header/>
      <soapenv:Body>
        <iplanprime:${endpoint} soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">
        <key xsi:type="xsd:string">${key}</key>
        ${data}
        </iplanprime:${endpoint}>
    </soapenv:Body>
    </soapenv:Envelope>`

  return reqString
}

const getBodyParams = (data) => {
  let entries = Object.entries(data)
  let reqParams = ``
  entries.forEach((entry) => {
    reqParams += `<${entry[0]}>${entry[1]}</${entry[0]}>`
  })
  return reqParams;

}

const initXHRRequest = () => {
  request = new XMLHttpRequest();
  request.open('POST', 'https://ws.eventready.com/com/iplanprime/obap_api.cfc');
  //Setting Headers
  request.setRequestHeader("SOAPAction", "")
  request.setRequestHeader('Access-Control-Allow-Origin', '*');
  request.setRequestHeader('Content-Type', 'text/xml;; charset="utf-8"');
  request.setRequestHeader('Accept', 'application/xml')
}



initXHRRequest()
var data = {
  event_id: 847,
  reg_id: 0
}
