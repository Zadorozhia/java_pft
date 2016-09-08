package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list=new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test100").withHeader("header100")
                          .withFooter("footer100")});
    list.add(new Object[]{new GroupData().withName("test200").withHeader("header200")
            .withFooter("footer200")});
    list.add(new Object[]{new GroupData().withName("test300").withHeader("header300")
            .withFooter("footer300")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {

    app.goTo().groupPage();
    Groups before=app.group().all();

    app.group().create(group);
    assertThat(app.group().count(),equalTo( before.size()+1));
    Groups after=app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withtId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}
