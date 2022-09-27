package Constants;

import java.util.Random;

public interface TrelloConstants {

    public  String BOARDS_ENDPOINT = "";
    public  String GET_ENDPOINT = "";
    public  String PUT_ENDPOINT = "";
    public  String DELETE_ENDPOINT = "";



    String API_KEY="";
    String API_TOKEN="";

    String AUTH="key="+API_KEY+"&token="+API_TOKEN;

    String BOARD_ID="6330e5a5047a7c013af90868";
    String BoardName="MehmetFurkanBoard";
    String BOARD_NAME="name="+BoardName;


    default int numberGenerator(int low, int high) {

        Random r = new Random();
        int lowvalue = low;
        int highvalue = high;
        int result = r.nextInt(highvalue - lowvalue) + lowvalue;
        return result;
    }

    public default void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }



}
