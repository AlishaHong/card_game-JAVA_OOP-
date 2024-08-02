package PokerGame;


import java.awt.*;

public class Deck {
    //카드의 갯수 -> 52장
    final int CARD_NUM = 52;
    private static Deck deck = new Deck();
    public static Deck getInstance(){
        return deck;
    }
    //deck은 항상 생성하지 않고 싱글톤으로 구현하는것 해보기
    //getInstance메서드

    // 배열에 담기
    Card cardArr[] = new Card[CARD_NUM];

    // Deck 초기화
    Deck() {
        int i = 0;
        for (Kind kind : Kind.values()) {
            for (Number number : Number.values()) {
                cardArr[i++] = new Card(kind, number);
            }
        }
    }
    // 카드를 선택하는 메서드

    Card pick(int index){
        return cardArr[index];
    }

    Card pick(){
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }


    // 0번째 카드를 선택하는 메서드
    // 카드를 섞는 메서드

    void shuffle(){
        for(int i = 0; i < cardArr.length ; i++){
            int r = (int)(Math.random() * CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}
