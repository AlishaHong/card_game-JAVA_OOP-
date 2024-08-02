package PokerGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //TODO
        // 플레이어수 입력받기
        // 플레이어 닉네임 입력받기
        // 클래스별로 파일분류
        // 테스트 클래스 별도로 만들기


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



        Game game = new Game();

    }


            //카드게임에 앞서 플레이어를 생성하고
    //카드를 나눠주는 딜러겸 컨트롤러의 역할을 하게함
    //메인메서드에서 이 클래스의 객체를 생성한다
    // Game game = new Game(playerNum);
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



    static List<Player> players = new ArrayList<>();

    Dealer dealer = new Dealer(players);
    //deck은 항상 생성하지 않고 싱글톤으로 구현하는것 해보기
    //getInstance메서드

    Game() {

        //1. 게임과 사용자 초기화
        initializePlayers();

        //2. 총 100번의 게임진행
        for(int i = 0; i < 99 ; i++){
            playGame();
            //카드의 점수를 계산하는 메서드 호출
            //점수계산 + 게임머니 + 승패 저장
            dealer.compareScores();
            displayWinCounts();
        }
        displayWinner();
    }


    //사용자 초기화 및 게임 초기화 메서드
   private void initializePlayers(){
        int playerNum;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("플레이어 수를 입력해주세요(2인 이상/4인 이하)");
            playerNum = scanner.nextInt();
            if (playerNum < 2 || playerNum > 4) {
                System.out.println("플레이어는 2인 이상 4인 이하로 입력해주세요");
                continue;
            } else{
                System.out.println(playerNum + "인 게임을 시작합니다.");
                break;
            }
        }

    //플레이어 인원수 만큼 닉네임 입력받기
        for (int i = 0; i < playerNum; i++) {
            String nickName = "";
            boolean validNickName = false;

            while(!validNickName) {
                System.out.println("Player " + (i + 1) + "의 닉네임을 입력해주세요");
                nickName = scanner.next();

                if (nickName.length() > 0 && nickName.length() <= 20) {
                    validNickName = true;
                    players.add(new Player(nickName));
                    System.out.println("Player " + (i + 1) + "의 닉네임은 " + nickName + "입니다.");
                } else System.out.println("1자 이상 20자 이하의 닉네임을 입력해주세요");
            }
        }
    }


    //점수판 보여주기
    private void displayWinCounts() {
        System.out.println("승리횟수 확인");
        for (Player player : players) {
            System.out.println(player.getNickName() + "님 : " + player.getWin() + "판 승! 게임머니 : " + player.gameMoney + "원");
        }
    }

    //최종승자출력
    private void displayWinner(){
        System.out.println("최종 승자는 " + dealer.whoIsWinner() + "님 입니다.");
    }



    //카드 나눠주고 점수계산하는 본게임
    private void playGame(){

    for(Player player : players){
        player.addCard(dealer.dealCard());
        player.setScore(dealer.countScore());
        }
    }


    //포커게임
    private void playPokerGame(){

    }
}