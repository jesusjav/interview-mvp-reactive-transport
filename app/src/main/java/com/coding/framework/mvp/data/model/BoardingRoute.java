package com.coding.framework.mvp.data.model;

import com.coding.framework.mvp.data.model.interfaces.SortInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class BoardingRoute implements SortInterface {

    private ArrayList<BoardingCards> boardingCards = new ArrayList<>();

    public void addBoardingCard(BoardingCards card){
        boardingCards.add(card);
    }

    public ArrayList<BoardingCards> getBoardingCards() {
        return boardingCards;
    }

    public void setBoardingCards(ArrayList<BoardingCards> boardingCards) {
        this.boardingCards = boardingCards;
    }

    /**
     * this is elegant but using recursivity, sometimes it could be dificult to track
     * and also the performance could be n(o2)
     *
     * acording to my measuring test, this is faster, see the time in junit test
     * @param index from where i start the search in array
     */
    @Override
    public void sort(int index) {
        for (int i = index; i< boardingCards.size(); i++) {
            for(int j = i+1; j < boardingCards.size(); j++ ){
                if(boardingCards.get(i).getDeparture().equals(boardingCards.get(j).arrival)){
                    Collections.swap(boardingCards, i, j);
                    sort(i);
                }
            }
        }
    }

    /**
     * This is more n(o) lineal but separate in two fors initialization
     * I separate departure and arrival in hash and find the init node, it's like an edge graph
     *
     * this is slower accordind to test, see junit results
     * @param
     */
    @Override
    public void sort(){
        HashMap<String, BoardingCards> departureHash = new HashMap<>();
        HashMap<String, BoardingCards>  arrivalHash = new HashMap<>();

        ArrayList<BoardingCards> ordererBaseBoardingCards = new ArrayList<>();

        for (BoardingCards card: boardingCards) {
            departureHash.put(card.getDeparture(), card);
            arrivalHash.put(card.getArrival(), card);
        }

        for (BoardingCards card: boardingCards) {
            if(!arrivalHash.containsKey(card.getDeparture())){
                ordererBaseBoardingCards.add(card);
                break;
            }
        }

        BoardingCards previousCard = ordererBaseBoardingCards.get(0);

        while(departureHash.containsKey(previousCard.getArrival())){
            ordererBaseBoardingCards.add(departureHash.get(previousCard.getArrival()));
            previousCard = ordererBaseBoardingCards.get(ordererBaseBoardingCards.size()-1);
        }

        boardingCards = ordererBaseBoardingCards;
    }
}
