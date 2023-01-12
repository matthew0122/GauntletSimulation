import java.util.ArrayList;
public class GauntletsSim {
    public static void main(String[] args){
        double[] amts = new double[33];
        for(int i = 8; i <= 32; i++){
            int count = 0;
            for(int j = 0; j < 1000; j++){
                count += testGaunt(i);
            }
            amts[i] = count / 1000.0;
        }
        for(int i = 8; i <= 32; i++){
            System.out.println("Number: " + i + " took an average of " + amts[i] + " rounds to finish");
        }
    }
    public static int testGaunt(int i){
        int cnt = 0;
        ArrayList<Player> players = new ArrayList<>(i);
        for(int j = 1; j <= i; j++){
            players.add(new Player(j+""));
        }
        while(players.size() >= 8){
            strike(players);
            for(int k = 0; k < players.size(); k++){
                if(players.get(k).shouldBeRemoved()){
                    players.remove(k);
                    k--;
                }
            }
            cnt++;
            //System.out.println(players);
        }

        return cnt;
    }
    public static void strike(ArrayList<Player> players){
        int cuts = players.size() - (players.size()%8);
        int games = cuts / 8;
        double nonTie_avg = 1;
        for(int i = 0; i < games; i++){
            nonTie_avg *= .87;
        }
        cuts /=2;
        double big = (Math.random());
        if(big > nonTie_avg){
            cuts += 4;
        }
        
        ArrayList<Integer> dones = new ArrayList<>();
        for(int i = 0; i < cuts; i++){
            int num;
            do{
                num = (int)(Math.random() * players.size());
            }
            while(dones.contains(num));
            players.get(num).addStrike();
            dones.add(num);
        }
    }
}
