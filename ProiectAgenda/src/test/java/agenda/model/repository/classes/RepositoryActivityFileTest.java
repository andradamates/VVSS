package agenda.model.repository.classes;

import agenda.model.base.Activity;
import agenda.model.base.Contact;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class RepositoryActivityFileTest {

    @Test
    public void getActivitiesByName() throws Exception {
        RepositoryContactFile repositoryContactFile = new RepositoryContactFile();
       RepositoryActivityFile repositoryActivityFile =new RepositoryActivityFile(repositoryContactFile);
        String nume = "Andrei";
        List<Activity> list = new LinkedList<>();
        assertTrue(list.size()==0);
        list = repositoryActivityFile.getActivitiesByName(nume);
        System.out.println(list.size());
        assertTrue(list.size()==0);

    }

    @Test
    public void getActivitiesByName1() throws Exception {
        RepositoryContactFile repositoryContactFile = new RepositoryContactFile();
        RepositoryActivityFile repositoryActivityFile =new RepositoryActivityFile(repositoryContactFile);
        String nume = "name1";
        List<Activity> list = new LinkedList<>();
        assertTrue(list.size()==0);
        list = repositoryActivityFile.getActivitiesByName(nume);
        assertTrue(list.size()==2);
    }

    @Test
    public void addActivity() throws Exception {
        RepositoryContactFile repositoryContactFile = new RepositoryContactFile();
        RepositoryActivityFile repositoryActivityFile =new RepositoryActivityFile(repositoryContactFile);

        assertTrue(repositoryActivityFile.count()==3);

        Date d1 = new Date(2019, 7, 5,20, 13);
        Date d2 = new Date(2019, 7, 6, 10, 50);

        List<Contact> contacts = new ArrayList<>();
        Contact c = new Contact();
        contacts.add(c);
        Activity a = new Activity("name4", d1, d2, contacts, "dscription");

        repositoryActivityFile.addActivity(a);

        assertTrue(repositoryActivityFile.count() == 4);
    }


    @Test
    public void addActivity1() throws Exception {
        RepositoryContactFile repositoryContactFile = new RepositoryContactFile();
        RepositoryActivityFile repositoryActivityFile =new RepositoryActivityFile(repositoryContactFile);

        assertTrue(repositoryActivityFile.count()==3);

        Date d1 = new Date(0, 7, 5,20, 13);
        Date d2 = new Date(0, 7, 6, 10, 50);

        List<Contact> contacts = new ArrayList<>();
        Contact c = new Contact();
        contacts.add(c);
        Activity a = new Activity("name4", d1, d2, contacts, "dscription");

        repositoryActivityFile.addActivity(a);

        System.out.println(repositoryActivityFile.count());
        //assertTrue(repositoryActivityFile.count() == 3);
    }

}