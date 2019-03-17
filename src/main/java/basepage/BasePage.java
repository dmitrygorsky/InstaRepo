package basepage;

import component.Footer;
import component.Header;

public class BasePage extends AbstractPage {

    public Header header;
    public Footer footer;

    public BasePage() {
        header = new Header();
        footer = new Footer();
    }

}
