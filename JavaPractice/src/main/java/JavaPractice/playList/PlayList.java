package JavaPractice.playList;


import java.util.ArrayList;
import java.util.Collections;


public class PlayList {
    private String listName; //This is the 'name' of your playList
    private ArrayList<String> songs;
    private ArrayList<Integer> stars; //how many stars each song has
    private ArrayList<String> artists;
    public final int MAX_NUMBER_SONGS;
    
    public PlayList(String name){
        MAX_NUMBER_SONGS = 20;
        listName = name;
        songs = new ArrayList<>();
        stars = new ArrayList<>();
        artists = new ArrayList<>();
    }
     
    // switches positions of these two
    public void swap(String song1, String artist1, String song2, String artist2){
        int found1 = -1;
        int found2 = -1;
        for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).equalsIgnoreCase(song1) && artists.get(x).equalsIgnoreCase(artist1)){
               found1 = x;
            }
            else if(songs.get(x).equalsIgnoreCase(song2) && artists.get(x).equalsIgnoreCase(artist2)){
                found2 = x;
            }
        }
        if(found1 > -1 && found2 > -1){
            String tempSong1 = songs.get(found1);
            String tempArtist1 = artists.get(found1);
            int tempStar1 = stars.get(found1);
            songs.set(found1, song2);
            artists.set(found1, artist2);
            stars.set(found1, stars.get(found2));
            songs.set(found2, tempSong1);
            artists.set(found2, tempArtist1);
            stars.set(found2, tempStar1);
        }
        else{
            System.out.println("Sorry both the song names and artists should be valid");
        }
        
    }
    
    public void renameList(String to){
        listName = to;
    }
    
    public void clearList(){
        songs.clear();
        artists.clear();
        stars.clear();
    }
    
    public boolean add(String song, String artist, int stars){
        if(MAX_NUMBER_SONGS <= songs.size()){
            System.out.println("Sorry, PlayList is full. You can't add a new song");
            return false;
        }
        this.songs.add(song);
        this.artists.add(artist);
        this.stars.add(stars);
        return true;
    }
    
    /**
     * This method is to remove the song from the PlayList
     * @param song the name of song
     * @param artist  the name of artist for the song
     */
    public void removeSong(String song, String artist){
        for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).equalsIgnoreCase(song) && artists.get(x).equalsIgnoreCase(artist)){
                songs.remove(x);
                artists.remove(x);
                int i = stars.remove(x);
            }
        }
    }
    
    public void removeArtist(String artist){
        for(int x = 0; x < songs.size(); x++){
            if(artists.get(x).equalsIgnoreCase(artist)){
                songs.remove(x);
                artists.remove(x);
                int i = stars.remove(x);
            }
        }
    }
    
    public void removeLowStars(int cutOff){
        ArrayList<String> tempSongs = new ArrayList<>(), tempArtist = new ArrayList<>();
        ArrayList<Integer> tempStars = new ArrayList<>();
        for(int x = 0; x < stars.size(); x++){
            if(stars.get(x) >= cutOff){
                tempSongs.add(songs.get(x));
                tempArtist.add(artists.get(x));
                tempStars.add(stars.get(x));
            }
        }
        songs = tempSongs;
        artists = tempArtist;
        stars = tempStars;
    }
    
    public void sortByRating(){
        ArrayList<Song> album = new ArrayList<>();
        for(int x = 0; x < artists.size(); x++){
            album.add(new Song(songs.get(x), artists.get(x), stars.get(x)));
        }
        Collections.sort(album, (a, b) -> b.rate - a.rate);
        ArrayList<String> tempSongs = new ArrayList<>(),
                          tempArtists = new ArrayList<>();
        ArrayList<Integer> tempStars = new ArrayList<>();
        album.forEach(x -> {
            tempSongs.add(x.songName);
            tempArtists.add(x.artist);
            tempStars.add(x.rate);
        });
        songs = tempSongs;
        artists = tempArtists;
        stars = tempStars;
    }
    
    PlayList shuffle(){
        ArrayList<Song> album = new ArrayList<>();
        
        for(int x = 0; x < songs.size(); x++){
            album.add(new Song(songs.get(x), artists.get(x), stars.get(x)));
        }
        
        Collections.shuffle(album);
        PlayList newOne = new PlayList(listName);
        ArrayList<String> tempSongs = new ArrayList<>(), tempArtists = new ArrayList<>();
        ArrayList<Integer> tempStars = new ArrayList<>();
        
        album.forEach(song -> {
            tempSongs.add(song.songName);
            tempArtists.add(song.artist);
            tempStars.add(song.rate);
        });
        newOne.songs = tempSongs;
        newOne.artists = tempArtists;
        newOne.stars = tempStars;
        return newOne;
    }
    
    
    public String getName(){
        return listName;
    }
    
    public ArrayList<String> getArtist(String song){
         ArrayList<String> theArtists = new ArrayList<>();
         for(int x = 0; x < songs.size(); x++){
            if(songs.get(x).equals(song)){
                theArtists.add(artists.get(x));
            }
         }
         return theArtists;
    }
    
    public ArrayList<String> getSongs(String artist){
        ArrayList<String> theSongs = new ArrayList<>();
         for(int x = 0; x < artists.size(); x++){
            if(artists.get(x).equalsIgnoreCase(artist)){
                theSongs.add(songs.get(x));
            }
         }
         return theSongs;
    }
    
    public int getStars(String artist, String song){
        for(int x = 0; x < songs.size(); x++){
            if(artists.get(x).equalsIgnoreCase(artist) && songs.get(x).equalsIgnoreCase(song)){
               return stars.get(x);
            }
        }
        return 0;
    }
    
    public int spacesLeft(){
        return MAX_NUMBER_SONGS - songs.size();
    }
    
    public double averageRating(){
        double ave = 0;
        for(int x : stars){
            ave += x;
        }
        return ave / stars.size();
    }
    
    public int numSongsByArtist(String musician){
        int count = 0;
        for(String s : artists){
            if(s.equalsIgnoreCase(musician)) count++;
        }
        return count;
    }
    
    public double averageRating(String artist){
        double ave = 0;
        int count = 0;
        for(int x = 0; x < artists.size(); x++){
            if(artists.get(x).equalsIgnoreCase(artist)){
                ave += stars.get(x);
                count++;
            }
        }
        return ave / count;
    }
    
    public String getMusician(String artist){
        StringBuilder temp = new StringBuilder();
        for(int x = 0; x < artists.size(); x++){
            if(artists.get(x).equalsIgnoreCase(artist)){
                temp.append("{Song: ").append(songs.get(x)).append(", Stars: ").append(stars.get(x)).append("}\n");
            }
        }
        return temp.toString();
    }
    
    public void printRating(int starRating){
        System.out.println("=======================================");
        System.out.println("Songs that have " + starRating + " rating");
        System.out.println("=======================================");
        for(int x = 0; x < stars.size(); x++){
            if(stars.get(x) == starRating){
                System.out.println("Song: " + songs.get(x) + ", Artist : " + artists.get(x));
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        for(int x = 0; x < songs.size(); x++){
            temp.append("{Song Name: ").append(songs.get(x)).append(", Artist:").append(artists.get(x)).append(", Stars: ").append(stars.get(x)).append("}\n");
        }
        return temp.toString();
    }
    
    
    private class Song{
        String songName, artist;
        int rate;
        public Song(String song, String artist, int rate){
            songName = song;
            this.artist = artist;
            this.rate = rate;
        }
    }
}
