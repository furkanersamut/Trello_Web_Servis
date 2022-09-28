package TestCases.Test;


import Constants.Trello_Variables;
import TestCases.Steps.Trello_API;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Java program select a random element from array


public class TrelloTests extends Trello_Variables {

    private Trello_Variables idboard;
    private Trello_Variables idlist;
    private Trello_Variables idcard;
    private Trello_API trelloApi;



    @Test
    public void T01_Trello() throws IOException {
        trelloApi = new Trello_API();
        TrelloTests obj = new TrelloTests();

        List<String> list = new ArrayList<>();

        trelloApi.createBoard("ErsamutMehmet");
        idboard = trelloApi.getIBoardObject();
        trelloApi.createList("List Furkan", idboard.getidBoard());
        idlist = trelloApi.getIdListObject();
        trelloApi.createCard("Card Furkan", idlist.getidList());
        idcard = trelloApi.getIdCardObject();
        list.add(trelloApi.getIdCardObject().getidCard());
        trelloApi.createCard("Card Mehmet", idlist.getidList());
        idcard = trelloApi.getIdCardObject();
        list.add(trelloApi.getIdCardObject().getidCard());
        trelloApi.updateCard(idcard.getidCard(),"New Card");
        trelloApi.delete_Card(list.get(0));
        trelloApi.delete_Card(list.get(1));
        trelloApi.deleteBoard(idboard.getidBoard());


    }

    public String getRandomElement(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }


}
