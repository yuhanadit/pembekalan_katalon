<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET USER BY ID</name>
   <tag></tag>
   <elementGuidId>0d8d9704-2748-418b-ade1-8552f8eba0d5</elementGuidId>
   <selectorMethod>XPATH</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>9.3.1</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.base_url}/api/users/${id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>115</defaultValue>
      <description></description>
      <id>be6d377f-e3de-42ae-867c-30a0b61cd235</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>1aaed64e-e476-4678-8b0e-609bb28ee8f9</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7f58775e-ff42-4d3e-8c32-ce55fc71ba93</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>'0\r\n'</defaultValue>
      <description></description>
      <id>af8ac8d7-a29f-4ce7-bfcd-b46da6b015f9</id>
      <masked>false</masked>
      <name>age</name>
   </variables>
   <variables>
      <defaultValue>'UNKNOWN'</defaultValue>
      <description></description>
      <id>084301d9-26ae-4ce3-bc33-56f9e63bb38f</id>
      <masked>false</masked>
      <name>gender</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

def variables = request.getVariables()
def id = variables.get('id')
def username = variables.get('username')
def password = variables.get('password')
def age = variables.get('age')
def gender = variables.get('gender')

if(username != &quot;&quot;) {
	WS.verifyElementPropertyValue(response, &quot;age&quot;, age)
	WS.verifyElementPropertyValue(response, &quot;id&quot;, id)
	WS.verifyElementPropertyValue(response, &quot;username&quot;, username)
	WS.verifyElementPropertyValue(response, &quot;password&quot;, password)
	WS.verifyElementPropertyValue(response, &quot;gender&quot;, gender)
}




</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
