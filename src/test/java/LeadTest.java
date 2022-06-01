import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static classes.Lead.addLeadToList;
import static classes.Lead.removeLead;
import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {

    @Test
    @DisplayName("test add Lead to List with null input")
    public void addLeadToListTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            addLeadToList(null);
        });
    }

    @Test
    @DisplayName("Test to check if can remove Lead with a null input")
    public void removeLeadTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            removeLead(null);
        });
    }

    @Test                                                               //falta la lógica de los Tests
    @DisplayName("Test to check if setEmployeeCount is an Integer")
    public void setEmployeeCountTest(){
        assertThrows();
    }@Test
    @DisplayName("Test to check if setCity is a String")
    public void setCityTest(){
        assertThrows();
    }
    @Test
    @DisplayName("Test to check if setCountry is a String")
    public void setCityTest(){
        assertThrows();
    }
    @Test
    @DisplayName("Test to check if setEmployeeCount is an Integer")
    public void setEmployeeCountTest(){
        assertThrows();
    }






}
