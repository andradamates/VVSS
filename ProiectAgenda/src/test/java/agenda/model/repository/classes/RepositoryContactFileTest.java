package agenda.model.repository.classes;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RepositoryContactFileTest {

    RepositoryContactFile repo = new RepositoryContactFile();

    public RepositoryContactFileTest() throws Exception {
    }

    //TC1_EC
    @Test
    public void addContact1() {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume";
        telefon="+4071122334455";

        List<Contact> contactArrayList = repo.getContacts();
        int size = contactArrayList.size();

        Contact contact = null;
        try {
            contact = new Contact(nume, adresa, telefon);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        repo.addContact(contact);
        List<Contact> contactArrayList2 = repo.getContacts();
        int size2 = contactArrayList2.size();

        assertTrue(size2==size+1);


    }

    //TC3_EC
    @Test
    public void addContact2() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume Nume Nume Nume";
        telefon="+4078978900";

        //Contact contact = new Contact(nume, adresa, telefon);
        List<Contact> contactArrayList = repo.getContacts();
        int size = contactArrayList.size();
        Contact contact = null;
        try {
            contact = new Contact(nume, adresa, telefon);
            repo.addContact(contact);
            List<Contact> contactArrayList2 = repo.getContacts();
            int size2 = contactArrayList.size();
        } catch (InvalidFormatException e) {
            assertTrue(e.getMessage().equals("Cannot convert"));
        }

    }

    //TC5_EC
    @Test
    public void addContact3() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Name";
        telefon="95954 05, 990343";

        List<Contact> contactArrayList = repo.getContacts();
        int size = contactArrayList.size();
        Contact contact = null;
        try {
            contact = new Contact(nume, adresa, telefon);
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            assertTrue(e.getMessage().equals("Cannot convert"));
        }

    }


    //TC1_BVA
    @Test
    public void addContact4() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="";
        telefon="+4078978900";

        Contact contact = new Contact(nume, adresa, telefon);
        repo.addContact(contact);

    }


    //TC2_BVA
    @Test
    public void addContact5() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="N";
        telefon="+4078978900";

        Contact contact = new Contact(nume, adresa, telefon);
        repo.addContact(contact);

    }


    //TC7_BAV
    @Test
    public void addContact6() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume";
        telefon="";

        Contact contact = null;
        try {
            contact = new Contact(nume, adresa, telefon);
            repo.addContact(contact);
        }
        catch (Exception ex)
        {
          assertTrue(ex.getMessage().equals("String index out of range: 0"));
        }

    }


    //TC9_BVA
    @Test
    public void addContact7() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume";
        telefon="9";

        Contact contact = null;
        try {
            contact = new Contact(nume, adresa, telefon);
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            assertTrue(e.getMessage().equals("Cannot convert"));
        }

    }


    //TC13_BVA
    @Test
    public void addContact8() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume";
        telefon="078978900";

        Contact contact = new Contact(nume, adresa, telefon);
        repo.addContact(contact);

    }


    //TC12_BVA
    @Test
    public void addContact9() throws InvalidFormatException {

        String nume, telefon ,adresa;
        adresa="adr";
        nume="Nume";
        telefon="+407897890968770";

        Contact contact = new Contact(nume, adresa, telefon);
        repo.addContact(contact);

    }
}