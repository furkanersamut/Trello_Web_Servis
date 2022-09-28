package Constants;

import com.google.common.io.Resources;

import java.net.URL;
import java.util.Random;

public interface TrelloConstants {


    String API_KEY="fce429cdf1ee67cbfdc1545a3c99091f";
    String API_TOKEN="720b60874667b998252ea653abf4930529090aa0117cf48690140fb0dca84e18";

    URL CreateBoard_JSON = Resources.getResource("CreateBoard.JSON");
    URL CreateList_JSON = Resources.getResource("CreateList.JSON");
    URL CreateCard_JSON = Resources.getResource("CreateCard.JSON");
    URL DeleteBoard_JSON = Resources.getResource("DeleteBoard.JSON");
    URL DeleteCard_JSON = Resources.getResource("DeleteCard.JSON");
    URL UpdateCard_JSON = Resources.getResource("UpdateCard.JSON");


}
