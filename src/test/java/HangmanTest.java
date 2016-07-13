import org.junit.Test;

import static java.lang.System.out;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Tiger on 2016/7/11.
 */
public class HangmanTest {
    @Test
    public void should_get_attribute_when_the_word_is_apple(){
        Hangman hangman = new Hangman("apple");
        assertThat(hangman.word_length(),is(5));
        assertThat(hangman.show_word(),is("apple"));
        assertThat(hangman.incompleter_word(),is("a___e"));
        assertThat(hangman.Times(),is(6));
    }
    @Test
    public void should_get_attribute_when_the_word_is_orange(){
        Hangman hangman = new Hangman("orange");
        assertThat(hangman.word_length(),is(6));
        assertThat(hangman.show_word(),is("orange"));
        assertThat(hangman.incompleter_word(),is("o_a__e"));
        assertThat(hangman.Times(),is(7));
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_p(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        assertThat(hangman.guessed_chars(),is("aeioup"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.show_current_word(),is("app_e"));
        out.println("5555t");
        out.println("dddddddddd");
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_e(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('e');
        assertThat(hangman.guessed_chars(),is("aeioup"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.show_current_word(),is("app_e"));
        assertThat(hangman.Game_Status(),is("you need to continue"));
        out.println("4444");
    }
    @Test
    public void shuold_get_guessWord_status_when_guess_the_word_is_l(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('l');
        assertThat(hangman.guessed_chars(),is("aeioul"));
        assertThat(hangman.Times(),is(5));
        assertThat(hangman.show_current_word(),is("a__le"));
        assertThat(hangman.Game_Status(),is("you need to continue"));
        out.println("3333");
    }

    @Test
    public void shuold_get_successful_status_when_guess_the_word_is_p_and_l(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('l');
        assertThat(hangman.guessed_chars(),is("aeioupl"));
        assertThat(hangman.Times(),is(4));
        assertThat(hangman.show_current_word(),is("apple"));
        assertThat(hangman.Game_Status(),is("you are successful"));
        out.println("22222");
    }
    @Test
    public void shuold_get_failed_status(){
        Hangman hangman = new Hangman("apple");
        hangman.guess('p');
        hangman.guess('f');
        hangman.guess('k');
        hangman.guess('m');
        hangman.guess('c');
        hangman.guess('s');
        assertThat(hangman.guessed_chars(),is("aeioup"));
        assertThat(hangman.Times(),is(0));
        assertThat(hangman.show_current_word(),is("app_e"));
        assertThat(hangman.Game_Status(),is("you have failed"));
        out.println("11111");
    }
}