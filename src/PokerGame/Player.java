package PokerGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //게임머니 10000원
    int gameMoney = 10000;
    //승리 시 100원 추가
    // gameMoney += 100
    // 승/패 카운팅
    int win = 0;
    // 승리 시 1승 추가
    int lose = 0;
    //나머지는 1패 추가
    int score = 0;

    List<List<Card>> playerCard = new ArrayList();
    String nickName;


    // 플레이어 생성자 추가하기

    public Player(){

    }

    public Player(String nickName){
        this.nickName = nickName;
        this.playerCard = new ArrayList<>();
        this.score = 0;
        this.win = 0;
        this.lose = 0;
    }



    //addCard메서드
    //카드들을 담는 배열에 카드를 더해준다
    //5번 반복
    void addCard(List<Card> card){
      playerCard.add(card);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickName() {
        return nickName;
    }

    //승리횟수 확인을 위한 게터
    public int getWin() {
        return win;
    }

    public void recordWin() {
        this.win++;
        this.gameMoney += 100;
    }

    public void recordLoss() {
        this.lose++;
    }


    @Override
    public String toString() {
        return "Player{" +
                "gameMoney=" + gameMoney +
                ", win=" + win +
                ", lose=" + lose +
                ", score=" + score +
                ", playerCard=" + playerCard +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
