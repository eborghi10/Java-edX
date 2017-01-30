package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 */
public interface PlaySong {
    public default void playSong(String songName) {
        System.out.println("Playing " + songName);
    }
}
