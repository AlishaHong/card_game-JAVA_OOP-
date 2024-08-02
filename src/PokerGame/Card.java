package PokerGame;


enum Number{

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13);


    private final int value;

    Number(int value) {
        this.value = value;
    }

    int getNumberValue(Number number){
       return value;
    }


}

enum Kind{
    SPADE(1),
    DIAMOND(2),
    HEART(3),
    CLOVER(4);

    private final int value;

    Kind(int value) {
        this.value = value;
    }
    int getKindValue(Kind kind){
        return value;
    }



}
public class Card {

        //카드 무늬의 수 4
        static final int KIND_MAX= 4;
        //무늬별 카드 수 13
        static final int NUM_MAX = 13;
        // 각 무늬에 숫자를 부여함(1-4까지)
        static final int SPADE = 4;
        static final int DIAMOND = 3;
        static final int HEART = 2;
        static final int CLOVER = 1;
        Kind kind;
        Number number;




        Card(Kind kind, Number number){
            this.kind = kind;
            this.number = number;
        }


    @Override
    public String toString() {
        return "Card{" +
                "kind=" + kind +
                ", number=" + number +
                '}';
    }
}