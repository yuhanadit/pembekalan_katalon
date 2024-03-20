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

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('Test Cases/Checkout 2 Products (Statis)/TC Checkout Step 1, 2 Product'), [:], FailureHandling.STOP_ON_FAILURE)

def inputName = data.get("product_name")
def inputPrice = data.get("product_price")
def inputDesc = data.get("product_desc")

def inputName2 = data.get("product_name2")
def inputPrice2 = data.get("product_price2")
def inputDesc2 = data.get("product_desc2")

//verifikasi barang yang dicheckout sama dengan yang dipilih
WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/name_checkout_product_1'), inputName)
WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/price_checkout_product_1'), inputPrice)
WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/desc_checkout_product_1'), inputDesc)

WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/name_checkout_product_2'), inputName2)
WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/price_checkout_product_2'), inputPrice2)
WebUI.verifyElementText(findTestObject('Object Repository/Checkout Page/desc_checkout_product_2'), inputDesc2)

inputPrice = inputPrice.toString().substring(1).trim().toDouble()
println inputPrice
inputPrice2 = inputPrice.toString().substring(1).trim().toDouble()
println inputPrice2
def expectedPrice = inputPrice + inputPrice2

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

WebUI.closeBrowser()
