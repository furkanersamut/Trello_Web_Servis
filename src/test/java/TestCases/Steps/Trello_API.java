package TestCases.Steps;


import Base.TestBase;
import Constants.TrelloConstants;
import Constants.Trello_Variables;
import com.google.common.io.Resources;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import variables.Var;

import java.io.IOException;
import java.nio.charset.Charset;

import static io.restassured.RestAssured.given;

public class Trello_API extends TestBase implements TrelloConstants {


    Trello_Variables idboard = new Trello_Variables();
    public Trello_Variables getIBoardObject(){
        return this.idboard;
    }
    public static Logger logger;

    Trello_Variables idlist = new Trello_Variables();
    public Trello_Variables getIdListObject(){
        return this.idlist;
    }

    Trello_Variables idcard = new Trello_Variables();
    public Trello_Variables getIdCardObject(){
        return this.idcard;
    }

    public String createCard(String CardName,String Listid) throws IOException {
        String KeyJSONBody = Resources.toString(CreateCard_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("idList",Listid);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        KeyJSON.put("name",CardName);

        String createCardJSON=KeyJSON.toString();
        System.out.println(createCardJSON);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(createCardJSON)
                        .post(Var.apiUrl+"/1/cards")
                        .then()
                        .statusCode(200)
                        .extract().response();

        String idCard = response.path("id");
        //    logger.info("Created Card. Card id:"+idCard);

        idcard.setidCard(idCard);
        return idCard;
    }


    public String createBoard(String boardName) throws IOException {

        String KeyJSONBody = Resources.toString(CreateBoard_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        KeyJSON.put("name",boardName);
        String createBoardJSON=KeyJSON.toString();
        System.out.println(createBoardJSON);
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(createBoardJSON)
                        .post(Var.apiUrl+"/1/boards/")
                        .then()
                        .statusCode(200)
                        .extract().response();


        String idBoard = response.path("id");
//        logger.info("Created Board. Board id:"+ idBoard);

        JSONObject idboardd= new JSONObject();
        idboard.setidBoard(idBoard);

        return idBoard; }

    public String createList(String listName , String idBoard) throws IOException {

        String KeyJSONBody = Resources.toString(CreateList_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        KeyJSON.put("name",listName);
        KeyJSON.put("idBoard",idBoard);
        String createListJSON=KeyJSON.toString();

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(createListJSON)
                        .post(Var.apiUrl+"/1/lists")
                        .then()
                        .statusCode(200)
                        .extract().response();

        String idList = response.path("id");
        // logger.info("Deleted List. List id:"+idList);

        idlist.setidList(idList);
        return idList;

    }

    public String deleteBoard(String boardid) throws IOException {
        String KeyJSONBody = Resources.toString(DeleteBoard_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        String deleteBoardJSON=KeyJSON.toString();
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(deleteBoardJSON)
                        .delete(Var.apiUrl+"/1/boards/"+boardid)
                        .then()
                        .statusCode(200)
                        .extract().response();
        // logger.info("Deleted Board. Board id:"+boardid);

        String delete_Board = "Board deleted";
        return delete_Board;
    }


    public String delete_Card(String cardid) throws IOException {
        String KeyJSONBody = Resources.toString(DeleteCard_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        String deleteCaredJSON=KeyJSON.toString();
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(deleteCaredJSON)
                        .delete(Var.apiUrl+"/1/cards/"+cardid)
                        .then()
                        .statusCode(200)
                        .extract().response();
        //  logger.info("Deleted Card. Card id:"+idcard);

        String delete_Card = "Card deleted";
        return delete_Card;
    }


    public String updateCard(String cardid, String newCardName) throws IOException {

        String KeyJSONBody = Resources.toString(UpdateCard_JSON, Charset.defaultCharset());
        JSONObject KeyJSON= new JSONObject(KeyJSONBody);
        KeyJSON.put("key",API_KEY);
        KeyJSON.put("token",API_TOKEN);
        KeyJSON.put("name",newCardName);

        String updateCardJSON=KeyJSON.toString();
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(updateCardJSON)
                        .put(Var.apiUrl+"/1/cards/"+cardid)
                        .then()
                        .statusCode(200)
                        .extract().response();

        //  logger.info("Updated Card. Card id:"+idcard);

        String idCard = response.path("id");
        return idCard;
    }




}