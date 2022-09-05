package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utils.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class TEC_23_Steps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the element in the Left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String > listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size() ; i++) {
            ln.findAndClick(listElement.get(i));
        }

    }

    @And("Click on the element in Dialog Content")
    public void clickOnTheElementInDialogContent(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        GWD.Bekle(3);
        for (int i = 0; i < listElement.size() ; i++) {
            dc.findAndClick(listElement.get(i));

        }
    }

    @And("Sending the keys in Dilaog Content")
    public void sendingTheKeysInDilaogContent(DataTable elements) {
        List<List<String >> listElement = elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        }

    }

    @And("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage", "success");
    }

    @And("User delete item from Dialog Content")
    public void userDeleteItemFromDialogContent(DataTable elements) {

        List<String > listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {

            dc.SearchAndDelete(listElement.get(i));

        }
    }
}
