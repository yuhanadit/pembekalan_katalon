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

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('Test Cases/Checkout Multiple Products (Dynamic)/TC Checkout Step 1, Dynamic Product'), [:], FailureHandling.STOP_ON_FAILURE)

List<String> inputName = data.get("product_name")
List<String> inputPrice = data.get("product_price")
List<String> inputDesc = data.get("product_desc")

List<WebElement> nameElements = WebUI.findWebElements(findTestObject('Object Repository/Checkout Page/name_checkout_list'), 0)
List<WebElement> priceElements = WebUI.findWebElements(findTestObject('Object Repository/Checkout Page/price_checkout_list'), 0)
List<WebElement> descElements = WebUI.findWebElements(findTestObject('Object Repository/Checkout Page/desc_checkout_list'), 0)

List<String> actualName = new ArrayList()
List<String> actualPrice = new ArrayList()
List<String> actualDesc = new ArrayList()

def expectedPrice = 0
for(int i = 0; i < nameElements.size(); i++) {
	actualName.add(nameElements.get(i).text)
	actualPrice.add(priceElements.get(i).text)
	actualDesc.add(descElements.get(i).text)
	
	def price = priceElements.get(i).text.toString().substring(1).trim().toDouble()
	expectedPrice += price
}

//verifikasi barang yang dicheckout sama dengan yang dipilih
assert inputName == actualName
assert inputPrice == actualPrice
assert inputDesc == actualDesc

def actualItemPrice = WebUI.getText(findTestObject('Object Repository/Checkout Page/item_total'))
actualItemPrice = actualItemPrice.toString().replace("Item total: \$","").trim().toDouble()
println actualItemPrice

//verifikasi harga input sesuai dengan actual di halaman checkout
assert expectedPrice == actualItemPrice

def tax = WebUI.getText(findTestObject('Object Repository/Checkout Page/tax'))
tax = tax.toString().replace("Tax: \$","").trim().toDouble()
println tax

def actualTotalPrice = WebUI.getText(findTestObject('Object Repository/Checkout Page/total'))
actualTotalPrice = actualTotalPrice.toString().replace("Total: \$","").trim().toDouble()
println actualTotalPrice

//verifikasi perhitungan total price sama dengan harga item + price
assert actualTotalPrice == actualItemPrice + tax

WebUI.click(findTestObject('Object Repository/Checkout Page/button_Finish_checkout2'))

WebUI.closeBrowser()
