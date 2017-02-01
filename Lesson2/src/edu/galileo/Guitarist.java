package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * An interface can extend another interface!
 *
 */
public interface Guitarist extends PlaySong{

    default void playFavouriteSong() {
        // Inside this method we are invoking the method playSong()
        System.out.println("Playing my favourite song");
        playSong("My first song");
    }
}
