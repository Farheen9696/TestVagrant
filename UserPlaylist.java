import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class UserPlaylist {
    public static void main(String[] args) {
        String userName;
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayBlockingQueue<String>> userMap = new HashMap<>();
        while (true){
            System.out.println("**********Welcome to my playlist store***********");
            System.out.println("Pls enter your user name :");
            userName = scanner.nextLine(); 
            if (userMap.containsKey(userName)){  
                ArrayBlockingQueue<String> playlistSong = userMap.get(userName);
                userPlaylist(scanner,playlistSong);
            }else{
                ArrayBlockingQueue<String> songsStore = new ArrayBlockingQueue<>(3);
                userMap.put(userName,songsStore);
                userPlaylist(scanner,songsStore);
            }
        }
    }

    private static void userPlaylist(Scanner scanner,ArrayBlockingQueue<String> playlistSong) {
        System.out.println("Pls enter your song name :");
        String songName = scanner.nextLine();
        if (playlistSong.size() == 3){
            playlistSong.remove();
            playlistSong.offer(songName);
        }else{
            playlistSong.offer(songName);
        }
        System.out.println("Your recent play list:"+playlistSong);
    }
}
