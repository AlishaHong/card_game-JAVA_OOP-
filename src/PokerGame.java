import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class PokerGame {
        public static void main(String[] args) {


            // 플레이어수 입력받기
            // 플레이어 닉네임 입력받기


            //클래스별로 파일분류
            //테스트 클래스 별도로 만들기


            // 카드게임

            // 룰 설명

            //1-1. 한벌의 카드 사용
            // -> Deck 클래스
            //1-2. 카드 한벌은 52장의 카드로 구성
            // -> Card 클래스

            //2-1. 최대 4명의 플레이어가 참가
            // -> Player 클래스
            //2-2. 각 참가자에게 게임머니 10000원이 제공
            //    int gameMoney
            //2-3. 각 참가자에게는 고유한 nickname이 있다
            //    String nickName(최대20자)

            //3-1. 딜러는 플레이어에게 서로다른 5장의 카드를 준다
            // a.카드를 섞고
            // b.제일 위에있는 카드를 선택

            // 1안
            // c.플레이어 수만큼 5번 반복
            // 2안
            // d.플레이어 수 만큼의 cards 객체를 5개 생성
            // 2명/3명/4명용 카드 생성자를 만든다
            //3안
            //배열?
            // 3-2. 딜러는 플레이어의 카드를 평가하고 결과를 점수로 반환
            // 3-3. 매게임마다 딜러는 각 플레이어의 카드를 평가하여 결과출력

            //4-1. 승리 시 게임머니 +100원 / 1승 추가
            //4-2. 나머지 플레이어는 게임머니 +0원 / 1패 추가

            //5-1. 100번 게임 자동 반복
            //5-2. 승리의 수가 많은 플레이어부터 내림차순으로 정렬하여 출력

            Deck deck = new Deck();

            Scanner scanner =  new Scanner(System.in);





        }
    }

        class Deck{
            //카드의 갯수 -> 52장
            final int CARD_NUM = 52;

            // 배열에 담기
            Card cardArr[] = new Card[CARD_NUM];

            // 카드 초기화

            Deck() {

                int i = 0;

                for (int k = Card.KIND_MAX; k > 0; k--)
                    for (int n = 0; n < Card.NUM_MAX; n++)
                        cardArr[i++] = new Card(k, n + 1);
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


        class Card{

            //카드 무늬의 수 4
            static final int KIND_MAX= 4;
            //무늬별 카드 수 13
            static final int NUM_MAX = 13;
            // 각 무늬에 숫자를 부여함(1-4까지)
            static final int SPADE = 4;
            static final int DIAMOND = 3;
            static final int HEART = 2;
            static final int CLOVER = 1;
            int kind;
            int number;


            Card(int kind, int number){
                this.kind = kind;
                this.number = number;
            }

        public String toString(){
            String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
            String numbers = "A23456789XJQK";

            return "kind : " + kinds[this.kind] + "number : "+ numbers.charAt(this.number);
            }


        }

        class Player{

            //4명의 플레이어

            //게임머니 10000원
            int gameMoney = 10000;
            //승리 시 100원 추가
            // gameMoney += 100
            // 승/패 카운팅
            int win = 0;
            // 승리 시 1승 추가
            // win += 1;
            int lose = 0;
            //나머지는 1패 추가
            // lose += 1;

            //각 플레이어가 받은 카드를 담을 배열
            //EachCard배열(리스트)
            //List eachCard = new ArrayList();


            //addCard메서드
            //카드들을 담는 배열에 카드를 더해준다
            //void addCard(Card card){
            //  eachCard.add(card))
            // }
            //5번 반복

        }

        class Game{

            Deck deck = new Deck();
            Game(int playerNum){
                List players = new ArrayList();
                for(int i = 0; i < playerNum; i++){
                    players.add(new Player());
                }
            }
            //카드게임에 앞서 플레이어를 생성하고
            //카드를 나눠주는 딜러겸 컨트롤러의 역할을 하게함
            //메인메서드에서 이 클래스의 객체를 생성한다
            // Game game = new Game(numPlayers);
            // numPlayers는 사용자에게 입력받은 플레이어 수
            // 2인 이상 4인이하만 가능하도록 검증필수


            //1, 플레이어를 숫자에 맞춰 생성
            //2. 카드를 섞는다
            //3. 각각의 플레이어에게 카드를 나눠준다.




            //플레이어를 생성하고 각 플레이어에게 카드를 나눠줌


            // List players = new ArrayList();


            //1, 플레이어를 숫자에 맞춰 생성
            //Game(int numPlayers){
            //players = new ArrayList<>();
            //for (int i = 0; i < numPlayers; i++) {
            //    players.add(new Player());
            // }



            //2. 카드를 섞는다
            // deck.shuffle();
            //카드 초기화와 shuffle 메서드는 deck 클래스에 정의 예정



            //3. 각각의 플레이어에게 카드를 나눠준다.
            //카드를 나눠주는 메서드
            //void dealCard(){
            // for(int i = 0; i < 5; i++)
            //  for(Player player : players)
            //      player,addCard(deck.pick(0)); (player클래스에 eachCard 리스트가 있어서 그 리스트에 담아준다.)
            //      playes리스트의 모든 플레이어에게 5장의 카드를 나눠준다.}

        }



        class dealer{

            // 점수계산
            // 승자에게 점수와 게임머니를 추가해줌
            // 카드를 나눠주는걸 여기에서 해도될듯

        }




