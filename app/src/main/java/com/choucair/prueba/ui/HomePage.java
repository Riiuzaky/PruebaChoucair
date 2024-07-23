package com.choucair.prueba.ui;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {
    
    public static final Target  ANCHOR_RECRUIMET = Target.the("anchor recruiment")
    .locatedBy("//nav/div/ul/li/a[@class='oxd-main-menu-item' and @href='/web/index.php/recruitment/viewRecruitmentModule']");
  
    
}
