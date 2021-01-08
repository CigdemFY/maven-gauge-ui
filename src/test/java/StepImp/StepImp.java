package StepImp;

import PageObjects.Pageobjects;
import baseUtil.baseUtils;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StepImp extends baseUtils {
    public Pageobjects pageobjects;

    public StepImp(){
        super();
        pageobjects = PageFactory.initElements(this.driver, Pageobjects.class);
    }

    @Step("Girişteki popup kapatılır")
    public void closeFirstPopup(){
        clickElement(pageobjects.popup_close_button);

    }

    @Step("Giriş yap iconun üzerine gelinir")
    public void hooverIcon(){
        hoverElement(pageobjects.girisyap_icon);
    }

    @Step("Giriş yap butona tıklanır")
    public void clickLogin(){
        clickElement(pageobjects.girisyap_button);
    }

    @Step("Eposta girişi <eposta> yapılır")
    public void enterMail(String eposta){
        sendText(eposta,pageobjects.login_email_textbox);
    }

    @Step("Password girişi <password> yapılır")
    public void enterPassword(String password){
        sendText(password,pageobjects.login_password_textbox);
    }

    @Step("Login butonuna basılır")
    public void clickloginButton(){ clickElement(pageobjects.login_button);}

    @Step("Login sonrası çıkan popup kapatılır")
    public void closepopup(){
        clickElement(pageobjects.after_login_popup);
    }

    @Step("Anasayfa login kontrol edilir")
    public void checkIflogin(){
        isElementVisible(pageobjects.hesabim); }

    @Step("Kadın tabına tıklanır")
    public void clickwomanTab(){
        clickElement(pageobjects.kadın_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"KADIN");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Erkek tabına tıklanır")
    public void clickmanTab(){
        clickElement(pageobjects.erkek_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"ERKEK");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Çocuk tabına tıklanır")
    public void clickchildTab(){
        clickElement(pageobjects.cocuk_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"ÇOCUK");
    }

    @Step("Ev&Yaşam tabına tıklanır")
    public void clickhomehealthTab(){
        clickElement(pageobjects.evyasam_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"EV & YAŞAM");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Supermarket tabına tıklanır")
    public void clicksupermarketTab(){
        clickElement(pageobjects.supermarket_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"SÜPERMARKET");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Kozmetik tabına tıklanır")
    public void clickcostemeticsTab(){ clickElement(pageobjects.kozmetik_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"KOZMETİK");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Ayakkabı&Çanta tabına tıklanır")
    public void clickshoebagTab(){
        clickElement(pageobjects.ayakkabicanta_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"AYAKKABI & ÇANTA");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Saat&Aksesuar tabına tıklanır")
    public void clickwatchaccsTab(){
        clickElement(pageobjects.saataksesuar_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"SAAT & AKSESUAR");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("Elektronik tabına tıklanır")
    public void clickelectronicsTab(){
        clickElement(pageobjects.elektronik_Tab);
        Assert.assertEquals(getText(pageobjects.active_Tab),"ELEKTRONİK");
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("<seconds> saniye bekle")
    public void waitSeconds(long seconds) throws InterruptedException {
        waitBySeconds(seconds);
    }

    @Step("Kadın tabının üzerine gelinir")
    public void hooverWomanTab() {
        hoverElement(pageobjects.kadın_Tab);
    }

    @Step("Giyim altında elbise modülüne tıklanır")
    public void clickForDresses() {
        clickElement(pageobjects.elbise2);
        checkBrokenImgs(); //http ile kontrol
        //checkBrokenImgTab4(); //naturalwidth kontrol
    }

    @Step("İlk ürüne tıklanır")
    public void clickFirst() {
        clickElement(pageobjects.ilk_urun);
    }

    @Step("Sepete ekle butonuna tıklanır")
    public void clickAddCart() throws InterruptedException {
        clickElement(pageobjects.addtocart_button);
    }






























































































}
