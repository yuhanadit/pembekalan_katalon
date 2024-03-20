import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement 

WebUI.callTestCase(findTestCase('Login/TC Login'), [:], FailureHandling.STOP_ON_FAILURE)

String[] arrVariablePosition = product_position.toString().split(";")
String[] arrVariableName = product_name.toString().split(";")

List<String> arrName = new ArrayList()
List<String> arrPrice = new ArrayList()
List<String> arrDesc = new ArrayList()

List<WebElement> nameElements = WebUI.findWebElements(findTestObject('Object Repository/Product Page/product_list'), 0)
List<WebElement> priceElements = WebUI.findWebElements(findTestObject('Object Repository/Product Page/price_list'), 0)
List<WebElement> descElements = WebUI.findWebElements(findTestObject('Object Repository/Product Page/list_desc'), 0)
List<WebElement> atcElements = WebUI.findWebElements(findTestObject('Object Repository/Product Page/button_atc_list'), 0)

for(int i = 0; i < nameElements.size(); i++) {
	def nameText = nameElements.get(i).text
	def priceText = priceElements.get(i).text
	def descText = descElements.get(i).text
	
	if(add_product_by == "POSITION") {
		for(position in arrVariablePosition) {
			if(i + 1 == position.toInteger()) {
				atcElements.get(i).click()
				arrName.add(nameText)
				arrPrice.add(priceText)
				arrDesc.add(descText)
			}
		}
	} else if(add_product_by == "NAME") {
		for(productName in arrVariableName) {
			if(productName == nameText) {
				atcElements.get(i).click()
				arrName.add(nameText)
				arrPrice.add(priceText)
				arrDesc.add(descText)
			}
		}
	}
}

WebUI.click(findTestObject('Product Page/icon_cart'))

WebUI.click(findTestObject('Cart Page/button_cart_checkout'))

HashMap<String, Object> data = new HashMap<String,Object>() //deklarasi hashmap kosong
data.put("product_name", arrName)
data.put("product_price", arrPrice)
data.put("product_desc", arrDesc)

return data




