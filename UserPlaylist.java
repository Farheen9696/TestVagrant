import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UserPlaylist {
    public static void main(String[] args) throws Exception{
        String userName;
        int n=3;
        Scanner scanner = new Scanner(System.in);
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        HashMap<String, Queue<String>> userMap = new HashMap<>();
        Queue<String> playlistSong=null;
        boolean choice=true;
        System.out.println("**********Welcome to my playlist store***********");
        System.out.println("Pls enter your user name :");
        userName = scanner.nextLine(); 
        while (choice){
            if (userMap.containsKey(userName)){  
                playlistSong = userMap.get(userName);
            }else{
                playlistSong = new LinkedList<>();
                userMap.put(userName,playlistSong);
                System.out.println(userMap.get(userName));
            }
            System.out.println("Enter song to add:");
            String song=br.readLine();
            if(playlistSong.size()==n) {
                playlistSong.remove();
            }
            playlistSong.add(song);
            System.out.println("do you want to add more:(0/1)");
            choice=scanner.nextInt()==0?false:true;
            System.out.println(userMap.get(userName));
        }
        scanner.close();
    }
}
