package com.muharyman.weather;

import androidx.fragment.app.Fragment;

import com.muharyman.weather.view.page.Adapter;
import com.muharyman.weather.view.page.Fragment1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void kelvintoCelcius(){
        Fragment1 fragment1 = new Fragment1();
        int celcius = fragment1.convertKelvinToCelcius(293);
        Assert.assertTrue(celcius==20);
    }


}