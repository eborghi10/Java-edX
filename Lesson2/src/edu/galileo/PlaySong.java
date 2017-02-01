package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * playSong() can be defined here because it has
 * a "default" modifier.
 *
 * The "public" modifier is redundant
 *
 */
public interface PlaySong {

    default void playSong(String songName) {
        System.out.println("Playing " + songName);
    }
}
