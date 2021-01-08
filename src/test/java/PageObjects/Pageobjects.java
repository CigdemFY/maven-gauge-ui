package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pageobjects {
    @FindBy(css = "a[title='Close']")
    public WebElement popup_close_button;

    @FindBy(css = ".account-user")
    public WebElement girisyap_icon;

    @FindBy(css="div.login-button")
    public WebElement girisyap_button;

    @FindBy(css = "input#login-email")
    public  WebElement login_email_textbox;

    @FindBy(css = "input#login-password-input")
    public WebElement login_password_textbox;

    @FindBy(css = "button.submit")
    public WebElement login_button;

    @FindBy(css = "div.modal-close")
    public WebElement after_login_popup;

    @FindBy(css = "div.account-user p.link-text")
    public WebElement hesabim;

    @FindBy(css = "a[href='/butik/liste/kadin']")
    public WebElement kadın_Tab;

    @FindBy(css = "a[href='/butik/liste/erkek']")
    public WebElement erkek_Tab;

    @FindBy(css = "a[href='/butik/liste/cocuk']")
    public WebElement cocuk_Tab;

    @FindBy(css = "a[href='/butik/liste/ev--yasam']")
    public WebElement evyasam_Tab;

    @FindBy(css = "a[href='/butik/liste/supermarket']")
    public WebElement supermarket_Tab;

    @FindBy(css = "a[href='/butik/liste/kozmetik']")
    public WebElement kozmetik_Tab;

    @FindBy(css = "a[href='/butik/liste/ayakkabi--canta']")
    public WebElement ayakkabicanta_Tab;

    @FindBy(css = "a[href='/butik/liste/saat--aksesuar']")
    public WebElement saataksesuar_Tab;

    @FindBy(css = "a[href='/butik/liste/elektronik']")
    public WebElement elektronik_Tab;

    @FindBy(css = "li.active a.category-header")
    public WebElement active_Tab;

    @FindBy(css = "a.sub-category-header:contains('Elbise')")
    public WebElement elbise;

    @FindBy(xpath = "(//ul[@class='sub-item-list']/li/a[contains(text(),'Elbise')])[1]")
    public WebElement elbise2;

    @FindBy(css = "div.p-card-wrppr:first-child")
    public WebElement ilk_urun;

    @FindBy(css = "button.add-to-bs")
    public WebElement addtocart_button;

    @FindBy(css = "a.account-basket")
    public WebElement sepetim_icon;

    @FindBy(css = "ul.basketProductList a")
    public WebElement cart_product_url;

    @FindBy(css = "div.chckd")
    public WebElement search_categ_text;










































}
