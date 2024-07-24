package com.choucair.prueba.ui;



import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class RecruitmentPage extends PageObject {

    public static final Target BUTTON_ADD = Target.the("button add").located(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));

    public static final Target INPUT_FIRST_NAME = Target.the("input first name").located(By.name("firstName"));
    public static final Target INPUT_MIDDLE_NAME = Target.the("input middle name").located(By.name("middleName"));
    public static final Target INPUT_LAST_NAME = Target.the("input last name").located(By.name("lastName"));
    public static final Target VACANCY = Target.the("select vacancy").located(By.cssSelector("oxd-select-text oxd-select-text--active"));
    public static final Target LIST_VACANCY = Target.the("list of vacancy").locatedBy("//div[@class='oxd-select-text oxd-select-text--active']/div[@class='oxd-select-text--after']/i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    public static final Target OPTIONS_VACANCY = Target.the("options of vacancy").locatedBy("//div[@class='oxd-select-option']/span[text()='{0}']");

    public static final Target INPUT_EMAIL = Target.the("email input field")
    .locatedBy("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[label[text()='Email']]/following-sibling::div/input[@class='oxd-input oxd-input--active']");

    public static final Target INPUT_NUMBER = Target.the("phone input field")
    .locatedBy("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[label[text()='Contact Number']]/following-sibling::div/input[@class='oxd-input oxd-input--active']");

    public static final Target INPUT_KEYWORDS = Target.the("keywords input field")
    .locatedBy("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[label[text()='Keywords']]/following-sibling::div/input[@class='oxd-input oxd-input--active']");

    public static final Target TEXT_AREA_NOTES = Target.the("button notes").locatedBy("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");

    public static final Target CHECK_BOX_CONSENT = Target.the("check box consent").locatedBy("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");

    public static final Target BUTTON_SAVE = Target.the("button save").locatedBy("//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

   


    
            
    public static final Target INPUT_FILE = Target.the("input file").locatedBy("//input[@class='oxd-file-input']");
    public static final Target INPUT_DATE = Target.the("input date").locatedBy("//div[@class='oxd-date-input']/input[@placeholder='yyyy-dd-mm']");

    public static final Target BUTTON_DAY = Target.the("button day").locatedBy("//div[contains(@class, 'oxd-calendar-date') and text()='{0}']");

    public static final Target BUTTON_LIST_YEAR = Target.the("button list year").locatedBy("//li[@class='oxd-calendar-selector-year']");
    public static final Target BUTTON_YEAR = Target.the("button year").locatedBy("//li[contains(@class, 'oxd-calendar-dropdown--option') and text()='{0}']");

    public static final Target BUTTON_LIST_MONTH= Target.the("button list month").locatedBy("//li[@class='oxd-calendar-selector-month']");
    public static final Target BUTTON_MONTH= Target.the("button month").locatedBy("//li[contains(@class, 'oxd-calendar-dropdown--option')][{0}]");

    



    // Questions

    public static final Target BUTTON_CANDIDATES = Target.the("button candidates").locatedBy("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and text()='Candidates']");

    public static final Target BUTON_EXAMINAR = Target.the("btn examinar").locatedBy("(//div[@class='oxd-table-row oxd-table-row--with-border' and      .//div[text()='{0}'] and      .//div[text()='{1}'] and      .//div[text()='{2}'] and      .//div[text()='{3}']]//button[@class='oxd-icon-button oxd-table-cell-action-space' and .//i[@class='oxd-icon bi-eye-fill']])[1]");


    public static final Target LABAL_NAME = Target.the("label name candidate").locatedBy("//p[@class='oxd-text oxd-text--p' and text()='{0}']"); 

    public static final Target LABEL_CARD_VACANCY = Target.the("label card email").locatedBy("//div[@class='oxd-table-row oxd-table-row--with-border']     [descendant::div[@class='header' and text()='Candidate']/following-sibling::div[@class='data' and text()='{0}']]     //div[@class='header' and text()='Vacancy']/following-sibling::div[@class='data']");

    public static final Target LABEL_DATE_APLICATION = Target.the("label date aplication").locatedBy("div[@class='oxd-table-row oxd-table-row--with-border']     [descendant::div[@class='header' and text()='Candidate']/following-sibling::div[@class='data' and text()='{0}']]     //div[@class='header' and text()='Date of Application']/following-sibling::div[@class='data']");

    public static final Target LABEL_STATUS = Target.the("label status").locatedBy("//div[@class='orangehrm-recruitment-status']/p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']");

    public static final Target BTN_NEXT_PAGE = Target.the("button next page").locatedBy("//div[@class='orangehrm-recruitment-status']/p[@class='oxd-text oxd-text--p oxd-text--subtitle-2' and contains(. , '{0}')]");


    public static final Target ROW_CANDIDATE = Target.the("row candidate").locatedBy("(//div[@class='oxd-table-row oxd-table-row--with-border' and .//div[text()='{0}'] and .//div[text()='{1}'] and .//div[text()='{2}']]//div[text()='{3}'])[1]");


    // contratacion

    public static final Target BUTTON_SHORTLIST = Target.the("button shortlist").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success' and contains( ., 'Shortlist')]");

    public static final Target BUTTON_SCHEDULE_INTERVIEW = Target.the("button schedule").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success' and contains( ., 'Schedule Interview')]");



    public static final Target INPUT_INTERVIEW_TITLE = Target.the("input interview title").locatedBy("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[label[text()='Interview Title']]/following-sibling::div/input[@class='oxd-input oxd-input--active']");

    public static final Target INPUT_HOUR = Target.the("input hour").locatedBy("//input[@class='oxd-input oxd-input--active' and @placeholder='hh:mm']");

    public static final Target INPUT_INTERVIEWER = Target.the("input interviewer").locatedBy("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input");
    public static final Target INPUT_INTERVIEWER_OPTION = Target.the("input interviewer option").locatedBy("(//div[@class='oxd-autocomplete-option']/span)[1]");


    public static final Target BUTTON_INTERVIEW_PASEED = Target.the("button interview paseed").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success' and contains( ., 'Mark Interview Passed')]");
    public static final Target BUTTON_OFFERT_JOB = Target.the("button offert job").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success' and contains( ., 'Offer Job')]");
    public static final Target BUTTON_HIRE = Target.the("button offert job").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success' and contains( ., 'Hire')]");









    
}
