package walmartTest;

public class Constant {
	/*Account info*/
	public final static String SIGN_IN_USERNAME = "nali.nyupoly@gmail.com";
	public final static String SIGN_IN_PASSWORD = "lina19880809";
	
	/*Driver location*/
//	public final static String DRIVER_LOCATION = "chromeDrive/chromedriver.exe";//for Windows
	public final static String DRIVER_LOCATION = "chromeDrive/chromedriver";//for Mac
	
	public final static String HOMEPAGE = "http://www.walmart.com";
	
	/*Sign in*/ 
	public final static String SIGN_IN_NAV = "//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[1]/div[1]/p/span[2]/a";
	public final static String USERNAME_TEXT = "//*[@id='login-username']";
	public final static String PASSWORD_TEXT = "//*[@id='login-password']";
	public final static String SIGN_IN_BTN = "/html/body/div[2]/section/section[4]/div/div/div/div/div/div/div/form/div/button";
	
	/*Search*/
	public final static String WELCOME_ACCOUNT_TEXT = "/html/body/div[2]/section/section[4]/div/div/div/div/div[2]/div/h1";
	public final static String SEARCH_TEXT = "id('top')/div[3]/div/div/div/div/div[3]/form/div/div[2]/span/input";
	public final static String SEARCH_BTN = "id('top')/div[3]/div/div/div/div/div[3]/form/div/div[3]/button";
	
	/*Select one item*/
	public final static String REDIRECT_URL = "//div[2]/section/section[4]/div/div/div[3]/div[1]/div[1]/a";
	//public final static String LIST_CONTAINER = "//*[@id='tile-container']/div[1]/div/div/h4/a";
	public final static String GRID_CONTAINER = "//*[@id='tile-container']/ul/li[1]/div/a[1]";
	public final static String SELECT_COLOR = "//*[@id='tile-container']/div[1]/div/div/div[1]/div[4]";
	
	/*Save item info*/
	public final static String REVEIEWS_INFO = "//div[@class='js-reviews see-all-reviews']";
	public final static String PRODUCT_ID = "data-product-id";
	
	/*Add to cart*/
	public final static String ADD_TO_CART_BTN = "//*[@id='WMItemAddToCartBtn']";
	
	/*View cart*/
	public final static String VIEW_CART_BTN = "//*[@id='PACViewCartBtn']";
	
	/*Validate item*/
	public final static String CART_ITEM_LIST = "//*[@id='spa-layout']/div/div/div[1]/div/div[4]/div[2]/div";
	
	/*Remove item*/
	public final static String REMOVE_BTN = "//*[@id='CartRemItemBtn']";
	
	/*Log out*/
	public final static String SIGN_OUT = "https://www.walmart.com/account/logout";
}