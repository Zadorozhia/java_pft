package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Виктория on 30.07.2016.
 */
public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();

    if(app.group().all().size()==0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification(){

    Groups before=app.group().all();
    GroupData modifiedGroup=before.iterator().next();
    GroupData group=new GroupData()
            .withtId(modifiedGroup.getId())
            .withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    assertThat(app.group().count(),equalTo( before.size()));
    Groups after=app.group().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
