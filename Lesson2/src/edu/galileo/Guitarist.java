package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 */
public interface Guitarist extends PlaySong{
    public default void playFavouriteSong() {
        // Inside this method we are invoking the method playSong()
        System.out.println("Playing my favourite song");
        playSong("My first song");
    }
}
