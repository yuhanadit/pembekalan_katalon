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

WebUI.callTestCase(findTestCase('Login/TC Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Product Page/button_atc_product_1'))

WebUI.click(findTestObject('Product Page/button_atc_product_2'))

name = WebUI.getText(findTestObject('Product Page/name_product_1'))

price = WebUI.getText(findTestObject('Product Page/price_product_1'))

desc = WebUI.getText(findTestObject('Object Repository/Product Page/desc_product_1'))

name2 = WebUI.getText(findTestObject('Product Page/name_product_2'))

price2 = WebUI.getText(findTestObject('Product Page/price_product_2'))

desc2 = WebUI.getText(findTestObject('Object Repository/Product Page/desc_product_2'))

WebUI.click(findTestObject('Product Page/icon_cart'))

WebUI.click(findTestObject('Cart Page/button_cart_checkout'))

HashMap<String, Object> data = new HashMap<String,Object>() //deklarasi hashmap kosong
data.put("product_name", name)
data.put("product_price", price)
data.put("product_desc", desc)

data.put("product_name2", name2)
data.put("product_price2", price2)
data.put("product_desc2", desc2)

return data




