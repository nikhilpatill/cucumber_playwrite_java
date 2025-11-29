package org.ActionClassUtility;

import com.microsoft.playwright.*;

public class ActionClassGenericMethod {

    private Page page;

    public ActionClassGenericMethod(Page page) {
        this.page = page;
    }

    // ************** SEND KEYS **************
    public void sendKeysUsingElement(Locator locator, String value) {
        locator.fill("");          // Clear first (optional)
        //locator.type(value);
    }

    public void sendKeysClickAndType(Locator locator, String value) {
        locator.click();
        //locator.type(value);
    }


    // ************** MOUSE ACTIONS **************
    public void moveToElement(Locator locator) {
        locator.hover();
    }


    public void dragAndDrop(Locator source, Locator target) {
        source.dragTo(target);
    }

   


    // ************** SCROLLING **************
    public void scrollToElement(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }
    
    
    
}

