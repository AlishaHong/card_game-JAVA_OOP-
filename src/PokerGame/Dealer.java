package PokerGame;


import java.util.ArrayList;
import java.util.List;

public class Dealer {

    // 점수계산
    // 승자에게 점수와 게임머니를 추가해줌
    // 카드를 나눠주는걸 여기에서 해도될듯


    //240605

    //1. 카드 숫자별 점수를 정해두고
    //2. 5장의 카드 점수를 전부 합쳤을 때 점수가 높은사람이 이기는 방식으로 연습

    // 1-1 A는 1점 2는 2점 ... K는 13점!
    // 1-2 점수를 어떻게 저장해둘지 고민
    //      1안 if문..........
    //      2안 열거형
    //          --> 카드클래스에 enum클래스를 만들고 카드별 점수를 상수로 정의한다.

    //enum클래스에 카드종류와 숫자별로 value값을 담았음
    // 2-1 딜러클래스는 해당 점수를 모두 합하여 승자와 패자를 가르고
    // 2-2 승/패 수를 카운팅한다.

    Number number;
    Deck deck;
    List<Player> players;

    public Dealer(List<Player> players){
        this.players = players;
        this.deck = Deck.getInstance(); //deck 객체 불러오기
    }
    int num(Card card){
        return card.number.getNumberValue(number);
    }



    public List<Card> dealCard(){
        List<Card> cardList = new ArrayList<>();
        // players 배열에 담긴 각 플레이어에게 1번째 카드를 뽑아서 전달
        deck.shuffle();
        for(int i = 0; i < 5 ; i++){
//            for(Player player : players)
//                player.addCard(deck.pick(0));
            cardList.add(deck.pick(0));
            //카드를 한장 뽑아서 나눠준 뒤 다시 섞는다
//            System.out.println("pick : "+ deck.pick(0));
        } return cardList;
    }


    //연습용 카드게임 카드마다 점수를 붙이고 총 합을 더한 수가 가장 큰사람이 이기는 게임
    int countScore(){
        int sum = 0;
        int score = 0;
        List<Card> cardList = dealCard();
        for(Card card : cardList)
            sum += card.number.getNumberValue(number);
        score = sum;
        return score;
    }

    //리얼 포커게임!
    int countPokerScore(){

            // 카드리스트를 0번부터 4번까지 차례로 보면서  count[cards[i].number]++; 각 번호의 카운트를 추가해준다
            // 특정 숫자의 count가 2이면 동일한 숫자의 카드가 있다는 것!
            // 카운트[i]가 2이면 관련 변수를 1+ 한다.
            // 그 관련변수가 1이면 원페어 2면 투페어
            // 원페어 리턴 시 점수를 5점 / 투페이 리턴 시 점수를 10점
            // 그 외에는 숫자가 높은 카드가 나온 사람이 승자인걸로(동점시) kind를 숫자에 곱해서 중복을 피한다

        return 0;
    }


    //점수를 비교하는 메서드
    //players 배열에 담긴 객체들의 스코어중 가장 높은 객체의 게임머니와 승만 올린다.
    //나머지는 게임머니 그대로 패만 올린다.

    public void compareScores() {
        System.out.println(players);

        int highestScore = 0;
        int countHighest = 0;

        //최고점수찾기
        for(Player player : players){
            if(player.getScore() > highestScore){
                highestScore=player.getScore();
                countHighest = 1;
            }else if(player.getScore() == highestScore)
                countHighest++;
        }

        //countHighest가 1인 경우에만 승리처리

        for(Player player : players){
            if(player.getScore() == highestScore && countHighest == 1){
                player.recordWin();
            }else{
                player.recordLoss();
            }
        }
    }

    //최종승자를 출력하는 메서드
    public String whoIsWinner(){
        int win = 0;
        String winnerName = "";
        for(Player player : players){
            if(player.getWin() > win) {
                win = player.getWin();
                winnerName = player.getNickName();
            }
        }return winnerName;
    }
}
